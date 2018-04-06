package com.example.chengkai.volleybymyself.http;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangsujuan on 2018/4/6.
 */

public class ThreadPoolManager {

    //1、把任务添加到请求队列中
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    //添加任务,把调用层取过来到任务放入请求队列中
    public void execute(Runnable runnable) {
        if (runnable != null) {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //2、把队列中到任务放入到线程池
    private ThreadPoolExecutor threadPoolExecutor;

    private ThreadPoolManager() {
        threadPoolExecutor = new ThreadPoolExecutor(4, 20, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), rejectedExecutionHandler);
        threadPoolExecutor.execute(runnable);
    }

    //线程池拒绝策略，防止15s内没处理完，线程池会丢弃线程
    private RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //参数r就是超时线程
            try {
                queue.put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    //3、让线程池工作起来
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Runnable runnable1 = null;
                //从队列中取出请求
                try {
                    runnable1 = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (runnable1 != null) {
                    threadPoolExecutor.execute(runnable1);
                }
            }
        }
    };

    private static ThreadPoolManager ourInstance = new ThreadPoolManager();

    public static ThreadPoolManager getOurInstance() {
        return ourInstance;
    }
}
