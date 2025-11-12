package com.EvertecTest.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvVariables {
    private static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./.env");
        props.load(file);
        return props;
    }

    private static String dotenv(String key) {
        try {
            return getProp().getProperty(key);
        } catch (IOException ex) {
            return System.getenv(key);
        }
    }

    public static String BASE_URL = dotenv("BASE_URL");
    public static String AUTH_BASE_URL = dotenv("AUTH_BASE_URL");
    public static String USER = dotenv("USER");
}
