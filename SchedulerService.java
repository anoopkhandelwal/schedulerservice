package com.company.scheduler;
import java.util.concurrent.*;

public class SchedulerService implements ScheduledExecutorInterface{
    private ThreadPoolExecutor threadPoolExecutor;

    public SchedulerService(){
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(5, 10, Long.MAX_VALUE, TimeUnit.NANOSECONDS, queue) {
            @Override
            protected void afterExecute(Runnable runnable, Throwable throwable) {
                if (throwable != null) {
                    System.out.println("Uncaught exception in Postgresql THREAD POOL");
                }
            }
        };
    }
    @Override
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        delay = unit.toMillis(delay);
        try {
            Thread.sleep(delay);
            threadPoolExecutor.submit(command);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        try {
            Thread.sleep(initialDelay);
            while (true){
                schedule(command,period,unit);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {

    }
}
