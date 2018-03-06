package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class signrepos {
	
	@Keyword
	def signaturereposition (int reposx, int reposy, LoadTimeCorrector, step, run, device, timeStamp, signcount){
	int timed
	def coordmap = [:]
	
	WebUI.click(findTestObject('CuPaDl/Signature/Resize_Signature'))
	if(WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Reposition_Signature'), 3)==false){
		WebUI.click(findTestObject('CuPaDl/Signature/Resize_Signature'))
		WebUI.waitForElementVisible(findTestObject('CuPaDl/Signature/Reposition_Signature'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDl/Signature/Reposition_Signature'), reposx, reposy)

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
	out.println("Step_" + step + "_SignatureReposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+(signcount-1)) = ((txtxpos+(0.5*width)).intValue())
	coordmap.('y'+(signcount-1)) = ((txtypos+(0.5*height)).intValue())
	return coordmap
}


}
