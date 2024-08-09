package automation.testingworld.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility {

    public static Object fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("src/test/Config/config.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }

    public static String fetchLocatorsValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("src/test/Config/Elements.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }
}
