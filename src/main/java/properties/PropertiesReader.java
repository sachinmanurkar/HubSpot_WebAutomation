package properties;

import org.testng.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {


    public Properties properties;

    public PropertiesReader() {

        properties = new Properties();

        String env = BaseProperties.qa_env;

        Reporter.log("ENV: " + BaseProperties.qa_env, true);

        String propertiesFilePath = env + ".properties";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getUrl() {
        return properties.getProperty("base_url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

}
