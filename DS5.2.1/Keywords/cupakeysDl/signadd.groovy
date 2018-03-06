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

public class signadd {
	
	@Keyword
	def signatureadd (int thickness, LoadTimeCorrector, step, run, device, timeStamp){
	int timed
	if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Signature'), 2)==true){
		WebUI.click(findTestObject('CuPaDl/Signature/Signature'))
	}
	else{
		WebUI.click(findTestObject('CuPaDl/MenuScroll/ScrollRight'))
		WebUI.delay(1)
		WebUI.click(findTestObject('CuPaDl/Signature/Signature'))
	}
	//WebUI.click(findTestObject('CuPaDl/Signature/Signature'))
	WebUI.waitForElementClickable(findTestObject('CuPaDl/Signature/Add_Signature'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Signature/Add_Signature'))
	WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Signaturefield'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Signature/Thickness_'+thickness))
	WebUI.delay(1)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield'), 20, -180)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield'), 80,-20)
	WebUI.delay(1)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield2'), -120, 80)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield2'), 180, 20)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield'), -60, 20)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Signaturefield'), 40, 30)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Signature/Accept_Signature'))
	WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Confirmation_Accept'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Signature/Confirmation_Accept'))
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
	out.println("Step_" + step + "_Signatureadd_" + thickness + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

}
