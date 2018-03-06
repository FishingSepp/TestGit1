package cupakeysSc

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class iconrepos {
	
	@Keyword
	def iconreposition(int reposx, int reposy, LoadTimeCorrector, step, run, device, timeStamp, iconcount){
	int timed
	def coordmap = [:]
	
	if(WebUI.waitForElementVisible(findTestObject('CuPaSc/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaSc/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaSc/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaSc/Icons/Reposition_icon'), reposx, reposy)

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
	
// save coordinates
	WebElement iconpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaSc/Icons/Reposition_icon'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int height = WebUI.getElementHeight(findTestObject('CuPaSc/Icons/Reposition_icon'))
	int iconxpos = iconpos.getLocation().x
	int iconypos = iconpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_iconreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+(iconcount-1)) = ((iconxpos+(0.5*width)).intValue())
	coordmap.('y'+(iconcount-1)) = ((iconypos+(0.5*height)).intValue())
	return coordmap
}

}

