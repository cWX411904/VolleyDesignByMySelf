package com.example.jett.dn_netframework_20180401.http;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 管理整个框架的运作
 */

public class ThreadPoolManager {
    private static ThreadPoolManager instance=new ThreadPoolManager();
    public static ThreadPoolManager getInstance(){
        return instance;
    }

    //请求队列   容量，大量的插入操作，阻塞
    private LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();
    //1.把调用层取过来的任务放入到请求队列中
    public void execute(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //2.把队列中的任务放入到线程沲去进行执行
    private ThreadPoolExecutor threadPoolExecutor;
    private ThreadPoolManager(){
        threadPoolExecutor=new ThreadPoolExecutor(4,20,15, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(4),rejectedExecutionHandler);
        threadPoolExecutor.execute(runnable);
    }
    private RejectedExecutionHandler rejectedExecutionHandler=new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                queue.put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    //让这些过程运作起来
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while(true){
                Runnable runnable=null;
                try {
                    runnable=queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(runnable!=null){
                    threadPoolExecutor.execute(runnable);
                }
            }
        }
    };



}








