package loadingProperties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class LoadingProperties {
    public static final Properties properties = new Properties();
    public static void loadingProperties(){
        try (BufferedReader reader = new BufferedReader(new FileReader("config.properties"))){
            properties.load(reader);
        }catch (Exception exception){
            System.out.println("Problem during loading properties: " + exception.getMessage());
        }
//        System.out.println(properties.getProperty("database_url"));
    }
}
