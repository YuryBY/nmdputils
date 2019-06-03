package com.epam.bakhmutski.utils;

import java.util.Random;

public class Runner {
    //    static String inputDirectory = "e:\\cur\\nmdp\\WMDA_EXAMPLES2\\SubmitPartnerBMDWDonorSupplierStatus.xml";
//    static String inputDirectory = "e:\\cur\\nmdp\\WMDA_EXAMPLES2";

    public static void main(String[] args) throws Exception {
        SpringSchedulerTester.activity();
//        if (args.length > 0) {
//            Reader.read(args[0]);
//        } else {
//            throw new IllegalArgumentException("There is no path to files provided");
//        }
//        new Producer().run();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            int offset = 0;
            Random rand = new Random();
            int quantity = 10;
            int timeout = 4000;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = offset; i < offset + quantity; i++) {
                    System.out.println(Reader.sourceChannel.get(i));
                }
                quantity = rand.nextInt(100);
                timeout = rand.nextInt(10000);
            }
        }
    }
}
