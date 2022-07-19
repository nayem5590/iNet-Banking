package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.Properties;

public class ReadConfig
{
    Properties pro;

    public ReadConfig()
    {
        File src = new File("./Configurations/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro =new Properties();
            pro.load(fis);
        } catch (Exception e){
            System.out.println("Exception is "+ e.getMessage());
        }

    }

    public String getApplicationURL(){
        String url= pro.getProperty("baseURL");
        return url;
    }

    public String getUsername(){
        String username = pro.getProperty("username");
        return username;
    }

    public String getPassword(){
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromepath(){
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }

    public String getedpath(){
        String edpath= pro.getProperty("edpath");
        return edpath;
    }

    public String getFirefoxpath(){
        String firefoxpath= pro.getProperty("firefoxpath");
        return firefoxpath;
    }


}
