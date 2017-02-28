package runner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.CucumberReports;
//import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;


public class Hooks {

	public static WebDriver driver;
	public static String browser = (System.getProperty("Browser") == null ? "firefox" : System.getProperty("Browser"));
	private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
	protected Properties prop;
	public static StringBuffer verificationErrors = new StringBuffer();
	File results = null;
	boolean bool = false;

	static
	{
		 attachShutDownHook();
		LOG.info("************Running cucumber tests browser ");
	}


	private static void attachShutDownHook()
	{
		Runtime.getRuntime().addShutdownHook(new Thread()
		{@Override
			public void run() {
				try
				{
					LOG.info("Adding shutdown hook");
					System.out.println("Generating TESTBOX Reports");
					CucumberReports.generateReport();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

@Before
public void setUp() throws IOException
{
    String env;
    env=(System.getProperty("env")==null) ? "testEnv1": System.getProperty("env");
	System.out.println("User dir --"+System.getProperty("user.dir"));
	System.out.println("Envi--Running Hooks");
	InputStream in1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\"+env+".properties");
	InputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\UIMap.properties");
	System.out.println("loading properties from:"+ System.getProperty("user.dir")+"\\src\\test\\resources\\"+env+".properties");
	//String uiRequired = System.getProperty("ui");
	// InputStream in1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\test1.properties");
	prop = new Properties();
	prop.load(in);
	prop.load(in1);
	browser = browser.toLowerCase();

	// Launch browser
	 driver = launchBrowser(prop.getProperty("browser"));

	}

	public WebDriver launchBrowser(String strBrowser) {
		if (strBrowser != null && strBrowser.equalsIgnoreCase("firefox")) {
			//FirefoxProfile fprofile  = new FirefoxProfile();
			//fprofile.setEnableNativeEvents(false);

			driver = new FirefoxDriver();
			System.out.println("profile loaded");

		} else if (strBrowser != null && strBrowser.equalsIgnoreCase("iexplore")) {
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		} else if (strBrowser != null && strBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	@After
	public void teardown(Scenario scenario) throws IOException {
		//String verificationErrorString = verificationErrors.toString();
		if (scenario.isFailed() && driver != null) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/jpeg");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		/*else if(!"".equals(verificationErrorString))
		{
			Assert.fail(verificationErrorString);
		}*/
		if (driver != null) {

			driver.quit();
		}
	}
}
