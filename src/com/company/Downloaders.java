package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders  extends Thread{
    private int speed = 100;
    private CountDownLatch cdlDown;
    private CountDownLatch cdlUple;
    private Semaphore semaphore;

    public Downloaders(String name,CountDownLatch cdlDown,
                       CountDownLatch cdlUple, Semaphore semaphore){
        super(name);
        this.cdlDown = cdlDown;
        this.cdlUple = cdlUple;
        this.semaphore = semaphore;
        start();
    }

    @Override
    public void run() {
        try {
            cdlUple.await();
            semaphore.acquire();
            System.out.println(getName()+ " Скачивает файл ");
            sleep(2000);
            System.out.println(getName() + " Скачал ");
            semaphore.release();
            cdlDown.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
