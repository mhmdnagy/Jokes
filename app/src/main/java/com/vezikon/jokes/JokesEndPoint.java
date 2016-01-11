package com.vezikon.jokes;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.vezikon.jokes.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by vezikon on 1/11/16.
 */
public class JokesEndPoint extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;

    private static final String TAG = "JsonGetTask";

    private JokesEndPointTaskListener jokesEndPointTaskListener = null;
    private Exception mError = null;

    public JokesEndPoint setListener(JokesEndPointTaskListener listener) {
        this.jokesEndPointTaskListener = listener;
        return this;
    }

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (this.jokesEndPointTaskListener != null)
            this.jokesEndPointTaskListener.onComplete(result, mError);


    }

    public static interface JokesEndPointTaskListener {
        public void onComplete(String jsonString, Exception e);
    }
}
