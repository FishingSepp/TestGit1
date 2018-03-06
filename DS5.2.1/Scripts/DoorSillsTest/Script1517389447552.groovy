import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import org.junit.After
import org.openqa.selenium.Keys as Keys
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.awt.Robot as Robot

//.color special waiting method
//.save, delete function not working properly
//.resizing icon text no effect
//.cart = endless loading
//.preview showing nothing

PrintStream ps = new PrintStream("FinalRun"+run+"Test.txt")

initialStart('https://d16a4dsnr8a0k1.cloudfront.net/en/2455235.html?price=150.00%20€&partName=wilsonPartName&vin=wilsonVin&modelCode=XP11&paint=P0A94&modelDescription=wilsonModelDescription&additionalEquipment=wilsonAdditionalEquipment')

changecolor('BrushedAlu')
changecolor('JetBlack')

changestructure('Chess')
changestructure('Hahnentritt')
scalestructure(100)
scalestructure(-150)

iconadd('UnionJack')
iconreposition(-150, 0)
iconresize(-25)
iconadd('Deer')
iconreposition(-100, 0)
//iconresize(25)

textadd("imthenumber")
textfont("Italic")
textreposition(50, 0)
textadd("1one1")
textfont("Regular")
//textresize(40)
textreposition(180, 0)

split("default")

signatureadd(1)

switchmode("preview")
switchmode("customisation")

switchpart("left")

//cart()

//rotate()
//zoom(10)

restart()

WebUI.delay(1)
WebUI.closeBrowser()

//.
//.
//.

public int waitload(){
	if (WebUI.waitForElementVisible(findTestObject('CuPaDs/Loading_indicator'), 3)==false){
		return 1
	}
	else {
		WebUI.waitForElementNotVisible(findTestObject('CuPaDs/Loading_indicator'), 30)
	}
	return 2
}


public void initialStart (String url){
	WebUI.openBrowser('')
	WebUI.navigateToUrl(url)
	long start = System.currentTimeMillis()
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Loading_indicator'), 30)
	WebUI.waitForElementNotVisible(findTestObject('CuPaDs/Loading_indicator'), 60)
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_initialLoad_" + ": " + elapsedTimeSec);
	out.close();
	WebUI.comment("Step_" + step + "_initialLoad_" + ": " + elapsedTimeSec)
	//WebUI.delay(1)
	step++
	//WebUI.maximizeWindow()
	//WebUI.delay(1)
}

public void delete(){
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	WebUI.getViewportLeftPosition('CuPaDs/Icons/Resize_Icon_topright')
	WebUI.getViewportTopPosition('CuPaDs/Icons/Resize_Icon_topright')
	WebUI.click(findTestObject('CuPaDs/Delete/Delete'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Delete/DeleteEnd'), 0)
	WebUI.delay(1)
	
	
	WebUI.click(findTestObject('CuPaDs/Restart/DeleteEnd'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_delete" + ": " + elapsedTimeSec);
	out.close();
	WebUI.comment("Step_" + step + "_delete" + ": " + elapsedTimeSec)
	//WebUI.delay(1)
	step++
}

public void restart (){
	WebUI.scrollToElement(findTestObject('CuPaDs/Restart/Restart'), 5)
	WebUI.click(findTestObject('CuPaDs/Restart/Restart'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Restart/CopyLink'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Restart/Accept'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_restart" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void save (){
	Robot s = new Robot()
	s.mouseWheel(50)
	WebUI.delay(1)
	s.mouseWheel(50)
	WebUI.delay(1)
	s.mouseWheel(50)
	WebUI.delay(1)
	s.mouseWheel(50)
	WebUI.delay(1)
	s.mouseWheel(50)
	String link
	WebUI.click(findTestObject('CuPaSc/Save/Save'))
	WebUI.waitForElementVisible(findTestObject('CuPaSc/Save/CopyLink'), 0)
	WebUI.delay(1)
	//WebUI.click(findTestObject('CuPaSc/Save/Link'))
	//link = WebUI.getText(findTestObject('CuPaSc/Save/Link'))
	WebUI.click(findTestObject('CuPaSc/Save/Close'))
	WebUI.delay(1)
	/*WebUI.closeBrowser()
	WebUI.delay(2)
	WebUI.openBrowser('')
	WebUI.navigateToUrl(link)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "save&restart" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	
	*/step++
}

public void changecolor(String color) {
	if (WebUI.waitForElementVisible(findTestObject('CuPaDs/Color/Color'), 2)==true){
		WebUI.click(findTestObject('CuPaDs/Color/Color'))
	}
	else{
		WebUI.click(findTestObject('CuPaDs/MenuScroll/ScrollLeft'))
		WebUI.delay(1)
		WebUI.click(findTestObject('CuPaDs/Color/Color'))
	}
	//WebUI.click(findTestObject('CuPaDs/Color/Color'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Color/Color_JetBlack'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Color/Color_' + color))
	long start = System.currentTimeMillis()
	int timed = waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	if (timed == 1) {
		out.println("Step_" + step + "_colorChange_" + color + ": 0.1");
		out.close();
	}
	else{		
		out.println("Step_" + step + "_colorChange_" + color + ": " + elapsedTimeSec);
		out.close();
	}
	WebUI.delay(1)
	step++
}

public void changestructure(String structure){
	WebUI.click(findTestObject('CuPaDs/Structure/Structure'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Structure/Structure_Hahnentritt'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Structure/Structure_'+structure))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_structureChange_" + structure + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void scalestructure (int structurescaling){
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Structure/Resize_Structure_bottomright'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Structure/Resize_Structure'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Structure/Resize_Structure_bottomright'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Structure/Resize_Structure_bottomright'), WebUI.getViewportLeftPosition() +
		structurescaling, WebUI.getViewportTopPosition() + structurescaling)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_structureresize_" + structurescaling + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void iconadd(String icon){
	WebUI.click(findTestObject('CuPaDs/Icons/Icon'))	
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Icon_' + icon), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Icons/Icon_' + icon))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_iconadd_" + icon + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}



public void iconreposition(int reposx, int reposy){
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	
	//CustomKeywords.'html5.dnd.DragAndDropHelper.dragAndDrop'(findTestObject('CuPaDs/Icons/Reposition_icon'), findTestObject('CuPaDs/Icons/Resize_icon_bottomright'))
	//WebUI.dragAndDropToObject(findTestObject('CuPaDs/Icons/Reposition_icon'), findTestObject('CuPaDs/Icons/Resize_icon_bottomright'))
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Icons/Reposition_icon'), reposx, reposy)
	//WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Icons/Reposition_icon'), WebUI.getViewportLeftPosition() + reposx,
	//WebUI.getViewportTopPosition() + reposy)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_iconreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void iconresize (int iconscaling){
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Icons/Resize_icon'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Icons/Reposition_icon'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Icons/Resize_icon_bottomright'), WebUI.getViewportLeftPosition() + 
		iconscaling, WebUI.getViewportTopPosition() + iconscaling)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_iconresize_" + iconscaling + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void textadd (String text){
	WebUI.click(findTestObject('CuPaDs/Texts/Text'))
	WebUI.waitForElementClickable(findTestObject('CuPaDs/Texts/Add_Text'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Texts/Add_Text'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Textfield'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Texts/Textfield'))	
	WebUI.sendKeys(findTestObject('CuPaDs/Texts/Textfield'), text)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Texts/Accept_text'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_textadd_" + text + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}  

public void textfont (String font){
	WebUI.click(findTestObject('CuPaDs/Texts/Edit_text'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Font_Bold'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Texts/Font_'+font))
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Texts/Accept_text'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_textfont_" + font + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void textreposition (int reposx, int reposy){
	WebUI.click(findTestObject('CuPaDs/Texts/Resize_text'))
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Reposition_text'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Texts/Resize_text'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Reposition_text'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Texts/Reposition_text'), reposx, reposy)
	//WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Texts/Reposition_text'), WebUI.getViewportLeftPosition() + reposx,
		//WebUI.getViewportTopPosition() + reposy)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_textreposition" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void textresize (int textscaling){
	if(WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Resize_text_rightside'), 3)==false){
		WebUI.click(findTestObject('CuPaDs/Texts/Resize_text'))
		WebUI.waitForElementVisible(findTestObject('CuPaDs/Texts/Resize_text_rightside'), 0)
		WebUI.delay(1)
	}
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Texts/Resize_text_rightside'), WebUI.getViewportLeftPosition() +
		textscaling, WebUI.getViewportTopPosition())
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_textresize_" + textscaling + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void signatureadd (int thickness){
	if (WebUI.waitForElementVisible(findTestObject('CuPaDs/Signature/Signature'), 2)==true){
		WebUI.click(findTestObject('CuPaDs/Signature/Signature'))
	}
	else{
		WebUI.click(findTestObject('CuPaDs/MenuScroll/ScrollRight'))
		WebUI.delay(1)
		WebUI.click(findTestObject('CuPaDs/Signature/Signature'))
	}
	//WebUI.click(findTestObject('CuPaDs/Signature/Signature'))
	WebUI.waitForElementClickable(findTestObject('CuPaDs/Signature/Add_Signature'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Signature/Add_Signature'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Signature/Signaturefield'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Signature/Thickness_'+thickness))
	WebUI.delay(1)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield'), 20, -180)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield'), 80,-20)
	WebUI.delay(1)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield2'), -120, 80)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield2'), 180, 20)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield'), -60, 20)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/Signature/Signaturefield'), 40, 30)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Signature/Accept_Signature'))
	WebUI.waitForElementVisible(findTestObject('CuPaDs/Signature/Confirmation_Accept'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaDs/Signature/Confirmation_Accept'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_Signatureadd_" + thickness + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
}

public void split(String splitoption){
	WebUI.click(findTestObject('CuPaDs/Split/Split'))
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_splitpreview_" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	
	WebUI.click(findTestObject('CuPaDs/Split/split_'+splitoption))
	long start2 = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis2 = System.currentTimeMillis() - start2
	float elapsedTimeSec2 = (elapsedTimeMillis2 / 1000.0) - LoadTimeCorrector
	
	PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out2.println("Step_" + step + "_split_" + splitoption + ": " + elapsedTimeSec2);
	out2.close();
	WebUI.delay(1)
	step++
}
 
public void switchpart(String side){
	WebUI.click(findTestObject('CuPaDs/Split/Split_'+side))
	WebUI.delay(2)
}
 
public void switchmode(String mode){
	if (WebUI.waitForElementVisible(findTestObject('CuPaDs/Mode/Mode_'+mode), 4)==true){
		WebUI.click(findTestObject('CuPaDs/Mode/Mode_'+mode))
	}
	else {
		WebUI.click(findTestObject('CuPaDs/Mode/Mode_'+mode+'_app'))
	}
	
	WebUI.delay(3)
}

public void cart (){
	WebUI.click(findTestObject('CuPaSc/Shopping_cart/Add_to_cart'))
	WebUI.waitForElementVisible(findTestObject('CuPaSc/Shopping_cart/cart_preview'), 0)
	WebUI.delay(1)
	long start = System.currentTimeMillis()
	waitload()
	long elapsedTimeMillis = System.currentTimeMillis() - start
	float elapsedTimeSec = (elapsedTimeMillis / 1000.0) - LoadTimeCorrector
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FinalRun"+run+"Test.txt", true)));
	out.println("Step_" + step + "_cartpreview_" + ": " + elapsedTimeSec);
	out.close();
	WebUI.delay(1)
	step++
	WebUI.click(findTestObject('CuPaSc/Shopping_cart/ConfirmInfo'))
	WebUI.delay(1)
	WebUI.click(findTestObject('CuPaSc/Shopping_cart/Cancel'))
}
 
public void rotate (){
	int rotate_sidewards = -75
	int rotate_upwards = -50
	WebUI.clickOffset(findTestObject('CuPaDs/twikit-canvas'), -10, -10)
	WebUI.dragAndDropByOffset(findTestObject('CuPaDs/twikit-canvas'), WebUI.getViewportLeftPosition() + rotate_sidewards,
		WebUI.getViewportTopPosition() + rotate_upwards)
	WebUI.delay(2)
}
 
public void zoom (int zoom){
	Robot r = new Robot()
	WebUI.clickOffset(findTestObject('CuPaDs/twikit-canvas'), -10, -10)
	for (int i = 0; i < Math.abs(zoom); i++) {
		int zoom_steps = (zoom / zoom) * -1
		r.mouseWheel(zoom_steps)
		Thread.sleep(20)
	}
	WebUI.delay(2)
}
 
 
 
 
 