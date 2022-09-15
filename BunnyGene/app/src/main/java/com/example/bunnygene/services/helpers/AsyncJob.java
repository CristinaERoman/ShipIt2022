package com.example.bunnygene.services.helpers;

import android.os.AsyncTask;

public class AsyncJob extends AsyncTask<AsyncInput, AsyncInput, Void> {

    int times = 0;
    @Override
    protected Void doInBackground(AsyncInput... inputs) {

        try {
            this.times ++;
            Thread.sleep(inputs[0].frequency);
            publishProgress(inputs);
            if(this.times < inputs[0].times){
                doInBackground(inputs);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onProgressUpdate(AsyncInput... inputs) {
        try {
            inputs[0].methodParam.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
