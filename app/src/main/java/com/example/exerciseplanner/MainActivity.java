package com.example.exerciseplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private Button showExercisesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.categorySpinner);
        showExercisesButton = findViewById(R.id.showExercisesButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        showExercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExercises();
            }
        });
    }

    private void showExercises() {
        String selectedCategory = categorySpinner.getSelectedItem().toString();
        String[] exercisesArray = new String[0];

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

        StringBuilder exercises = new StringBuilder();
        for (int i = 0; i < exercisesArray.length; i++) {
            exercises.append(i + 1).append(". ").append(exercisesArray[i]).append("\n");
        }


        Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);

        intent.putExtra("exercise_list", exercises.toString().trim());
        startActivity(intent);
    }
}
