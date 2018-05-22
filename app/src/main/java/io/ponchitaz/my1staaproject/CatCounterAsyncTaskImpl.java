package io.ponchitaz.my1staaproject;

import android.os.SystemClock;

/**
 * Created by Polina on 22.05.2018.
 */

public class CatCounterAsyncTaskImpl extends CatSimpleAsyncTask<Integer> {

    private IAsyncTaskEvents mIAsyncTaskEvents;

    public CatCounterAsyncTaskImpl(IAsyncTaskEvents iAsyncTaskEvents) {
            this.mIAsyncTaskEvents = iAsyncTaskEvents;
        }


        @Override
        protected void onPreExecute() {
            if (mIAsyncTaskEvents != null) {
                mIAsyncTaskEvents.onPreExecute();
            }
        }

        @Override
        protected Integer doInBackground() {
            int end = 10;
            for (int i = 0; i <= end; i++) {
                if(isCancelled()) {
                    return i;
                }
                publishProgress(i);
                SystemClock.sleep(500);
            }

            return end;
        }

        @Override
        protected void onPostExecute() {
            if (mIAsyncTaskEvents != null) {
                mIAsyncTaskEvents.onPostExecute();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (mIAsyncTaskEvents != null) {
                mIAsyncTaskEvents.onProgressUpdate(values[0]);
            }
        }
    }

