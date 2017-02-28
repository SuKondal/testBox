package runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceManager {
    Properties prop;
    String env;
    String browser;
    private static final Logger LOG = LoggerFactory.getLogger(ResourceManager.class);
    public Properties setup()

    {
        env = (System.getProperty("env") == null) ? "testEnv1" : System.getProperty("env");
        System.out.println("User dir --" + System.getProperty("user.dir"));
        System.out.println("Envi--Running Hooks");
        InputStream in1= null , in= null;
        try {
                 in1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\" + env + ".properties");
                in = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\UIMap.properties");

        System.out.println("loading properties from:" + System.getProperty("user.dir") + "\\src\\test\\resources\\" + env + ".properties");
        String uiRequired = System.getProperty("ui");
        // InputStream in1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\test1.properties");
        prop = new Properties();
        prop.load(in);
        prop.load(in1);
        browser = browser.toLowerCase();
        } catch (FileNotFoundException e) {

            LOG.info("Could not find the properties file");
            e.printStackTrace();
        }catch (IOException e) {
            LOG.info("Could not load properties files");
        }
        return prop;
    }


}
