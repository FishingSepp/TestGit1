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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as driver

WebUI.openBrowser('https://d16a4dsnr8a0k1.cloudfront.net/en/2455235.html?price=150.00%20�&partName=wilsonPartName&vin=wilsonVin&modelCode=XP11&paint=P0A94&modelDescription=wilsonModelDescription&additionalEquipment=wilsonAdditionalEquipment')
WebUI.setViewPortSize(375, 667)

WebUI.waitForElementVisible(findTestObject('CuPaDs/Color/Color'), 3, FailureHandling.STOP_ON_FAILURE)
//WebUI.verifyElementVisibleInViewport(findTestObject('CuPaDs/Color/Color'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

WebUI.delay(10)
WebUI.takeScreenshot('C:\\Users/Megapoort/Pictures/KatalonScreenshots/CuPa/'+resolution+'expected.png')

//CustomKeywords.'imgcomp.compareCuPa.main'(null, resolution)
WebUI.delay(1)

WebUI.closeBrowser()

