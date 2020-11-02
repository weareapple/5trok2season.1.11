package com.company;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
public class Main {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cdlUple = new CountDownLatch(1);
        CountDownLatch cdlDown = new CountDownLatch(10);

        Semaphore semaphore = new Semaphore(3,true);
        new Uploader(cdlUple);

        for (int i = 1; i < 11; i++) {
            new Downloaders("Человек" + i ,cdlDown,cdlUple,semaphore);
        }

        cdlDown.await();
        System.out.println("Файл удалиться через 10 секунд");
        Thread.sleep(10000);


    }
}
