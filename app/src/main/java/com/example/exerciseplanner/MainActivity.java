package com.example.exerciseplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private Button showExercisesButton;
    private TextView exerciseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        categorySpinner = findViewById(R.id.categorySpinner);
        showExercisesButton = findViewById(R.id.showExercisesButton);
        exerciseTextView = findViewById(R.id.exerciseTextView);

        // Setup the spinner with categories from strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        // Set button click listener
        showExercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExercises();
            }
        });
    }

    private void showExercises() {
        // Get selected category
        String selectedCategory = categorySpinner.getSelectedItem().toString();
        String[] exercisesArray = new String[0];

        // Get exercises for the selected category
        switch (selectedCategory) {
            case "Cardio":
                exercisesArray = getResources().getStringArray(R.array.cardio_exercises_array);
                break;
            case "Strength":
                exercisesArray = getResources().getStringArray(R.array.strength_exercises_array);
                break;
            case "Flexibility":
                exercisesArray = getResources().getStringArray(R.array.flexibility_exercises_array);
                break;
        }

        // Build the serial list
        StringBuilder exercises = new StringBuilder();
        for (int i = 0; i < exercisesArray.length; i++) {
            exercises.append(i + 1).append(". ").append(exercisesArray[i]).append("\n");
        }

        // Display exercises in the TextView
        exerciseTextView.setText(exercises.toString().trim());
    }
}
