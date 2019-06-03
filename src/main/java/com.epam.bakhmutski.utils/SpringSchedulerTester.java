package com.epam.bakhmutski.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Future;

@Component
public class SpringSchedulerTester {

    @Async
    public void asyncMethodWithVoidReturnType() {
        while (true){
        System.out.println("Execute method asynchronously. "
                + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    @Async
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }

        return null;
    }

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
