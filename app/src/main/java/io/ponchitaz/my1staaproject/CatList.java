package io.ponchitaz.my1staaproject;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class CatList extends AppCompatActivity {

    @Nullable
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);

        RecyclerView catListRecyclerView = (RecyclerView) findViewById(R.id.catListRecyclerViewContainer);
        RecyclerView.LayoutManager catLayoutManager;
        if (getResources().getBoolean(R.bool.is_landscape)) {
            catLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        } else {
            catLayoutManager = new LinearLayoutManager(this);
        }
        catListRecyclerView.setLayoutManager(catLayoutManager);

        CatListRecyclerAdapter.OnItemClickListener onItemClickListener = new CatListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull AllTheCats cat, int position) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(CatList.this, R.raw.cat_meow);
                mediaPlayer.start();
                }
            };
        catListRecyclerView.setAdapter(new CatListRecyclerAdapter(generateCats(), onItemClickListener));
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @NonNull
    public static List<AllTheCats> generateCats() {
        List<AllTheCats> allTheCats = new ArrayList<>();
        allTheCats.add(new AllTheCats("https://mtdata.ru/u28/photo96CE/20466331848-0/original.jpg"));
        allTheCats.add(new AllTheCats("http://bipbap.ru/wp-content/uploads/2017/08/5114e7b13c84a77355cbec162ca7ff45.jpg"));
        allTheCats.add(new AllTheCats("http://bipbap.ru/wp-content/uploads/2017/09/2189909404.jpg"));
        allTheCats.add(new AllTheCats("http://kakzachem.ru/wp-content/uploads/2018/01/Bez-imeni-2-8.jpg"));
        allTheCats.add(new AllTheCats("https://static2.shop033.com/resources/18/160536/picture/5D/85442141.jpg"));
        allTheCats.add(new AllTheCats("https://gloss.ua/file/t/17/11/28/bqeye_640x360.jpg"));
        allTheCats.add(new AllTheCats("https://obovsem.pp.ua/wp-content/uploads/kotiki-31.jpg"));
        allTheCats.add(new AllTheCats("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450"));
        allTheCats.add(new AllTheCats("https://www.kedisahiplendirme.com/wp-content/uploads/2018/04/Scottish-Fold.jpg"));
        allTheCats.add(new AllTheCats("http://honesttopaws.com/wp-content/uploads/sites/5/2017/05/banana-cat-1.png"));
        allTheCats.add(new AllTheCats("http://www.catster.com/wp-content/uploads/2017/10/A-kitten-meowing-with-his-mouth-open.jpg"));
        allTheCats.add(new AllTheCats("https://static.euronews.com/articles/432451/603x339_432451.jpg"));
        return allTheCats;
    }
}
