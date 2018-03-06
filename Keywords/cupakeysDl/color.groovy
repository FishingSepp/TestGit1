package cupakeysDl

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class color {
	
	@Keyword
	def changecolor(String color, LoadTimeCorrector, step, run, device, timeStamp) {
		int timed
		if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Color/Color'), 2)==true){
			WebUI.click(findTestObject('CuPaDl/Color/Color'))
		}
		else{
			WebUI.click(findTestObject('CuPaDl/MenuScroll/MenuScrollLeft'))
			WebUI.delay(1)
			WebUI.click(findTestObject('CuPaDl/Color/Color'))
		}
		WebUI.delay(1)
		if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Color/Color_'+color), 2)==true){
			WebUI.click(findTestObject('CuPaDl/Color/Color_'+color))
		}
		else{
			WebUI.click(findTestObject('CuPaDl/MenuScroll/ObjectsScrollRight'))
			WebUI.delay(2)
			WebUI.click(findTestObject('CuPaDl/Color/Color_'+color))
		}
		//WebUI.click(findTestObject('CuPaDs/Color/Color'))
		WebUI.waitForElementVisible(findTestObject('CuPaDl/Color/Color_'+color), 0)
		WebUI.delay(1)
		WebUI.click(findTestObject('CuPaDl/Color/Color_' + color))
		long start = System.currentTimeMillis()
		if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Loading_indicator'), 3)==false){
			timed = 1
		}
		else {
			WebUI.waitForElementNotVisible(findTestObject('CuPaDl/Loading_indicator'), 30)
			timed = 2
		}	
		
		long elapsedTimeMillis = System.currentTimeMillis() - start
		float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
		if (timed == 1) {
			out.println("Step_" + step + "_colorChange_" + color + ": 0.1");
			out.close();
		}
		else{		
			out.println("Step_" + step + "_colorChange_" + color + ": " + elapsedTimeSec);
			out.close();
		}
		WebUI.delay(1)
		step++
	}

}
