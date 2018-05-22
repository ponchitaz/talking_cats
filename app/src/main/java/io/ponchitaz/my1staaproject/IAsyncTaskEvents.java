package io.ponchitaz.my1staaproject;

/**
 * Created by Polina on 21.05.2018.
 */

public interface IAsyncTaskEvents {
    void onPreExecute();

    void onPostExecute();

    void onProgressUpdate(Integer integer);

    void onCancel();
}
