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



//WebUI.openBrowser('http://www.kaidez.com/samples/template-shadowdom-practice/')
//WebUI.click(findTestObject('ShadowDom/katExample/aStoreLink'))
//WebUI.closeBrowser()

//WebUI.openBrowser('https://shop.polymer-project.org')
//WebUI.click(findTestObject('ShadowDom/PolyShop/shop-button'))
//WebUI.closeBrowser()


import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test




IWebDriver driver;

public IWebElement getUIObject(params By[] shadowRoots)
		{
			IWebElement currentElement = null;
			IWebElement parentElement = null;
			int i = 0;
			foreach (var item in shadowRoots)
			{
				if (parentElement == null)
				{
					currentElement = driver.FindElement(item);
				}
				else
				{
					currentElement = parentElement.FindElement(item);
				}
				if(i !=(shadowRoots.Length-1))
				{
					parentElement = expandRootElement(currentElement);
				}
				i++;
			}
			return currentElement;
		}

 public IWebElement expandRootElement(IWebElement element)
		{
			IWebElement rootElement = (IWebElement)((IJavaScriptExecutor)driver)
		.ExecuteScript("return arguments[0].shadowRoot", element);
			return rootElement;
		}

		
		[TestMethod]
		public void test()
		{
		   IWebElement searchButton= getUIObject(By.CssSelector("downloads-manager"),By.CssSelector("downloads-toolbar"),By.Id("search-input"),By.Id("search-buton"));
			searchButton.Click();
		}
		
		



public class ShadowDOMExample {
	
		WebDriver driver;
		String driverPath = "F:/Jars/chromedriver/";
	
		@BeforeTest
		public void setUp() {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		}
	
		@Test
		public void testGetText_FromShadowDOMElements() {
			System.out.println("Open Chrome downloads");
			driver.get("chrome://downloads/");
	
			System.out.println("Validate downloads page header text");
			WebElement root1 = driver.findElement(By.tagName("downloads-manager"));
	
					//Get shadow root element
			WebElement shadowRoot1 = expandRootElement(root1);
	
			WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
			WebElement shadowRoot2 = expandRootElement(root2);
	
			WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
			WebElement shadowRoot3 = expandRootElement(root3);
	
			String actualHeading = shadowRoot3.findElement(By.cssSelector("div[id=leftContent]>h1")).getText();
			// Verify header title
			Assert.assertEquals("Downloads", actualHeading);
	
		}
	
		//Returns webelement
		public WebElement expandRootElement(WebElement element) {
			WebElement ele = (WebElement) ((JavascriptExecutor) driver)
	.executeScript("return arguments[0].shadowRoot",element);
			return ele;
		}
	
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
	}