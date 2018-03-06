package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class iconad {
	
	@Keyword
	def iconadd(String icon, LoadTimeCorrector, step, run, device, timeStamp, iconcount){
	int timed
	def coordmap = [:]
	
	WebUI.click(findTestObject('CuPaDl/Icons/Icon'))
	if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Icons/Icon_' + icon), 2)==true){
		WebUI.click(findTestObject('CuPaDl/Icons/Icon_' + icon))
	}
	else{
		WebUI.click(findTestObject('CuPaDl/MenuScroll/ObjectsScrollRight'))
		WebUI.delay(2)
		if (WebUI.waitForElementVisible(findTestObject('CuPaDl/Icons/Icon_' + icon), 1)==false){
			WebUI.click(findTestObject('CuPaDl/MenuScroll/ObjectsScrollRight'))
			WebUI.delay(2)
		}
		WebUI.click(findTestObject('CuPaDl/Icons/Icon_' + icon))
	}
	//WebUI.waitForElementVisible(findTestObject('CuPaDl/Icons/Icon_' + icon), 0)
	WebUI.delay(1)
	//WebUI.click(findTestObject('CuPaDl/Icons/Icon_' + icon))
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
	WebElement iconpos = WebUiCommonHelper.findWebElement(findTestObject('CuPaDl/Icons/Reposition_icon'), 0)
	int width = WebUI.getElementWidth(findTestObject('CuPaDl/Icons/Reposition_icon'))
	int height = WebUI.getElementHeight(findTestObject('CuPaDl/Icons/Reposition_icon'))
	int iconxpos = iconpos.getLocation().x
	int iconypos = iconpos.getLocation().y
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + '_Run' + run + '.txt', true)));
	out.println("Step_" + step + "_iconadd_" + icon + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	coordmap.('x'+iconcount) = ((iconxpos+(0.5*width)).intValue())
	coordmap.('y'+iconcount) = ((iconypos+(0.5*height)).intValue())
	return coordmap
}

}
