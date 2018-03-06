package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class signadd {
	
	@Keyword
	def signatureadd (int thickness, LoadTimeCorrector, step, run, device, timeStamp, signcount){
	int timed
	def coordmap = [:]
	
	if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Signature'), 2)==true){
		WebUI.click(findTestObject('CuPaDl/Signature/Signature'))
	}
	else{
		WebUI.click(findTestObject('CuPaDl/MenuScroll/ObjectsScrollRight'))
		WebUI.delay(1)
		WebUI.click(findTestObject('CuPaDl/Signature/Signature'))
	}

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
	WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Confirmation_Accept'), 2)==true
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
	
//save coordinates
	WebElement txtpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaDl/Signature/Reposition_Signature'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaDl/Signature/Reposition_Signature'))
	int height = WebUI.getElementHeight(findTestObject('CuPaDl/Signature/Reposition_Signature'))
	int txtxpos = txtpos.getLocation().x
	int txtypos = txtpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_Signatureadd_" + thickness + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+signcount) = ((txtxpos+(0.5*width)).intValue())
	coordmap.('y'+signcount) = ((txtypos+(0.5*height)).intValue())
	return coordmap
}

}
