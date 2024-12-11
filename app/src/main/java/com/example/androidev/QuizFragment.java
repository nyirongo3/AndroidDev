package com.example.androidev;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        totalQuestionsTextView = view.findViewById(R.id.total_question);
        questionTextView = view.findViewById(R.id.question);
        ansA = view.findViewById(R.id.ans_A);
        ansB = view.findViewById(R.id.ans_B);
        ansC = view.findViewById(R.id.ans_C);
        ansD = view.findViewById(R.id.ans_D);
        submitBtn = view.findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions: " + totalQuestion);

        loadNewQuestion();

        return view;
    }

    @Override
    public void onClick(View view) {
        // Reset button colors
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        if (view.getId() == R.id.submit_btn) {
            // Ensure a valid answer is selected
            if (!selectedAnswer.isEmpty()) {
                // Check if the answer is correct
                if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;

                // Load next question or finish quiz
                if (currentQuestionIndex < totalQuestion) {
                    loadNewQuestion();
                } else {
                    finishQuiz();
                }
                selectedAnswer = ""; // Reset selected answer
            } else {
                // Show a message to prompt user to select an answer
                new AlertDialog.Builder(getActivity())
                        .setTitle("No Answer Selected")
                        .setMessage("Please select an answer before submitting.")
                        .setPositiveButton("OK", null)
                        .show();
            }
        } else {
            // Handle choice selection
            Button clickedButton = (Button) view;
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {
        // Display question and options
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = score > totalQuestion * 0.60 ? "Passed" : "Failed";

        new AlertDialog.Builder(getActivity())
                .setTitle(passStatus)
                .setMessage("Score: " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}
