package com.vezikon.jokes;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vezikon.clueviewer.ClueViewer;


public class MainActivity extends AppCompatActivity implements JokesFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
