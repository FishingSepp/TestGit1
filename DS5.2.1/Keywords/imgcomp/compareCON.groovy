package imgcomp

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

import java.io.IOException
import org.frontendtest.components.ImageComparison




public class compareCON {
	
	//step for expected png needed, diff resolutions?
	
	@Keyword
	def main(String
		
							
		
								[] args, String resolution) throws IOException {
				WebUI.takeScreenshot('C:\\Users/Megapoort/Pictures/KatalonScreenshots/miniCON/'+resolution+'actual.png')
				String imgOriginal = 'C:\\Users/Megapoort/Pictures/KatalonScreenshots/miniCON/'+resolution+'expected.png';
				String imgToCompareWithOriginal = 'C:\\Users/Megapoort/Pictures/KatalonScreenshots/miniCON/'+resolution+'actual.png';
				String imgOutputDifferences = 'C:\\Users/Megapoort/Pictures/KatalonScreenshots/miniCON/'+resolution+'diffimg.png';
			
					ImageComparison imageComparison = new ImageComparison(20,20,0.05);
			
					if(imageComparison.fuzzyEqual(imgOriginal,imgToCompareWithOriginal,imgOutputDifferences))
					System.out.println("Images are fuzzy-equal.");
				else
					System.out.println("Images are not fuzzy-equal.");
			}
		}


