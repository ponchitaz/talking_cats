package io.ponchitaz.my1staaproject;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

import java.util.concurrent.TimeUnit;

/**
 * Created by Polina on 21.05.2018.
 */

public class CounterAsyncTask extends AsyncTask<Integer, Integer, Integer> {

    private IAsyncTaskEvents mIAsyncTaskEvents;

    public CounterAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        mIAsyncTaskEvents = iAsyncTaskEvents;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int catStart, catEnd;
        if (integers.length == 2) {
            catStart = integers[0];
            catEnd = integers[1];
        } else {
            catStart = 0;
            catEnd = 10;
        }

        for (int i = catStart; i <= catEnd; i++) {
            if(isCancelled()) {
                return i;
            }
            publishProgress(i);
            SystemClock.sleep(500);
        }

        return catEnd;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onPreExecute();
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onPostExecute();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onProgressUpdate(values[0]);
        }
    }

    @Override
    protected void onCancelled(Integer aInteger) {
        super.onCancelled(aInteger);
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onCancel();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onCancel();
        }
    }
}