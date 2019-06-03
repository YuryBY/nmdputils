package com.epam.bakhmutski.utils;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpringSchedulerTester {

    @Scheduled(fixedRateString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10*60*1000) }",
            initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10*60*1000) }")
//    @Scheduled(fixedRate = 600000, initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10*60*1000) }")
    public static void activity(){
        System.out.println("!!!The message scheduled by Spring");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

}
