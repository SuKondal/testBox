package stepsDef;

//import runner.ResourceManager;
import org.openqa.selenium.By;
import pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ProductSearchSteps extends AbstractSteps {
   // private final static long DEFAULT_TIMEOUT = 2000;
   
    private final String url;
    Properties properties;
    private HomePage homePage;
    private  ProductsPage productPage;
    private String productName;
    private String searchString;
    public ProductSearchSteps()
    {
        System.out.println("User dir --" + System.getProperty("user.dir"));
        System.out.println("Envi--" + System.getProperty("env"));
        //InputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\"+System.getProperty("env")+".properties");
        try {
            InputStream in = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testEnv1.properties");
            properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load the property file: " + e.getMessage(), e);
        }
        url = properties.getProperty("base.url");
        homePage = new HomePage(driver,url);
        productPage = new ProductsPage(driver,url);
    }


    @Given("^I am on the home page of the site$")
    public void iAmOnTheHomePageOfTheSite()  {
        homePage.go();
        homePage.isHomePage();
    }

    @When("^I select \"([^\"]*)\" for search$")
    public void iSelectForSearch(String product) {
    	searchString=product;
        productPage.go();
        productPage.searchForProduct(product);
    }

    @And("^I get the list of products containing \"([^\"]*)\"$")
    public void iGetTheListOfProductsContaining(String productList)  {
        productName =productList;
        productPage.verifySearchResults(productList);
    }
    @Then("^Search results take you to the Page \"([^\"]*)\"$")
    public void searchResultsTakeYouToThePage(String arg0) {
        productPage.verifyProductLink(productName, arg0);
        productPage.goBack();
        if(searchString.equalsIgnoreCase("Nasal Pillow"))
        {
        	productPage.verifyProductLink("AirFit P10 for Her", "AirFit P10 for Her | ResMed");
        }
    }

    @And("^should have a video link \"([^\"]*)\"$")
    public void shouldHaveAVideoLink(String arg0) throws Throwable {
        
    }


}

