package com.epam.bakhmutski.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.util.List;
import java.util.concurrent.Future;

@Configuration
@EnableAsync
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
public class Application implements CommandLineRunner {

    @Autowired
    Reader reader;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(reader.test().get());
        reader.reportCurrentTime();
//        // Start the clock
//        long start = System.currentTimeMillis();
//        if (args.length > 0) {
//            File filesPath = new File(args[0]);
//            if (filesPath.isDirectory()) {
//                for (File filePath : filesPath.listFiles()) {
//                    Future<List<String>> list = reader.readToFuture(filePath.toString());
//                    System.out.println(list.get());
//                }
//            }
//        } else {
//            throw new IllegalArgumentException("There is no path to files provided");
//        }
//        // Print results, including elapsed time
//        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
