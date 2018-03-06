package cupakeysSc

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class slink {

	@Keyword
	def svlink(String[] args, run, timeStamp) throws Exception {
		
		PrintStream ps = new PrintStream(timeStamp + 'Run' + run + '_CuPaIDs.txt')
		
		WebUI.scrollToElement(findTestObject('CuPaSc/Save/Save'), 5)
		WebUI.click(findTestObject('CuPaSc/Save/Save'))
		WebUI.waitForElementVisible(findTestObject('CuPaSc/Save/CopyLink'), 0)
		WebUI.click(findTestObject('CuPaSc/Save/CopyLink'))
		WebUI.delay(1)	
		WebUI.click(findTestObject('CuPaSc/Save/Close'))
		WebUI.delay(1)
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(timeStamp + "Run"+run+"_CuPaIDs.txt", true)));
		out.println('FinalRun_'+run+'_  '+result);
		out.close();
	}

}
