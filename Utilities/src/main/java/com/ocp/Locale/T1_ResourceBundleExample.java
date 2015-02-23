package com.ocp.Locale;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;

/**
 * Created by Rox on 23.02.2015.
 */
public class T1_ResourceBundleExample {

    public static void main(String [] args) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls) {
            System.out.println(url.getFile());
        }

        ResourceBundle rb = ResourceBundle.getBundle("MyResouceBundle");
        rb.getString("hello");
    }
}
