package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;


/**
 * Created by Su on 10/27/2016.
 */
public class ProductsPage extends DriverWrapper {

    String baseAppUrl;
    String product;

    public ProductsPage(WebDriver driver, String baseUrl) {
        super(driver);
        baseAppUrl = baseUrl;

    }

    public void go() {

        driver.get(baseAppUrl + "/au/en/consumer/products.html");
    }

    public void navigateFormHomeToProducts() {
        click(driver,By.cssSelector("#primary-nav > li > a"),"Navigation");
        driver.findElement(By.linkText("ProductsPage")).click();
    }

    public void searchForProduct(String productType) {
        product =productType;
        WebElement search = findElement(driver,By.xpath("//*[contains(@id, 'content-search-text')]"),5000);
        input(driver,By.xpath("//*[contains(@id, 'content-search-text')]"),"Search",productType);
        System.out.println(driver.getTitle());
        //clickAndWait( driver,By.cssSelector("label.content-search-section > button[type=\"submit\"]"),"Submit","6000");
        search.sendKeys(Keys.ENTER);
        customWait(3000);
        System.out.println(driver.getTitle());
    }

    public void verifySearchResults( String productList) {
        //assertEquals("Search results | ResMed", driver.getTitle());
        System.out.println(driver.getTitle());
        if(product.equalsIgnoreCase("Nasal Pillow")) {
            assertNotNull( driver.findElement(By.linkText("Swift FX Bella")));
            assertNotNull( driver.findElement(By.linkText("AirFit P10 for Her")));
        }
        else if(product.equalsIgnoreCase("Nasal Mask"))
        {
            assertNotNull( driver.findElement(By.linkText("AirFit P10")));
        }
    }
    public void verifyProductLink(String productName, String pageTittle)
    { 
    	clickAndWait(driver,By.linkText(productName),productName,"6000");
    	 System.out.println("On Page: "+driver.getTitle());
    	 verifyTrue(pageTittle.equalsIgnoreCase( driver.getTitle()),pageTittle);
    	 //verifyTrue(doesWebElementExist(driver,By.linkText("How-to-buy"),4000),"How to buy link");
    }
    
    
    
    
    
    
    public void goBack()
    {
    	driver.navigate().back();
    	customWait(2000);
    }
}
