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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper

int takescr = 1   //activate screenshot function = 1
String screenshot = 'test'  //golden or test screenshot?
String resolution = 'test'  // resolution to name files in folder

for (int i; i<totalRuns; i++){
	
	PrintStream ps = new PrintStream(('FinalRun' + run) + 'Test.txt')
	
	CustomKeywords.'cupakeysDs.initStart.initialStart'('https://d16a4dsnr8a0k1.cloudfront.net/en/2455235.html?price=150.00%20�&partName=wilsonPartName&vin=wilsonVin&modelCode=XP11&paint=P0A94&modelDescription=wilsonModelDescription&additionalEquipment=wilsonAdditionalEquipment',
	    LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.color.changecolor'('BrushedAlu', LoadTimeCorrector, step, run, device); step ++

	CustomKeywords.'cupakeysDs.chngstruct.changestructure'('Chess', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.sclstruct.scalestructure'(-100, LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.iconad.iconadd'('Deer', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.iconrepos.iconreposition'(-100, -10, LoadTimeCorrector, step, run, device); step ++
	
	//CustomKeywords.'cupakeysDs.delicon.delete'(LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.iconad.iconadd'('UnionJack', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.iconrepos.iconreposition'(-150, 10, LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.iconres.iconresize'(-25, LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.txtadd.textadd'('imthenumber', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.txtfont.textfont'('Italic', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.txtrepos.textreposition'(50, 0, LoadTimeCorrector, step, run, device); step ++
	//CustomKeywords.'cupakeysDs.txtres.textresize'(25, LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.txtadd.textadd'('1on1', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.txtfont.textfont'('Regular', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.txtrepos.textreposition'(180, 0, LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.splitp.split'('default', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.signadd.signatureadd'(1, LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.swtchmode.switchmode'('preview', LoadTimeCorrector, step, run, device); step ++
	CustomKeywords.'cupakeysDs.swtchmode.switchmode'('customisation', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.swtchpart.switchpart'('left', LoadTimeCorrector, step, run, device); step ++
	
	CustomKeywords.'cupakeysDs.slink.svlink'(null, run)
	
	if (takescr == 1){
		if (screenshot == 'golden'){
			WebUI.delay(5)
			WebUI.takeScreenshot(path+'/CuPa/'+product+'/'+resolution+'/expected.png')
		}
		else{
			CustomKeywords.'imgcomp.compareCuPa.main'(null, resolution, product, path, run)
		}
	}

	
	CustomKeywords.'cupakeysDs.rstart.restart'(LoadTimeCorrector, step, run, device); step ++

	CustomKeywords.'cupakeysDs.endsession.finishsession'()
run++
}
 


