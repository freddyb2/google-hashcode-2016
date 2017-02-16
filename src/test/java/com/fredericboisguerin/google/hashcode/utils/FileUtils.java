package com.fredericboisguerin.google.hashcode.utils;

import java.io.File;
import java.net.URL;

public class FileUtils {

    public static File getFile(Class clazz, String resourcePath) {
        ClassLoader classLoader = clazz.getClassLoader();
        URL resource = classLoader.getResource(resourcePath);
        if (resource == null) {
            throw new IllegalArgumentException("Unknown resource: " + resourcePath);
        }
        String filePath = resource.getFile();
        return new File(filePath);
    }
}
