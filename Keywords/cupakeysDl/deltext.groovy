package cupakeysDl

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After
import org.openqa.selenium.By
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.gargoylesoftware.htmlunit.javascript.host.html.Image
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class deltext {
	
	@Keyword
	def delete(LoadTimeCorrector, step, run, device, timeStamp, txtmap, txtcount){
	int timed
	
	WebUI.clickOffset(findTestObject('body'), txtmap.('x'+String.valueOf(txtcount-1)), txtmap.('y'+String.valueOf(txtcount-1)))
	
	if(WebUI.waitForElementVisible(findTestObject('CuPaDl/Texts/Reposition_text'), 3)==false){
		WebUI.click(findTestObject('CuPaDl/Texts/Resize_text'))
		WebUI.waitForElementVisible(findTestObject('CuPaDl/Texts/Reposition_text'), 0)
		WebUI.delay(1)
	}
	
	WebElement todelete = WebUiCommonHelper.findWebElement(findTestObject('CuPaDl/Texts/Resize_text_topright'), 0)
	int delwidth = WebUI.getElementWidth(findTestObject('CuPaDl/Texts/Resize_text_topright'))
	int delheight = WebUI.getElementHeight(findTestObject('CuPaDl/Texts/Resize_text_topright'))
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

/*
 WebUI.click(findTestObject('CuPaDl/delete/delete_delete1'))
 WebUI.waitForElementVisible(findTestObject('CuPaDl/delete/delete_delete2'), 0)
 WebUI.delay(1)
 WebUI.click(findTestObject('CuPaDl/delete/delete_delete2'))
 */
/*int xdel = WebUI.getViewportLeftPosition('CuPaDl/Icons/Resize_Icon_topright')
 int ydel = WebUI.getViewportTopPosition('CuPaDl/Icons/Resize_Icon_topright')
 int ycanvas = WebUI.getViewportTopPosition('CuPaDl/twikit-canvas')
 int delposx = xdel
 int delposy = ydel - ycanvas
 //WebUI.click(findTestObject('CuPaDl/Delete/Delete'))
 //WebUI.delay(1)
 //WebUI.clickOffset('CuPaDl/twikit-canvas', delposx, delposy)
  */
 //WebDriver driver = DriverFactory.getWebDriver()
 //WebElement image = driver.findElement(By.xpath("//*[@id='pages-index']/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[5]"))
 //Point classname = Image.getLocation[]
 //int xcordi = classname.getX()
 //System.out.println("Element's Position from left side"+xcordi +" pixels.")
 //int ycordi = classname.getY()
 //System.out.println("Element's Position from top"+ycordi +" pixels.")