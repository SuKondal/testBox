package pages;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
public class HomePage  extends DriverWrapper{

	
	    private String baseAppUrl;
	    public HomePage(WebDriver driver, String baseUrl) {
	        super(driver);
	        baseAppUrl=baseUrl;

	    }

	    public void go() {

	        driver.get(baseAppUrl+"/au/en/consumer.html");
	    }

	    public void isHomePage()
	    {
	        assertEquals(driver.getTitle(), "Patients and Families | ResMed");

	    }
	    public void verifyMenu()
		{

		}




	    /* driver.get(baseUrl + "/au/en/consumer.html");
	    driver.findElement(By.linkText("ProductsPage")).click();
	    driver.findElement(By.id("dummy-content-search-text")).click();
	    driver.findElement(By.id("content-search-text")).clear();
	    driver.findElement(By.id("content-search-text")).sendKeys("nasal mask");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.xpath("//div[@id='all-product-search-result']/section/div/article/a[3]/div[2]/h4")).click();
	    assertEquals(driver.getTitle(), "AirFit P10 | ResMed");
	    assertEquals(driver.findElement(By.cssSelector("div.video-list")).getText(), "AirFit P10 - How to fit\n 00:02:28\n \n \n \n AirFit P10 - User tips\n 00:04:05\n \n \n \n AirFit P10 - How to clean\n 00:03:41\n \n \n \n AirFit P10 - Overview\n 00:01:27\n \n \n \n AirFit P10 - Quiet air vent\n 00:00:44\n \n \n \n AirFit P10 - Quick fit headgear\n 00:00:44\n \n \n \n AirFit P10 - Performance comparison\n 00:00:48\n \n \n \n AirFit P10 - One piece frame\n 00:00:39\n \n \n \n AirFit P10 - Lightweight\n 00:00:35\n \n \n \n AirFit P10 - Enhanced pillows\n 00:00:51");
	    assertEquals(driver.findElement(By.xpath("//div[@id='How-to-buy']/section/article/h2")).getText(), "How to buy");*/



}
