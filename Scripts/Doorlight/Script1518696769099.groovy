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

int takescr = 0   //activate screenshot function = 1
String screenshot = 'golden'  //golden or test screenshot?
String resolution = 'test'  // resolution to name files in folder

for (int i; i<totalRuns; i++){//signature NOT selected after playing!?
	
	String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
	String timeStampScreenshot = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
	PrintStream ps = new PrintStream(timeStamp + '_Run' + run + '.txt')
	def iconmap = [:]
	def txtmap = [:]
	def signmap = [:]
	
	CustomKeywords.'cupakeysDl.initStart.initialStart'('https://d16a4dsnr8a0k1.cloudfront.net/en/2455233.html?price=150.00%20%E2%82%AC&partName=wilsonPartName&vin=wilsonVin&modelCode=XP11&paint=P0A94&modelDescription=wilsonModelDescription&additionalEquipment=wilsonAdditionalEquipment',
	    LoadTimeCorrector, step, run, device, timeStamp); step ++
	/*
	CustomKeywords.'cupakeysDl.color.changecolor'('black', LoadTimeCorrector, step, run, device, timeStamp); step ++

	CustomKeywords.'cupakeysDl.chngstruct.changestructure'('Hahnentritt', LoadTimeCorrector, step, run, device, timeStamp); step ++
	CustomKeywords.'cupakeysDl.sclstruct.scalestructure'(-100, LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	iconmap += CustomKeywords.'cupakeysDl.iconad.iconadd'('Tap', LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++; iconcount++
	iconmap += CustomKeywords.'cupakeysDl.iconrepos.iconreposition'(-100, -10, LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++
	
	iconmap += CustomKeywords.'cupakeysDl.iconad.iconadd'('UnionJack', LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++; iconcount++
	iconmap += CustomKeywords.'cupakeysDl.iconrepos.iconreposition'(-150, 10, LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++
	CustomKeywords.'cupakeysDl.iconres.iconresize'(-25, LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	println 'keys ' + iconmap.keySet()
	println 'values ' + iconmap.values()
	CustomKeywords.'cupakeysDl.delicon.delete'(LoadTimeCorrector, step, run, device, timeStamp, iconmap, iconcount); step ++; iconcount--; iconmap.remove('x'+iconcount);iconmap.remove('y'+iconcount)
	CustomKeywords.'cupakeysDl.delicon.delete'(LoadTimeCorrector, step, run, device, timeStamp, iconmap, iconcount); step ++; iconcount--; iconmap.remove('x'+iconcount);iconmap.remove('y'+iconcount)
	*/
	txtmap += CustomKeywords.'cupakeysDl.txtadd.textadd'('imthenumber', LoadTimeCorrector, step, run, device, timeStamp, txtcount); step ++; txtcount++
	CustomKeywords.'cupakeysDl.txtfont.textfont'('Italic', LoadTimeCorrector, step, run, device, timeStamp); step ++
	txtmap += CustomKeywords.'cupakeysDl.txtrepos.textreposition'(50, 0, LoadTimeCorrector, step, run, device, timeStamp, txtcount); step ++
	CustomKeywords.'cupakeysDl.txtres.textresize'(25, LoadTimeCorrector, step, run, device, timeStamp); step ++
	txtmap += CustomKeywords.'cupakeysDl.txtadd.textadd'('1on1', LoadTimeCorrector, step, run, device, timeStamp, txtcount); step ++; txtcount++
	CustomKeywords.'cupakeysDl.txtfont.textfont'('Regular', LoadTimeCorrector, step, run, device, timeStamp); step ++
	txtmap += CustomKeywords.'cupakeysDl.txtrepos.textreposition'(-20, -50, LoadTimeCorrector, step, run, device, timeStamp, txtcount); step ++
	
	println 'keys ' + txtmap.keySet()
	println 'values ' + txtmap.values()
	CustomKeywords.'cupakeysDl.deltext.delete'(LoadTimeCorrector, step, run, device, timeStamp, txtmap, txtcount); step ++; txtcount--; txtmap.remove('x'+txtcount);txtmap.remove('y'+txtcount)
	CustomKeywords.'cupakeysDl.deltext.delete'(LoadTimeCorrector, step, run, device, timeStamp, txtmap, txtcount); step ++; txtcount--; txtmap.remove('x'+txtcount);txtmap.remove('y'+txtcount)
	
	CustomKeywords.'cupakeysDl.splitp.split'('default', LoadTimeCorrector, step, run, device, timeStamp); step ++
	/*
	signmap += CustomKeywords.'cupakeysDl.signadd.signatureadd'(1, LoadTimeCorrector, step, run, device, timeStamp, signcount); step ++; signcount++
	signmap += CustomKeywords.'cupakeysDl.signrepos.signaturereposition'(50, -10, LoadTimeCorrector, step, run, device, timeStamp, signcount); step ++
	CustomKeywords.'cupakeysDl.signres.signatureresize'(25, LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	signmap += CustomKeywords.'cupakeysDl.signadd.signatureadd'(1, LoadTimeCorrector, step, run, device, timeStamp, signcount); step ++; signcount++
	signmap += CustomKeywords.'cupakeysDl.signrepos.signaturereposition'(-20, 0, LoadTimeCorrector, step, run, device, timeStamp, signcount); step ++
	CustomKeywords.'cupakeysDl.signres.signatureresize'(-10, LoadTimeCorrector, step, run, device, timeStamp); step ++
	
	println 'keys ' + signmap.keySet()
	println 'values ' + signmap.values()
	CustomKeywords.'cupakeysDl.delsign.delete'(LoadTimeCorrector, step, run, device, timeStamp, signmap, signcount); step ++; signcount--; signmap.remove('x'+signcount);signmap.remove('y'+signcount)
	CustomKeywords.'cupakeysDl.delsign.delete'(LoadTimeCorrector, step, run, device, timeStamp, signmap, signcount); step ++; signcount--; signmap.remove('x'+signcount);signmap.remove('y'+signcount)
	*/
	
	CustomKeywords.'cupakeysDl.swtchmode.switchmode'('preview', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDl.swtchmode.switchmode'('customisation', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDl.swtchpart.switchpart'('left', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDl.slink.svlink'(null, run, timeStamp);
	
	if (takescr==1){
		if (screenshot=='golden'){
			WebUI.delay(5)
			WebUI.takeScreenshot(path+'/CuPa/'+product+'/'+ timeStampScreenshot+'/'+resolution+'/expected.png')
		}
		else{
			CustomKeywords.'imgcomp.compareCuPa.main'(null, product, path, run, timeStampScreenshot, resolution)
		}
	}
		
	CustomKeywords.'cupakeysDl.rstart.restart'(LoadTimeCorrector, step, run, device, timeStamp); step ++

	CustomKeywords.'cupakeysDl.endsession.finishsession'()
run++
}
 


