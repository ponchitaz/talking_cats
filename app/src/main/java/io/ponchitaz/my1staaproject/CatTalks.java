package io.ponchitaz.my1staaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CatTalks extends AppCompatActivity {

    TextView catWords;
    Button aboutCats;

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
            Intent catInfo = new Intent(CatTalks.this, CatHome.class);
            startActivity(catInfo);
        }
    };
}
