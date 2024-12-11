package com.example.androidev;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    CardView setup, activities, broadcast, design, networking, data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize CardViews using the view object
        setup = view.findViewById(R.id.setup);
        activities = view.findViewById(R.id.activities);
        broadcast = view.findViewById(R.id.broadcast);
        design = view.findViewById(R.id.design);
        networking = view.findViewById(R.id.networking);
        data = view.findViewById(R.id.data);

        // Set up click listeners
        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Example: Navigate to another activity
                Intent intent = new Intent(getActivity(), SetupActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another fragment
                Intent intent = new Intent(getActivity(), ActivitiesActivity.class); // Replace with your target activity
                startActivity(intent);            }
        });

        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another activity
                Intent intent = new Intent(getActivity(), BroadcastActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another fragment
                Intent intent = new Intent(getActivity(), UdesignActivity.class); // Replace with your target activity
                startActivity(intent);            }
        });

        networking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Example: Navigate to another activity
                Intent intent = new Intent(getActivity(), NetworkingActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Example: Navigate to another activity
                Intent intent = new Intent(getActivity(), StorageActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        return view; // Return the inflated view
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment); // Replace R.id.fragment_container with your container ID
        transaction.addToBackStack(null); // Optional: add to back stack for navigation
        transaction.commit();
    }
}
