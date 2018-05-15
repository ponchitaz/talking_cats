package io.ponchitaz.my1staaproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CatTalks extends AppCompatActivity {

    TextView catWords;
    Button aboutCats;

    @Nullable
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_talks);

        catWords = (TextView) findViewById(R.id.catWords);
        aboutCats = (Button) findViewById(R.id.aboutCatsBtn);

        aboutCats.setOnClickListener(ActionListener);

        Intent intent = getIntent();
        String catSaid = intent.getStringExtra("catSays");
        catWords.setText(catSaid);
    }
    private View.OnClickListener ActionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(CatTalks.this, R.raw.cat_meow_2);
            mediaPlayer.start();

            Intent catInfo = new Intent(CatTalks.this, CatHome.class);
            startActivity(catInfo);
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
