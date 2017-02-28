package pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import runner.Hooks;
public class DriverWrapper 
{
	
	    protected WebDriver driver;
	    protected Properties prop; 
		public int timeOut = 10000;
		private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
	    public DriverWrapper(WebDriver driver) 
	    {
	        this.driver=driver;
	        InputStream in;
			String env;
	        try
	        {
	        	env=(System.getProperty("env")==null) ? "testEnv1": System.getProperty("env");

				in= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\UIMap.properties");
	        	InputStream in1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\"+env+".properties");
	            prop = new Properties();
	            prop.load(in);
	            prop.load(in1);
				//timeOut=Integer.parseInt(prop.getProperty("performanceDelay"));
			} catch (IOException e) {
				LOG.info("Error Loading property file");
				e.printStackTrace();
				
			}
	    }
	    
		/**
		 * This function will launch the application with the given browser in
		 * configuration.properties
		 * 
		 * @return
		 * @author F591139
		 */

		
		/**
		 * This function will get and return list values of dropdown list and wait
		 * if the value is not loaded. /
		 * 
		 * @param webElement
		 * @return
		 * @author F591139
		 */
		public String[] waitAndGetValuesOfDropdownlist(WebElement webElement) 
		{
			String[] arrValue = null;
			String[] arrAcutalValue = null;
			try {

				int iSleepTime = 5000;
				for (int i = 0; i < 50000; i += iSleepTime) {
					List<WebElement> lstOptions = webElement.findElements(By
							.tagName("option"));
					int intCount = lstOptions.size();
					if (lstOptions.size() > 0) {
						int k = 0;
						arrValue = new String[intCount];
						for (WebElement weOption : lstOptions) {
							String strListValue = weOption.getText();
							arrValue[k] = strListValue;
							k++;
						}
						if (arrValue[0].contains("Select")) {
							arrAcutalValue = new String[arrValue.length - 1];
							for (int j = 0; j < arrAcutalValue.length; j++) {
								arrAcutalValue[j] = arrValue[j + 1];
							}
						} else {
							arrAcutalValue = arrValue;
						}
					} else {
						Thread.sleep(iSleepTime);
						System.out.println("DROP DOWN LIST NOT UPDATED! ");
						System.out.println(String.format(
								"Waited for %d milliseconds.[%s]", i + iSleepTime,
								webElement.getText()));

					}
				}
			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return arrAcutalValue;
		}

		/**
		 * This function will get and return list values of dropdown list.
		 * 
		 * @param webElement
		 * @return []arrValue - array value of dropdown list.
		 * @author F591139
		 */

		public String[] getValuesOfDropdownlist(WebElement webElement) {
			String[] arrValue = null;
			String[] arrAcutalValue = null;
			try {
				List<WebElement> lstOptions = webElement.findElements(By
						.tagName("option"));
				int intCount = lstOptions.size();
				arrValue = new String[intCount];
				int i = 0;
				for (WebElement weOption : lstOptions) {
					String strListValue = weOption.getText();
					arrValue[i] = strListValue;
					i++;
				}
				if (arrValue[0].contains("Select")) {
					arrAcutalValue = new String[arrValue.length - 1];
					for (int j = 0; j < arrAcutalValue.length; j++) {
						arrAcutalValue[j] = arrValue[j + 1];
					}
				} else {
					arrAcutalValue = arrValue;
				}
			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return arrAcutalValue;
		}

		/**
		 * Function used to get the selected option of drop down list.
		 * 
		 * @param webElement
		 * @return
		 * @author F591139
		 */
		public String getSelectedOption(WebElement webElement) {
			// String []arrValue = null;
			String strSelectedValue = null;
			try {
				List<WebElement> Ooptions = webElement.findElements(By
						.tagName("option"));
				// int intCount = Ooptions.size();
				// arrValue = new String[intCount];

				for (WebElement weOption : Ooptions) {

					if (weOption.isSelected()) {
						strSelectedValue = weOption.getText();
						return strSelectedValue;
					}
				}

			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return strSelectedValue;
		}

		/**
		 * 
		 * @param webDriver
		 * @param by
		 * @param strObjectName
		 * @param strData
		 * @return
		 */
		boolean clickAndWait(WebDriver webDriver, By by,String strObjectName, String strData)
		{
			String strStepDetails;
			boolean bResult = false;
			try {
				WebElement oClick = findElement(webDriver,by, timeOut);
				// Click on Object
				oClick.click();
				strStepDetails = "Click on " + strObjectName + " and Wait for "
						+ strData;
				System.out.println(strStepDetails);
				LOG.info(strStepDetails);
				bResult = true;
				Long longData = new Long(strData);
				Thread.sleep(longData);
			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				// Log.info(ex.getStackTrace().toString());
			}
			return bResult;
		}

		/**
		 * This function will select a value in combo box object.
		 * @param webDriver :WebDriver to run the test
		 * @param oObjectXpath :The xpath of specific object
		 * @param strObjectName :Name of object in testcase file
		 * @param strData :Data to fill in Object
		 * @return true if PASS /false if FAIL
		 * @author F591139
		 */
		public boolean selectDDListItem(WebDriver webDriver,String oObjectXpath, String strObjectName, String strData) 
		{
			String strStepDetails = "";
			String strStatus = "";
			boolean bResult = false;
			try {
				WebElement weDropDownList = findElement(webDriver,
						By.xpath(oObjectXpath), timeOut);
				// Select data for Object

				List<WebElement> lstOptions = weDropDownList.findElements(By
						.tagName("option"));
				for (WebElement weOption : lstOptions) {
					if (weOption.getText().equalsIgnoreCase(strData.trim())) {

						weOption.click();
						bResult = true;
						strStepDetails = "Selected " + strObjectName + ": "
								+ strData;
						strStatus = "Pass";
						break;
					} else {
						strStepDetails = "Not selected " + strObjectName + ": "
								+ strData;
						strStatus = "Fail";
					}
				}
				// strStepDetails = "Select value of Web list " + strObjectName +
				// ": " + strData;
				LOG.info(strStepDetails+": "+strStatus);
				// System.out.println(strStepDetails);
			} catch (Exception ex) {
				System.err.println("Got an exception selecting dropdown element! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return bResult;
		}
		public boolean inputField(WebDriver webDriver, By by, String strObjectName,String strData) 
		{
			String strStepDetails;
			boolean bResult = false;
			try 
			{
				waitAnElementPresent(webDriver, by, timeOut);
				WebElement oInput = findElement(webDriver, by, timeOut);
				// Input value to object
				if (doesWebElementExist(webDriver, by, timeOut))
				{
					oInput.clear();
					oInput.sendKeys(strData);
					if (strObjectName.toUpperCase().contains("PASSWORD")){
						strData="*********";
					}
					strStepDetails = "Enter value to " + strObjectName + ": "+ strData;
					LOG.info(strStepDetails);
					bResult = true;
				} 
				else 
				{

					LOG.info("Element is not found");
					captureScreen(webDriver, "input");
				}
			} catch (Exception ex) 
			{
				LOG.info("Fail to enter the value for " + strObjectName);
				captureScreen(webDriver, "input");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return bResult;
		}
		/**
		 * WaitSelectDDListItem is used for dependent drop down list option selects
		 * 
		 * @param webDriver
		 * @param by
		 * @param strObjectName
		 * @param strData
		 * @return true when given option gets selected in the drop down
		 * @author F591139
		 */
		public boolean waitAndSelectDDListItem(WebDriver webDriver,By by, String strObjectName, String strData) 
		{
			String strStepDetails = "";
			boolean bResult = false;
			try {
				WebElement weDropDownList = findElement(webDriver,by, timeOut);
				// Select data for Object
				// List <WebElement> lstOptions =
				// weDropDownList.findElements(By.tagName("option"));

				int iSleepTime = 5000;
				for (int i = 0; i < 50000; i += iSleepTime) {
					List<WebElement> lstOptions = weDropDownList.findElements(By.tagName("option"));
					if (lstOptions.size() > 1) 
					{
						for (WebElement weOption : lstOptions) 
						{
							if (weOption.getText().equalsIgnoreCase(strData)) {
								weOption.click();
								bResult = true;
								strStepDetails = "Selected " + strObjectName + ": "
										+ strData;
								LOG.info(strStepDetails);
								return bResult;
							}
						}
					} else {
						Thread.sleep(iSleepTime);
						System.out.println("DROP DOWN LIST NOT UPDATED! ");
						System.out.println(String.format(
								"Waited for %d milliseconds.[%s]", i + iSleepTime,
								weDropDownList));
						strStepDetails = "Not selected " + strObjectName + ": "
								+ strData;

					}

				}

				LOG.info(strStepDetails);
			} catch (Exception ex) {
				System.err.println("Got an exception selecting dropdown element! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return bResult;
		}

		/**
		 * 
		 * @param webDriver
		 * @param by
		 * @param iTimeOut
		 * @return
		 * @author F591139
		 */
		public boolean doesWebElementExist(WebDriver webDriver, By by,int iTimeOut) {
			boolean bPresent = false;
			try {
				findElement(webDriver, by, iTimeOut);
				bPresent = true;
			} catch (NullPointerException ex) {
				System.out.println("Element does not found");
				ex.printStackTrace();
			} catch (RuntimeException ex) {
				bPresent = false;
				LOG.info(ex.getMessage().toString());
				// System.out.println("Got Exception");
			}

			return bPresent;
		}

		/**
		 * Waits till the element disappears from the page /
		 * 
		 * @param webDriver
		 * @param by
		 * @param iTimeOut
		 * @author F591139
		 */
		public void waitAnElementDisappears(WebDriver webDriver, By by,
				int iTimeOut) {
			int iTotal = 0;
			int iSleepTime = 6000;
			while (iTotal <= iTimeOut) {
				try {
					Thread.sleep(iSleepTime);

					if (findElement(webDriver, by, 9000).isDisplayed()) {
						iTotal = iTotal + iSleepTime;
						System.out.println("Element Found");
						System.out.println(String.format(
								"Waiting to disappear %d milliseconds.[%s]",
								iTotal, by));

					}

					else {
						LOG.info("Wait over");
						return;
					}
				} catch (Exception ex) {
					LOG.info("Element Not Found");
					return;
				}
			}
		}

		/**
		 * GG_FindElement for find by web element (not driver)
		 * 
		 * @param we
		 *            WebElement
		 * @param by
		 * @param iTimeOut
		 * @return
		 * @author F591139
		 */

		public WebElement findElement(WebElement we, By by, int iTimeOut) {
			int iSleepTime = 3000;
			for (int i = 0; i < iTimeOut; i += iSleepTime) {
				List<WebElement> oWebElements = we.findElements(by);
				if (oWebElements.size() > 0) {
					return oWebElements.get(0);
				} else {
					try {
						Thread.sleep(iSleepTime);
						System.out.println(String.format("Waited for %d milliseconds.[%s]", i + iSleepTime,by));
					} catch (InterruptedException ex) {
						System.out.println("Element not found");
						LOG.info(ex.getMessage().toString());
					}
				}
			}
			return null;
		}

		/**
		 * This function will switch to Iframe
		 * 
		 * @param webDriver
		 * @param strid
		 *            :The xpath of specific object
		 * @return
		 * @author F591139
		 */

		public boolean switchToIframe(WebDriver webDriver, String strid) {
			String strStepDetails;
			boolean bResult = false;
			try {
				WebDriver Iframe = webDriver.switchTo().frame(strid);
				System.out.println(Iframe.getTitle());
				strStepDetails = "SWITCH TO Iframe "+strid +" successfully !!!";
				System.out.println(strStepDetails);
				LOG.info(strStepDetails);
				bResult = true;
				// defaultWebDriver = false;
			} catch (Exception ex) {

				// System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return bResult;
		}

		/**
		 * threeDaysAfter is used to pass date in calendar as the three next days to
		 * sys date.
		 * 
		 * @return date string as dd/mm/yyyy
		 * @author F591139
		 */

		public String threeDaysAfter() {
			String threeDaysAfter = "";
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			cal.add(Calendar.DAY_OF_YEAR, +3);
			Date before = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			threeDaysAfter = formatter.format(before);

			return threeDaysAfter;
		}

		public String generateRandomName() {
			// String characters="ABCDEFGYHUI";
			int length = 5;
			String characters = "abcdefghklmnopqrstuvwxyz";
			Random generator = new Random();
			char[] text = new char[length];
			for (int i = 0; i < length; i++) {
				text[i] = characters.charAt(generator.nextInt(characters.length()));
			}
			text[0] = Character.toUpperCase(text[0]);
			return new String(text);

		}

		boolean clickSpecificButton(WebDriver webDriver, String oObjectXpath, String strObjectName)
		{
			String strStepDetails;
			boolean bResult = false;
			try {
				// WebElement weelement = GG_FindElement(webDriver,
				// By.className("ui-dialog-buttonpane"), intTimeOut);
				List<WebElement> lstButtons = webDriver.findElements(By.tagName("button"));

				// Click on Object
				for (WebElement weButton : lstButtons) {
					if (weButton.isDisplayed() == true) {
						String txtButtonName = weButton.getAttribute("innerHTML");
						if (txtButtonName.trim().contentEquals(oObjectXpath.trim())) {
							weButton.click();
							Thread.sleep(3000);

							strStepDetails = "Click on specific button: "
									+ strObjectName + " successfully!!!";
							System.out.println(strStepDetails);
							// Log.info(strStepDetails);
							bResult = true;

							break;
						}
					}
				}

			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				// Log.info(ex.getMessage().toString());
			}
			return bResult;
		}

		/**
	 * 		   
	 */
		public void waitfor5sec() {
			customWait(5000);
		}

		public void customWait(int i) {
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		/**
		 * Wait for the element while it appears on screen
		 * 
		 * @param webDriver
		 * @param by
		 * @param iTimeOut
		 */
		public void waitAnElementPresent(WebDriver webDriver, By by, int iTimeOut) {
			int iTotal = 0;
			int iSleepTime = 3000;
			while (iTotal < iTimeOut) 
			{

				// List<WebElement> oWebElements = webDriver.findElements(by);
				// if(oWebElements.size()>0)
				if (doesWebElementExist(webDriver, by, 3000))
					return;
				else 
				{
					try 
					{
						Thread.sleep(iSleepTime);
						iTotal = iTotal + iSleepTime;
						System.out.println(String.format(
								"Waiting for %d milliseconds.[%s]", iTotal, by));
					} 
					catch (InterruptedException ex) 
					{
						System.out.println("Sorry could not find given element");
						// throw new RuntimeException(ex);
					}
				}
			}
		}

		/**
		 * Take care of exception and gets the element if its there
		 * 
		 * @param webDriver
		 * @param by
		 * @param iTimeOut
		 * @return
		 * @author F591139
		 */
		public WebElement findElement(WebDriver webDriver, By by, int iTimeOut) 
		{
			int iSleepTime = 3000;
			for (int i = 0; i < iTimeOut; i += iSleepTime) 
			{
				List<WebElement> oWebElements = webDriver.findElements(by);
				if (oWebElements.size() > 0) 
				{
					System.out.println("Element found: "+ by);
					return oWebElements.get(0);
				} 
				else 
				{
					try 
					{
						Thread.sleep(iSleepTime);
						System.out.println(String.format("Waited for %d milliseconds.[%s]", i + iSleepTime,by));
					} catch (InterruptedException ex) {
						throw new RuntimeException(ex);
					} catch (NullPointerException ex) {
						System.out.println("Element not found");
						ex.printStackTrace();
					}
				}
			}
			// Can't find 'by' element. Therefore throw an exception.
			String sException = String.format("Can't find %s after %d milliseconds.", by, iTimeOut);
			throw new RuntimeException(sException);

		}

		/**
		 * 
		 * @param webDriver
		 * @param by
		 * @param strObjectName
		 * @param strData
		 * @return
		 */
		public boolean input(WebDriver webDriver, By by, String strObjectName,String strData) 
		{
			String strStepDetails;
			boolean bResult = false;
			try 
			{
				waitAnElementPresent(webDriver, by, timeOut);
				WebElement oInput = findElement(webDriver, by, timeOut);
				if (doesWebElementExist(webDriver, by, timeOut))
				// Input value to object
				{
					oInput.clear();
					oInput.sendKeys(strData);

					strStepDetails = "Enter value to " + strObjectName + ": "
							+ strData;
					System.out.println(strStepDetails);
					LOG.info(strStepDetails);
					bResult = true;
				} 
				else 
				{

					LOG.info("Element is not found");
					captureScreen(webDriver, "input");
				}
			} catch (Exception ex) 
			{

				// System.err.println("Got an exception! ");
				LOG.info("Fail to enter the value for " + strObjectName);
				captureScreen(webDriver, "input");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
			}
			return bResult;
		}

		/**
		 * 
		 * @param webDriver
		 * @param by
		 * @param strObjectName
		 * @return
		 */
		public boolean click(WebDriver webDriver, By by, String strObjectName) 
		{
			String strStepDetails;
			boolean bResult = false, bExist = false;
			try {
				waitAnElementPresent(webDriver, by, timeOut);
				bExist = doesWebElementExist(webDriver, by, timeOut);

				if (!bExist) {
					captureScreen(webDriver, "Click");
					strStepDetails = strObjectName + " Not Found";
					LOG.info(strStepDetails+" Failed");
					return bResult;
				}
				WebElement oClick = findElement(webDriver, by, 5000);
				// Click on Object
				// GG_Wait(2000); // tested and commented
				oClick.click();
				strStepDetails = "Click on " + strObjectName;
				bResult = true;
				System.out.println(strStepDetails+ " Pass");
				LOG.info(strStepDetails+ " Pass");
			} catch (Exception ex) {
				captureScreen(webDriver, "click");
				strStepDetails = "Fail to click on " + strObjectName;
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
				LOG.info(strStepDetails+" Failed");
			}
			return bResult;
		}

		/**
		 * 
		 * @param webDriver
		 * @param by
		 * @param strObjectName
		 * @return
		 * @author F591139
		 */
		public boolean clickFast(WebDriver webDriver, By by, String strObjectName) 
		{
			String strStepDetails;
			boolean bResult = false, bExist = false;
			try {
				bExist = doesWebElementExist(webDriver, by, timeOut);

				if (!bExist) {
					captureScreen(webDriver, "input");
					strStepDetails = strObjectName + " Not Found";
					LOG.info(strStepDetails+" Failed");
					return bResult;
				}
				WebElement oClick = findElement(webDriver, by, 5000);
				oClick.click();
				strStepDetails = "Click on " + strObjectName;
				LOG.info(strStepDetails);
				bResult = true;
				
			} catch (Exception ex) {
				captureScreen(webDriver, "input");
				strStepDetails = "Fail to click on " + strObjectName;
				System.err.println("Got an exception! ");
				ex.printStackTrace();
				LOG.info(ex.getMessage().toString());
				LOG.info(strStepDetails, "Fail", true);
			}
			return bResult;
		}

		/**
		 * take a screenshot
		 * 
		 * @param driver
		 * @param filename
		 * @author F591139
		 */
		public void captureScreen(WebDriver driver, String filename) 
		{
			String msg, path;
			try 
			{

				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				path = "./ScreenShots/" + filename + "_" + source.getName();
				FileUtils.copyFile(source, new File(path));
				msg = "Screenshot captured at" + path;
				
			} catch (IOException e) {
				msg = "Failed to capture screenshot: " + e.getMessage();
			}
			
			LOG.info(msg);
		}

		/**
		 * 
		 * @param webDriver
		 * @param oObjectXpath
		 * @param strObjectName
		 * @return
		 */
		boolean hoverOnMenu(WebDriver webDriver, String oObjectXpath, String strObjectName) 
		{
			String strStepDetails;
			boolean bResult = false;
			try 
			{
				Actions builder = new Actions(webDriver);
				WebElement weMenu = webDriver.findElement(By
						.xpath(".// [@id='menuItem417']/a"));// GG_FindElement"));//(webDriver, By.id("menuItem417"),intTimeOut);
				// builder.clickAndHold(weMenu).build().perform();
				// driver.findElement(By.linkText("Awaiting Deployment")).click();

				// builder.moveToElement(toElement, xOffset, yOffset)
				builder.moveToElement(weMenu).build().perform();
				waitfor5sec();
				// webDriver.findElement(By.linkText("Awaiting Deployment")).click();
				// new WebDriverWait(webDriver, 50,
				// 50).until(ExpectedConditions.elementToBeClickable(By.linkText("Awaiting Deployment")));
				webDriver.findElement(
						By.xpath(".// [@id='menuItem417']/ul/li[2]/a")).click();

				// builder.release().perform();
				strStepDetails = "Mouseover on " + strObjectName;
				System.out.println(strStepDetails);

				bResult = true;
			} catch (Exception ex) {
				System.err.println("Got an exception! ");
				ex.printStackTrace();

			}
			return bResult;
		}
		/**
		 * 
		 * cleans and converts amount displayed to double
		 * 
		 *
		 */
		public double stringToDouble(String le) 
		{
			try 
			{
				boolean neg = false;
				if (le == null || le.equals("") || le.equals("NA"))
					return 0.0;
				else 
				{
					if (le.contains("-")) 
					{
						neg = true;
						le = le.replace("-", "");
					}
					le = le.replaceAll("\\s", "");
					le = le.replaceAll(",", "");
					le = le.replace("$", " ");
					le = le.trim();
					if (neg)
						le = "-" + le;
					return Double.parseDouble(le);
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return 0.0;
			}
		}

	public static void verifyTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(message, condition);
			LOG.debug("Expected value: true" + " Actual value: " + condition + " - PASSED ", true);
		} catch (Throwable e) {
			LOG.debug("Expected value: true" + " Actual value: " + condition + " - FAILED " + message, true);
			Hooks.verificationErrors.append(e.toString());
		}
	}
	public static void verifyNotNull(Object obj) {
		try {
			Assert.assertNotNull(obj);
			LOG.debug(obj.toString()+"Not Null", true);
		} catch (Throwable e) {
			LOG.debug(obj.toString()+"is Null", true);
			Hooks.verificationErrors.append(e.toString());
		}

	}

}
