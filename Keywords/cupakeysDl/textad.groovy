package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class txtadd {
	
	@Keyword
	def textadd (String text, LoadTimeCorrector, step, run, device, timeStamp, txtcount){
	int timed
	def coordmap = [:]
	
	WebUI.click(findTestObject('CuPaDl/Texts/Text'))
	WebUI.waitForElementClickable(findTestObject('CuPaDl/Texts/Add_Text'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Texts/Add_Text'))
	WebUI.waitForElementVisible(findTestObject('CuPaDl/Texts/Textfield'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Texts/Textfield'))	
	WebUI.sendKeys(findTestObject('CuPaDl/Texts/Textfield'), text)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDl/Texts/Accept_text'))
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
	WebElement txtpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaDl/Texts/Reposition_Text'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaDl/Texts/Reposition_Text'))
	int height = WebUI.getElementHeight(findTestObject('CuPaDl/Texts/Reposition_Text'))
	int txtxpos = txtpos.getLocation().x
	int txtypos = txtpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_textadd_" + text + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+txtcount) = ((txtxpos+(0.5*width)).intValue())
	coordmap.('y'+txtcount) = ((txtypos+(0.5*height)).intValue())
	return coordmap
}  

}
