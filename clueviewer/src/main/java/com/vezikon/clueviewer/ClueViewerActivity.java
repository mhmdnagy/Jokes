package com.vezikon.clueviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClueViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue_viewer);

        TextView clue = (TextView) findViewById(R.id.clueText);

        String result = getIntent().getExtras().getString(ClueViewer.CLUE);

        if (result != null)
            clue.setText(result);

    }
}
