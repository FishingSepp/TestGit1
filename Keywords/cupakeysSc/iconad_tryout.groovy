package cupakeysSc

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class iconad_tryout {
	
	@Keyword
	def iconadd(String icon, LoadTimeCorrector, step, run, device, timeStamp){
	int timed
	WebUI.click(findTestObject('CuPaSc/Icons/Icon'))	
	WebUI.waitForElementVisible(findTestObject('CuPaSc/Icons/Icon_' + icon), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaSc/Icons/Icon_' + icon))
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
	WebElement iconpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaSc/Icons/Reposition_icon'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int height = WebUI.getElementHeight(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int iconxpos = iconpos.getLocation().x
	int iconypos = iconpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_iconadd_" + icon + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

}

