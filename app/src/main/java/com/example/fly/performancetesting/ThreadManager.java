package com.example.fly.performancetesting;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/zedosu/p/6665306.html
 */
public class ThreadManager {

    /**
     * 线程数量
     */
    private final int maxThreadCount = 5;

    /**
     * 操作线程池
     */
    private ThreadPoolExecutor mThreadPool;

    /**
     * 线程队列
     */
//    private PriorityBlockingQueue mThreadQueue;

    /**
     * 任务比较
     */
    private Comparator<PrioriTask> mCompare;

    private ThreadManager() {
        final long keepAliveTime = 60L; // 线程池中超过corePoolSize数目的空闲线程最大存活时间
        Comparator<PrioriTask> mCompare = new TaskCompare();
        PriorityBlockingQueue mThreadQueue = new PriorityBlockingQueue<PrioriTask>(maxThreadCount, mCompare);
        mThreadPool = new ThreadPoolExecutor(maxThreadCount, Integer.MAX_VALUE, keepAliveTime, TimeUnit.SECONDS, mThreadQueue);
    }

    /**
     * 获取线程管理实例
     *
     * @return 线程管理实例
     */
    public static ThreadManager getInstance() {
        return ThreadManagerIn.INSTANCE;
    }

    private static class ThreadManagerIn{
        private static final ThreadManager INSTANCE = new ThreadManager();
    }

    /**
     * 使用
     *
     * @param task     需要执行的任务
     * @param priority {@link ThreadPeriod} 优先级
     */
    public void executorThread(Runnable task, int priority) {
        if (!mThreadPool.isShutdown()) {
            mThreadPool.execute(new PrioriTask(priority, task));
        }
    }

    /**
     * 结束掉所有线程,并且回收（正在进行的有可能结束不掉）
     */
    public void shutDownAll() {
        mThreadPool.shutdownNow();
//        instance = null;
    }

    /**
     * 优先级任务
     */
    private class PrioriTask implements Runnable {
        private int priori;

        private Runnable task;

        /**
         * Cnstructor Method。
         *
         * @param priority 优先级
         * @param runnable 线程
         */
        public PrioriTask(int priority, Runnable runnable) {
            priori = priority;
            task = runnable;
        }

        public int getPriori() {
            return priori;
        }

        public void setPriori(int priori) {
            this.priori = priori;
        }

        public Runnable getTask() {
            return task;
        }

        public void setTask(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            if (task != null) {
                task.run();
            }
        }

    }

    /**
     * 任务比较器
     */
    private class TaskCompare implements Comparator<PrioriTask> {

        @Override
        public int compare(PrioriTask lhs, PrioriTask rhs) {
            return rhs.getPriori() - lhs.getPriori();
        }
    }

    /**
     * 线程优先级
     */
    static class ThreadPeriod {
        /**
         * 线程优先级 低
         */
        static final int PERIOD_LOW = 1;

        /**
         * 线程优先级 中
         */
        static final int PERIOD_MIDDLE = 5;

        /**
         * 线程优先级 高
         */
        static final int PERIOD_HIGHT = 10;
    }
}