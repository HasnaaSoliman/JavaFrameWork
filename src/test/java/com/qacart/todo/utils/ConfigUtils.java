package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        String env = System.getProperty("env", "PRODUCTION");
        switch (env) {
            case "PRODUCTION":
                properties = PropertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("Environment is not Supported");

        }
    }

    public  static ConfigUtils GetInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public String GetBaseUrl(){
      String prop= properties.getProperty("baseurl");
      if(prop!=null) return prop;
      throw new RuntimeException("could not find the base url in property file");
    }
    public String GetEmail(){
        String prop= properties.getProperty("email");
        if(prop!=null) return prop;
        throw new RuntimeException("could not find the email in property file");
    }
    public String GetPassword(){
        String prop= properties.getProperty("password");
        if(prop!=null) return prop;
        throw new RuntimeException("could not find the password in property file");
    }
}
