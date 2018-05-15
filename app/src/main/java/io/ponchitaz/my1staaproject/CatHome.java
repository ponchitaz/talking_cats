package io.ponchitaz.my1staaproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatHome extends AppCompatActivity {

    Button listOfCats;

    @Nullable
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_home);

        listOfCats = (Button) findViewById(R.id.to_the_cats_list_btn);
        listOfCats.setOnClickListener(ActionListener);
    }
    private View.OnClickListener ActionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(CatHome.this, R.raw.cat_meow_2);
            mediaPlayer.start();

            Intent catList = new Intent(CatHome.this, CatList.class);
            startActivity(catList);
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
