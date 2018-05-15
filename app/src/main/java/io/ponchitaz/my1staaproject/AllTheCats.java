package io.ponchitaz.my1staaproject;

import android.support.annotation.NonNull;

/**
 * Created by Polina on 14.05.2018.
 */

public class AllTheCats {
    @NonNull
    private final String url;

    public AllTheCats(@NonNull String url) {
        this.url = url;
    }

    @NonNull
    public String getUrl() {
        return url;
    }
}
