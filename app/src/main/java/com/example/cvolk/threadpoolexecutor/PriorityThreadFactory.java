package com.example.cvolk.threadpoolexecutor;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

    private final int threadPriority;

    public PriorityThreadFactory(int threadPriority) {
        this.threadPriority = threadPriority;
    }

    @Override
    public Thread newThread(final Runnable runnable) {
        Runnable wrapperRunnable = new Runnable() {

            @Override
            public void run() {
                try {
                    Process.setThreadPriority(threadPriority);
                }
                catch (Throwable t) {

                }

                runnable.run();
            }
        };

        return new Thread(wrapperRunnable);
    }
}
