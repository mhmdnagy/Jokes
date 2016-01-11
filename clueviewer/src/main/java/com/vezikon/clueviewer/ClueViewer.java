package com.vezikon.clueviewer;

import android.content.Context;
import android.content.Intent;

/**
 * Created by vezikon on 1/11/16.
 */
public class ClueViewer {

    public static final String CLUE = "clue";

    private static ClueViewer ourInstance = new ClueViewer();

    public static ClueViewer getInstance() {
        return ourInstance;
    }

    /**
     * Use this method to start an activity holding a text.
     *
     * @param context the context of the current view
     * @param clue the text you want to view
     */
    public void view(Context context, String clue) {
        Intent intent = new Intent(context, ClueViewerActivity.class);
        intent.putExtra(CLUE, clue);
        context.startActivity(intent);
    }

}
