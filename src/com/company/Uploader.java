package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {
    private int fileSize = 500;
    private CountDownLatch cdl;

    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
        start();
    }

    @Override
    public void run() {
        System.out.println("Скачиваеться файл с размером " + fileSize);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Файл скачался ");
        cdl.countDown();
    }
}
