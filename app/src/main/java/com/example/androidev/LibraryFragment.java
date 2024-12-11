package com.example.androidev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LibraryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    public void openLink1(View view) {
        openUrl("https://developer.android.com/");
    }

    public void openLink2(View view) {
        openUrl("https://www.geeksforgeeks.org/kotlin-vs-java/");
    }

    public void openVideo1(View view) {
        openUrl("https://www.youtube.com/watch?v=fis26HvvDII");
    }

    public void openVideo2(View view) {
        openUrl("https://www.youtube.com/watch?v=7p92tNhjwLQ");
    }

    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // Use getActivity() instead of 'this' for fragments
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Failed to open link.", Toast.LENGTH_SHORT).show();
        }
    }
}
