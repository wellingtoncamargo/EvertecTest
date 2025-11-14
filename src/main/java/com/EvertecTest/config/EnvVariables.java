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

    private static String dotenv() {
        try {
            return getProp().getProperty("BASE_URL");
        } catch (IOException ex) {
            return System.getenv("BASE_URL");
        }
    }

    public static String BASE_URL = dotenv();
}
