package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class delicon {
	
	@Keyword
	def delete(LoadTimeCorrector, step, run, device, timeStamp, iconmap, iconcount){
	int timed
	
	WebUI.clickOffset(findTestObject('body'), iconmap.('x'+String.valueOf(iconcount-1)), iconmap.('y'+String.valueOf(iconcount-1)))
	
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	
	WebElement todelete = WebUiCommonHelper.findWebElement(findTestObject('CuPaDl/Icons/Resize_Icon_topright'), 0)
	int delwidth = WebUI.getElementWidth(findTestObject('CuPaDl/Icons/Resize_Icon_topright'))
	int delheight = WebUI.getElementHeight(findTestObject('CuPaDl/Icons/Resize_Icon_topright'))
	int xpos = todelete.getLocation().x
	int ypos = todelete.getLocation().y
	
	WebUI.click(findTestObject('CuPaDl/delete/delete_delete1'))
	WebUI.delay(2)
	WebUI.clickOffset(findTestObject('body'), xpos + delwidth-10, ypos+10)
	
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
	out.println("Step_" + step + "_delete" + ": " + elapsedTimeSec);
	out.close();
	WebUI.comment("Step_" + step + "_delete" + ": " + elapsedTimeSec)
	WebUI.delay(1)
	step++
}

}
