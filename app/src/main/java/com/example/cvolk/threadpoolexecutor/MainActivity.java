package com.example.cvolk.threadpoolexecutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;
    private ProgressBar bar1;
    private ProgressBar bar2;
    private ProgressBar bar3;
    private ProgressBar bar4;
    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    public void runThreads(View view) {
        random = new Random();

        bar1.setProgress(0);
        bar2.setProgress(0);
        bar3.setProgress(0);
        bar4.setProgress(0);
        
        DefaultExecutorSupplier.getSupplier().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                seconds = random.nextInt(10 - 1) + 1;
                bar1.setMax(seconds*10);

                int progress = 0;
                for (int i = 0; i < seconds; i++) {
                    try {
                        Thread.sleep(1000);
                        progress += 10;

                        bar1.setProgress(progress);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        });

        DefaultExecutorSupplier.getSupplier().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                seconds = random.nextInt(10 - 1) + 1;
                bar2.setMax(seconds*10);

                int progress = 0;
                for (int i = 0; i < seconds; i++) {
                    try {
                        Thread.sleep(1000);
                        progress += 10;

                        bar2.setProgress(progress);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        });

        DefaultExecutorSupplier.getSupplier().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                seconds = random.nextInt(10 - 1) + 1;
                bar3.setMax(seconds*10);

                int progress = 0;
                for (int i = 0; i < seconds; i++) {
                    try {
                        Thread.sleep(1000);
                        progress += 10;

                        bar3.setProgress(progress);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        });

        DefaultExecutorSupplier.getSupplier().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                seconds = random.nextInt(10 - 1) + 1;
                bar4.setMax(seconds*10);

                int progress = 0;
                for (int i = 0; i < seconds; i++) {
                    try {
                        Thread.sleep(1000);
                        progress += 10;

                        bar4.setProgress(progress);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        });
    }

    private void bindViews() {
        bar1 = (ProgressBar)findViewById(R.id.pb1);
        bar2 = (ProgressBar)findViewById(R.id.pb2);
        bar3 = (ProgressBar)findViewById(R.id.pb3);
        bar4 = (ProgressBar)findViewById(R.id.pb4);
    }
}
