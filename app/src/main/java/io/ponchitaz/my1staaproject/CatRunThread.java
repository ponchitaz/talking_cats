package io.ponchitaz.my1staaproject;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CatRunThread extends AppCompatActivity implements IAsyncTaskEvents, View.OnClickListener {

    private static final String TAG = "ThreadsActivity";

    Button createCat;
    Button startCat;
    Button cancelCat;
    TextView catProgress;
    ProgressBar catIsAlive;

    private CatSimpleAsyncTask catTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_run_thread);

        createCat = (Button) findViewById(R.id.createBtnOnAsync);
        startCat = (Button) findViewById(R.id.startBtnOnAsync);
        cancelCat = (Button) findViewById(R.id.cancelBtnOnAsync);
        catProgress = (TextView) findViewById(R.id.catWayCounter);
        catIsAlive = (ProgressBar) findViewById(R.id.catProgressBar);

        catIsAlive.setVisibility(View.INVISIBLE);

        createCat.setOnClickListener(this);
        startCat.setOnClickListener(this);
        cancelCat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createBtnOnAsync:
                doCreate();
                break;

            case R.id.startBtnOnAsync:
                doStart();
                break;

            case R.id.cancelBtnOnAsync:
                doCancel();
                break;
        }
    }
    private void doCreate() {
        catTask = new CatCounterAsyncTaskImpl(this);
        catIsAlive.setVisibility(View.VISIBLE);
        createCat.setVisibility(View.INVISIBLE);
    }

    private void doStart() {
        if ((catTask == null) || (catTask.isCancelled())) {
            Toast.makeText(this, R.string.toastAboutCatCreationThread, Toast.LENGTH_SHORT).show();
        } else {
            catTask.execute();
        }
    }

    private void doCancel() {
        catTask.cancel();
        catIsAlive.setVisibility(View.INVISIBLE);
        createCat.setVisibility(View.VISIBLE);
        startCat.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPreExecute() {
        createCat.setVisibility(View.INVISIBLE);
        startCat.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPostExecute() {
        if (catProgress.getText() == "10") {
            catProgress.setText(R.string.catWorkIsDone);
        } else {catProgress.setText(R.string.catInterrupted);}
        createCat.setVisibility(View.VISIBLE);
        startCat.setVisibility(View.VISIBLE);
        catIsAlive.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        catProgress.setText(String.valueOf(integer));
    }

    @Override
    public void onCancel() {
        catProgress.setText(R.string.catInterrupted);
    }

    @Override
    protected void onDestroy() {
        if (catTask != null) {
            catTask.cancel();
            catTask = null;
        }
        super.onDestroy();
    }
    public static void start(Context context) {
        context.startActivity(new Intent(context, CatRunAsyncTask.class));
    }
}
