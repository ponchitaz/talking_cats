package io.ponchitaz.my1staaproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ThreadsMain extends AppCompatActivity {

    ImageButton threadCat;
    ImageButton asyncCat;

    @Nullable
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads_main);

        threadCat = (ImageButton) findViewById(R.id.threadsForCats);
        asyncCat = (ImageButton) findViewById(R.id.asyncForHaters);

        threadCat.setOnClickListener(ActionListener);
        asyncCat.setOnClickListener(ActionListener);
    }

    private View.OnClickListener ActionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.asyncForHaters:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(ThreadsMain.this, R.raw.cat_meow_2);
                    mediaPlayer.start();

                    Intent catRunThread = new Intent(ThreadsMain.this, CatRunAsyncTask.class);
                    startActivity(catRunThread);
                    break;

                case R.id.threadsForCats:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(ThreadsMain.this, R.raw.cat_meow);
                    mediaPlayer.start();

                    Intent catRunAsync = new Intent(ThreadsMain.this, CatRunThread.class);
                    startActivity(catRunAsync);
                    break;

            }
        }
    };
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

