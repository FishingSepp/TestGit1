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

String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
String timeStampScreenshot = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());

def iconmap = [:]
def txtmap = [:]
def signmap = [:]


CustomKeywords.'cupakeysDl.initStart.initialStart'('https://d16a4dsnr8a0k1.cloudfront.net/en/2455233.html?price=150.00%20%E2%82%AC&partName=wilsonPartName&vin=wilsonVin&modelCode=XP11&paint=P0A94&modelDescription=wilsonModelDescription&additionalEquipment=wilsonAdditionalEquipment',
	LoadTimeCorrector, step, run, device, timeStamp); step ++

CustomKeywords.'cupakeysDl.color.changecolor'('nightlightblue', LoadTimeCorrector, step, run, device, timeStamp); step ++

//CustomKeywords.'cupakeysDl.chngstruct.changestructure'('drops', LoadTimeCorrector, step, run, device, timeStamp); step ++
//CustomKeywords.'cupakeysDl.sclstruct.scalestructure'(-225, LoadTimeCorrector, step, run, device, timeStamp); step ++

iconmap += CustomKeywords.'cupakeysDl.iconad.iconadd'('londoncircle', LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++; iconcount++
CustomKeywords.'cupakeysDl.iconres.iconresize'(-125, LoadTimeCorrector, step, run, device, timeStamp); step ++

CustomKeywords.'cupakeysDl.slink.svlink'(null, run, timeStamp);

CustomKeywords.'cupakeysDl.endsession.finishsession'()







