import java.text.SimpleDateFormat
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//path home: C:\Users\Megapoort\Pictures\KatalonScreenshots, path work: \\nv01501827.bmwgroup.net\Q442780\My Pictures\ScreenshotsKata
int takescr = 1   //activate screenshot function = 1
String screenshot = 'golden'  //golden or test screenshot?
String resolution = 'test2'  // resolution to name files in folder

for (int i; i<totalRuns; i++){
	
	String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
	String timeStampScreenshot = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
	PrintStream ps = new PrintStream(timeStamp + '_Run' + run + '.txt')
	
	CustomKeywords.'cupakeysSc.initStart.initialStart'('https://customiser.yours-customised.mini/de/2454323.html?scupaId=AzIrNnomXD88KXo4TU1N',
	    LoadTimeCorrector, step, run, device, timeStamp); step ++

	CustomKeywords.'cupakeysSc.color.changecolor'('chilired', LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	CustomKeywords.'cupakeysSc.chngstruct.changestructure'('drops', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.sclstruct.scalestructure'(-100, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('plus1', LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	CustomKeywords.'cupakeysSc.txtadd.textadd'('MINI CUPA', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtfont.textfont'('serif', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('plus1', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtres.textresize'(-100, LoadTimeCorrector, step, run, device, timeStamp); step ++
/*
	CustomKeywords.'cupakeysSc.chngstruct.changestructure'('Hahnentritt', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.sclstruct.scalestructure'(-100, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('minus1', LoadTimeCorrector, step, run, device, timeStamp); step ++

	CustomKeywords.'cupakeysSc.iconad.iconadd'('compass', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.iconrepos.iconreposition'(50, -10, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.iconres.iconresize'(-150, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('plus1', LoadTimeCorrector, step, run, device, timeStamp); step ++
		
	//CustomKeywords.'cupakeysSc.delicon.delete'(LoadTimeCorrector, step, run, device, timeStamp); step ++

	CustomKeywords.'cupakeysSc.iconad.iconadd'('UnionJack', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.iconrepos.iconreposition'(-150, 10, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.iconres.iconresize'(-100, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('minus0,5', LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	CustomKeywords.'cupakeysSc.txtadd.textadd'('imthenumber', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtfont.textfont'('serif', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtrepos.textreposition'(50, 0, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtres.textresize'(25, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtadd.textadd'('1on1', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtfont.textfont'('serif', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.txtrepos.textreposition'(-20, -50, LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysSc.protrusion.changeprotrusion'('minus1', LoadTimeCorrector, step, run, device, timeStamp); step ++
		
	CustomKeywords.'cupakeysSc.splitp.split'('default', LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	CustomKeywords.'cupakeysSc.txtadd.textadd'('partNo.2', LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	CustomKeywords.'cupakeysSc.swtchmode.switchmode'('preview', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysSc.swtchmode.switchmode'('customisation', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysSc.swtchpart.switchpart'('left', LoadTimeCorrector, step, run, device); step ++
	*/
	CustomKeywords.'cupakeysSc.slink.svlink'(null, run, timeStamp)
	/*
	if (takescr == 1){
		if (screenshot=='golden'){
			WebUI.delay(5)
			WebUI.takeScreenshot(path+'/CuPa/'+product+'/'+timeStampScreenshot+'/'+resolution+'/expected.png')
		}
		else{
			CustomKeywords.'imgcomp.compareCuPa.main'(null, product, path, run, timeStampScreenshot, resolution, timeStamp)
		}
	}
			
	CustomKeywords.'cupakeysSc.rstart.restart'(LoadTimeCorrector, step, run, device, timeStamp); step ++
*/
	CustomKeywords.'cupakeysSc.endsession.finishsession'()
run++
}
 


