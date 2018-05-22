package io.ponchitaz.my1staaproject;

/**
 * Created by Polina on 22.05.2018.
 */

public abstract class SimpleAsyncTask<Param> {
    protected volatile boolean catWasCancelled = false;

    protected abstract void onPreExecute();
    protected abstract Param doInBackground();
    protected abstract void onPostExecute();
    protected abstract void execute();
    protected void onProgressUpdate(Param... values){

    }
    protected abstract void publishProgress(Param... values);
    protected abstract void cancel();
    public boolean isCancelled() {
        return catWasCancelled;
    }

}
