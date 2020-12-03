package com.example.highwidget;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MyTab extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_tab);

        TabHost tabHost = getTabHost();
        tabHost.setBackgroundColor(Color.RED);
        TabHost.TabSpec tabSpecSong  = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong2);
        //String tag = tabSpecSong.getTag();
        tabHost.addTab(tabSpecSong);


        TabHost.TabSpec tabSpecArtist  = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist2);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum  = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum2);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);


    }
}
