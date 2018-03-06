package cupakeysDs

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

public class txtrepos {
	
	@Keyword
	def textreposition (int reposx, int reposy, LoadTimeCorrector, step, run, device){
	int timed
	WebUI.click(findTestObject('CuPaDs/Texts/Resize_text'))
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Reposition_text'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Texts/Resize_text'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Reposition_text'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Texts/Reposition_text'), reposx, reposy)
	//WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Texts/Reposition_text'), WebUI.getViewportLeftPosition() + reposx,
		//WebUI.getViewportTopPosition() + reposy)
	long start = System.currentTimeMillis()
	if (WebUI.waitForElementVisible(findTestObject('CuPaDs/Loading_indicator'), 3)==false){
			timed = 1
		}
		else {
			WebUI.waitForElementNotVisible(findTestObject('CuPaDs/Loading_indicator'), 30)
			timed = 2
		}
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_textreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

}
