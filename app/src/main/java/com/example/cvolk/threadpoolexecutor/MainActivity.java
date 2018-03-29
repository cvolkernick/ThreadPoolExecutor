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
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    public void runThreads(View view) {
        random = new Random();

        for (i = 1; i < 5; i++) {
            seconds = random.nextInt(((10 - 1) + 1) + 1);

            switch (i) {
                case 1:
                    bar1.setMax(seconds*10);
                    break;
                case 2:
                    bar2.setMax(seconds*10);
                    break;
                case 3:
                    bar3.setMax(seconds*10);
                    break;
                case 4:
                    bar4.setMax(seconds*10);
                    break;
            }

            DefaultExecutorSupplier.getSupplier().forBackgroundTasks().execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        int progress = 0;

                        for (int j = 1; j <= seconds ; j++) {
                            Thread.sleep(1000);
                            switch(i) {
                                case 1:
                                    bar1.setMax(seconds*10);
                                    bar1.setProgress(progress);
                                    break;
                                case 2:
                                    bar2.setMax(seconds*10);
                                    bar2.setProgress(progress);
                                    break;
                                case 3:
                                    bar3.setMax(seconds*10);
                                    bar3.setProgress(progress);
                                    break;
                                case 4:
                                    bar4.setMax(seconds*10);
                                    bar4.setProgress(progress);
                                    break;
                            }

                            progress += 10;
                        }
                    } catch(InterruptedException e) {

                    }
                }
            });
        }
    }

    private void bindViews() {
        bar1 = (ProgressBar)findViewById(R.id.pb1);
        bar2 = (ProgressBar)findViewById(R.id.pb2);
        bar3 = (ProgressBar)findViewById(R.id.pb3);
        bar4 = (ProgressBar)findViewById(R.id.pb4);
    }
}
