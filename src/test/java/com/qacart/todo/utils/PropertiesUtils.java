package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties loadproperties(String FilePath){
        File file=new File(FilePath);

        try {
            InputStream inputStream=new FileInputStream(file);
            Properties properties=new Properties();
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Is not Found");
        } catch (IOException e) {
            throw new RuntimeException("Error While Loading The Properties");
        }
    }
}
