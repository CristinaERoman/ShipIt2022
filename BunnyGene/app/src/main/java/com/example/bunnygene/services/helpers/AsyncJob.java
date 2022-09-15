package com.example.bunnygene.services.helpers;

import android.os.AsyncTask;

public class AsyncJob extends AsyncTask<AsyncInput, AsyncInput, Void> {


    @Override
    protected Void doInBackground(AsyncInput... inputs) {

        try {
            Thread.sleep(inputs[0].frequency);
            publishProgress(inputs);
            doInBackground(inputs);
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
