package stepsDef;

import runner.ResourceManager;
import runner.Hooks;

import org.openqa.selenium.WebDriver;

public class AbstractSteps {

    protected WebDriver driver;
    protected ResourceManager resourcemanager;

    public AbstractSteps(){
        this.driver= Hooks.driver;
        //this.resourcemanager=resourcemanager;
    }
}