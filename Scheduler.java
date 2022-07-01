package com.company.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    public static void main(String[] args) {
        SchedulerService service = new SchedulerService();
        Task task = new Task();
        service.scheduleAtFixedRate(task,5,10,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(task,3,5,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(task,7,4,TimeUnit.SECONDS);

        ScheduledExecutorService scheduler
                = Executors.newScheduledThreadPool(11);

    }
}
