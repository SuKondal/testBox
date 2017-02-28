package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin   = { "pretty","html:target/cucumber-html-report/","json:target/cucumber-json-report.json","rerun:target/rerun.txt"},
        features = {"src/test/resources/features"},
        glue = {"classpath:stepsDef","classpath:runner"}
		//tags={"@reg"}
        
)
public class Runner {
	
	
	 @BeforeClass
	    public static void setup() {
		        System.out.println("Ran the before class");
		}

	    @AfterClass
	    public static void teardown() {
	        System.out.println("Ran the after class");
	    }
	
}
