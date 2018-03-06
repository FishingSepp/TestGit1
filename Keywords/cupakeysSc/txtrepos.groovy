package cupakeysSc

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class txtrepos {
	
	@Keyword
	def textreposition (int reposx, int reposy, LoadTimeCorrector, step, run, device, timeStamp, txtcount){
	int timed
	def coordmap = [:]
	
	WebUI.click(findTestObject('CuPaSc/Texts/Resize_text'))
	if(WebUI.waitForElementVisible(findTestObject('CuPaSc/Texts/Reposition_text'), 3)==false){
		WebUI.click(findTestObject('CuPaSc/Texts/Resize_text'))
		WebUI.waitForElementVisible(findTestObject('CuPaSc/Texts/Reposition_text'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaSc/Texts/Reposition_text'), reposx, reposy)

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

//save coordinates	
	WebElement txtpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaSc/Icons/Reposition_icon'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int height = WebUI.getElementHeight(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int txtxpos = txtpos.getLocation().x
	int txtypos = txtpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_textreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+(txtcount-1)) = ((txtxpos+(0.5*width)).intValue())
	coordmap.('y'+(txtcount-1)) = ((txtypos+(0.5*height)).intValue())
	return coordmap
}

}
