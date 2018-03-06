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

public class chngstruct {
	
	@Keyword
	def changestructure(String structure, LoadTimeCorrector, step, run, device, timeStamp){
		int timed
		
		WebUI.click(findTestObject('CuPaDl/Structure/Structure'))
		WebUI.waitForElementVisible(findTestObject('CuPaDl/Structure/Structure_Hahnentritt'), 0)
		//WebUI.delay(1)
		if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Structure/Structure_'+structure), 2)==true){
			WebUI.click(findTestObject('CuPaDl/Structure/Structure_'+structure))
		}
		else{
			WebUI.click(findTestObject('CuPaDl/MenuScroll/ObjectsScrollRight'))
			WebUI.delay(2)
			WebUI.click(findTestObject('CuPaDl/Structure/Structure_'+structure))
		}
		//WebUI.click(findTestObject('CuPaDl/Structure/Structure_'+structure))
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
		out.println("Step_" + step + "_structureChange_" + structure + ": " + elapsedTimeSec);
		out.close();
		WebUI.delay(1)
		step++
	}

}
