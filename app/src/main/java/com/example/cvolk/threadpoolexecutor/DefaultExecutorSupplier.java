package com.example.cvolk.threadpoolexecutor;

import android.os.Process;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultExecutorSupplier {

    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor forBackgroundTasks;
    private final Executor mainThreadExecutor;
    private static DefaultExecutorSupplier supplier;

    private DefaultExecutorSupplier() {
        ThreadFactory backgroundPriorityThreadFactory =
                new PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);

        forBackgroundTasks = new ThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                backgroundPriorityThreadFactory
        );

        mainThreadExecutor = new MainThreadExecutor();
    }

    public static DefaultExecutorSupplier getSupplier() {
        if (supplier == null) {
            synchronized (DefaultExecutorSupplier.class) {
                supplier = new DefaultExecutorSupplier();
            }
        }

        return supplier;
    }

    public ThreadPoolExecutor forBackgroundTasks() {
        return forBackgroundTasks;
    }

    public Executor forMainThreadTasks() {
        return mainThreadExecutor;
    }
}
