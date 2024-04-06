package com.example.spotifywrapped;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopSongsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopSongsFragment extends Fragment {

    private Call mCall;
    public ArrayList<String> topSongs = new ArrayList<>();
    private final OkHttpClient mOkHttpClient = new OkHttpClient();

    public static final String REDIRECT_URI = "spotifywrapped://auth";
    public TopSongsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     @return A new instance of fragment TopSongsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopSongsFragment newInstance(String param1, String param2) {
        TopSongsFragment fragment = new TopSongsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.fragment_top_songs, container, false);
        ArrayList<String> topSongs = getArguments().getStringArrayList("top_songs");
        this.topSongs = topSongs;

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        LinearLayout myLinearLayout = view.findViewById(R.id.topSongsLayout);
        for (String songName : topSongs) {
            Log.w("somethig", songName);
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            TextView songTextView = (TextView) inflater.inflate(R.layout.textview, myLinearLayout, false);
            songTextView.setText(songName);
            myLinearLayout.addView(songTextView);
        }
    }

    private Uri getRedirectUri() {
        return Uri.parse(REDIRECT_URI);
    }
    private void cancelCall() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
