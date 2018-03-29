package com.example.cvolk.threadpoolexecutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runThreads(View view) {
        random = new Random();

        for (int i = 1; i < 5; i++) {
            DefaultExecutorSupplier.getSupplier().forBackgroundTasks()
                    .execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(random.nextInt(((10000 - 1000) + 1) + 1000));
                            } catch(InterruptedException e) {

                            }
                        }
                    });
        }
    }
}
