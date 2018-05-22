package io.ponchitaz.my1staaproject;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Polina on 22.05.2018.
 */

public abstract class CatSimpleAsyncTask<Param> extends SimpleAsyncTask<Param> {

    private Thread catBackgroundThread;  // worker thread

    protected abstract void onPreExecute();
    protected abstract Param doInBackground();
    protected abstract void onPostExecute();

    @Override
    public void execute() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onPreExecute();  // runs on UI thread
                catBackgroundThread = new Thread("Handler_executor_thread") {
                    @Override
                    public void run() {
                        doInBackground();  // runs on new thread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                onPostExecute();  // runs on UI thread again
                            }
                        });
                    }
                };
                catBackgroundThread.start();
            }
        });
    }
    private void runOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
    @Override
    public void cancel() {
        catWasCancelled = true;
        if (catBackgroundThread != null) {
            catBackgroundThread.interrupt();  // cancels the worker thread
        }
    }
    @Override
    protected void publishProgress(final Param... values) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onProgressUpdate(values);  // runs on UI thread
            }
        });
    }
}
