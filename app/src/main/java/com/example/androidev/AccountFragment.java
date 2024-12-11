package com.example.androidev;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {

    // Declare views
    private ImageView profileImage;
    private TextView studentName, studentId, studentEmail, studentAttempts;
    private Button  logoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize views
        profileImage = view.findViewById(R.id.profileImage);
        studentName = view.findViewById(R.id.studentName);
        studentId = view.findViewById(R.id.studentId);
        studentEmail = view.findViewById(R.id.studentEmail);
        studentAttempts = view.findViewById(R.id.studentAttempts);
        logoutButton = view.findViewById(R.id.logoutButton);

        // Mock data - Replace this with data fetched from the backend or database
        loadStudentData();

        // Set up button listeners
        logoutButton.setOnClickListener(v -> logout());

        return view; // Return the inflated view
    }

    /**
     * Load student data into the UI.
     * Replace this method with real backend or database integration.
     */
    private void loadStudentData() {
        // Example data
        studentName.setText("Choice K unthai");
        studentId.setText("ID: 12345678");
        studentEmail.setText("choicekunthani@gmail.com");
        studentAttempts.setText("10");

        // Example: Set a default profile image
        profileImage.setImageResource(R.drawable.baseline_person_24);
    }

    /**
     * Open the account settings screen.
     */
    private void openAccountSettings() {
        // You can replace this with actual navigation code to AccountSettingsActivity
        Toast.makeText(getContext(), "Account Settings clicked", Toast.LENGTH_SHORT).show();
    }

    /**
     * Log the student out.
     */
    private void logout() {
        // Perform logout actions, such as clearing session or shared preferences
        Toast.makeText(getContext(), "Logged out successfully!", Toast.LENGTH_SHORT).show();

        // Navigate to LoginActivity or finish current activity
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
