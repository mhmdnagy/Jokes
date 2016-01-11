package com.vezikon.jokes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class JokesFragment extends Fragment implements JokesEndPoint.JokesEndPointTaskListener {

    private OnListFragmentInteractionListener mListener;
    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public JokesFragment() {
    }

    public static JokesFragment newInstance() {
        JokesFragment fragment = new JokesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokes, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }

        //getting jokes from the server
        JokesEndPoint jokesEndPoint = new JokesEndPoint();
        jokesEndPoint.setListener(this);
        jokesEndPoint.execute(getActivity());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onComplete(String jsonString, Exception e) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            List<Joke> jokes = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                Joke joke = new Joke();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                joke.setJoke(jsonObject.getString("Joke"));
                joke.setClue(jsonObject.getString("clue"));
                jokes.add(joke);
            }

            recyclerView.setAdapter(new JokesRecyclerViewAdapter(jokes, mListener));

        } catch (JSONException ee) {
            ee.printStackTrace();
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Joke item);
    }
}
