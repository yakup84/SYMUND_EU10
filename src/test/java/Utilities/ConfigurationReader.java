package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

  private static Properties properties = new Properties();

    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream("Configuration.properties");
            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("File path can not be found");
            e.printStackTrace();
        }


    }

    public static String getProperty(String key){

        return  properties.getProperty(key);
    }




}
