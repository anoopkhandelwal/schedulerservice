package com.company.scheduler;

import java.time.LocalDateTime;

public class Task implements Runnable{

    @Override
    public void run() {

        System.out.println("Task- "+ Thread.currentThread().getName() +" is executed at "+ LocalDateTime.now());
    }
}
