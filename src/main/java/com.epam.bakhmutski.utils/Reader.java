package com.epam.bakhmutski.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    static List<String> sourceChannel = new ArrayList();

    public static void read(String path) throws Exception {
        File filesPath = new File(path);
        if (filesPath.isDirectory()) {
            File[] fileNames = filesPath.listFiles();
            for (File filePath : fileNames) {
                readFromFile(filePath.getPath());
            }
        } else {
            readFromFile(path);
        }
    }

    private static void readFromFile(String path) throws IOException {
        byte[] inputBytes = Files.readAllBytes(Paths.get(path));
        String inputString = new String(inputBytes);
        String result = inputString.replaceAll("\\r\\n", "");
        String delimiter = "envelope>\"";
        String[] items = result.split(delimiter);
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].substring(1);
            items[i] = items[i] + "envelope>";
            sourceChannel.add(items[i]);
        }
    }

}
