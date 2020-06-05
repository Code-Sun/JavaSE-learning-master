package com.edu.sunyifeng.Utils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemUtil {

    public static void printSystemProperties() {
        Properties properties = System.getProperties();
        for (String name : properties.stringPropertyNames()) {
            System.out.println(name + "=" + properties.getProperty(name));
        }
    }

    public static String writeSystemPropertiestoFile(String file) {
        Properties properties = System.getProperties();
        try {
            PrintStream stream = new PrintStream(file);
            properties.list(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }


    public static void main(String[] args) {
        writeSystemPropertiestoFile("D:\\p.txt");
        printSystemProperties();
    }


}
