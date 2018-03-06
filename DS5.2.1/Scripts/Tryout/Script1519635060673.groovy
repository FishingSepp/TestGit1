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


String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
PrintStream ps = new PrintStream(timeStamp + '_Run' + run + '.txt')
def iconmap = [:]

CustomKeywords.'cupakeysSc.initStart.initialStart'('https://customiser.yours-customised.mini/de/2454323.html?scupaId=AzIrNnomXD88KXo4TU1N',
	LoadTimeCorrector, step, run, device, timeStamp); step ++

iconmap += CustomKeywords.'cupakeysSc.iconad_tryout.iconadd'('compass', LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++; iconcount++
iconmap += CustomKeywords.'cupakeysSc.iconad_tryout.iconadd'('pin', LoadTimeCorrector, step, run, device, timeStamp, iconcount); step ++; iconcount++

CustomKeywords.'cupakeysSc.color.changecolor'('jetblack', LoadTimeCorrector, step, run, device, timeStamp); step ++

println iconmap.('x'+String.valueOf(iconcount-1))
println 'keys ' + iconmap.keySet()
println 'values ' + iconmap.values()

CustomKeywords.'cupakeysSc.delicon_tryout.delete'(LoadTimeCorrector, step, run, device, timeStamp, iconmap, iconcount); step ++; iconcount--

WebUI.closeBrowser()