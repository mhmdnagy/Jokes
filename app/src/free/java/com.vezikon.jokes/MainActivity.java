package com.vezikon.jokes;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vezikon.clueviewer.ClueViewer;


public class MainActivity extends AppCompatActivity implements JokesFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.FLAVOR.equals("free")) {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, JokesFragment.newInstance())
                    .commit();
    }


    @Override
    public void onListFragmentInteraction(Joke item) {
        ClueViewer.getInstance().view(this, item.getClue());
    }
}
