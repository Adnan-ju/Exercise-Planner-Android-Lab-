package com.example.exerciseplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    private TextView exerciseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        exerciseTextView = findViewById(R.id.exerciseTextView);

        // Get the exercise data from the intent
        Intent intent = getIntent();
        String exercises = intent.getStringExtra("exercise_list");

        // Set the exercise data to the TextView
        exerciseTextView.setText(exercises);
    }
}
