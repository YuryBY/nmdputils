package com.epam.bakhmutski.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class Reader {
    static List<String> sourceChannel = new ArrayList();

    @Async
    public Future<List<String>> readToFuture(String path) throws Exception {
        List<String> resultList = new ArrayList<>();
        byte[] inputBytes = Files.readAllBytes(Paths.get(path));
        String inputString = new String(inputBytes);
        String resultString = inputString.replaceAll("\\r\\n", "");
        String delimiter = "envelope>\"";
        String[] items = resultString.split(delimiter);
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].substring(1);
            items[i] = items[i] + "envelope>";
            resultList.add(items[i]);
        }
        return new AsyncResult<>(resultList);
    }

    @Async
    public void read(String path) throws Exception {
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
