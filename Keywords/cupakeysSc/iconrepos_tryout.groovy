package cupakeysSc

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

public class iconrepos_tryout {
	
	@Keyword
	def iconreposition(int reposx, int reposy, LoadTimeCorrector, step, run, device, timeStamp){
	int timed
	if(WebUI.waitForElementVisible(findTestObject('CuPaSc/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaSc/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaSc/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaSc/Icons/Reposition_icon'), reposx, reposy)
	//WebUI.dragAndDropByOffset(findTestObject('CuPaSc/Icons/Reposition_icon'), WebUI.getViewportLeftPosition() + reposx,
	//WebUI.getViewportTopPosition() + reposy)
	long start = System.currentTimeMillis()
	if (WebUI.waitForElementVisible(findTestObject('CuPaSc/Loading_indicator'), 3)==false){
			timed = 1
		}
	else {
		WebUI.waitForElementNotVisible(findTestObject('CuPaSc/Loading_indicator'), 30)
		timed = 2
		}
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_iconreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

}

