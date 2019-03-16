package com.mambobryan.day3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mainActivitySpinner = findViewById(R.id.main_activity_spinner);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainActivitySpinner.setAdapter(myAdapter);
        mainActivitySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selection = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        selection = null;

    }

    public void showUserSelection(View view) {

        if (selection.isEmpty()) {

            Toast.makeText(this, "Please select an item", Toast.LENGTH_SHORT).show();

        } else {
            TextView userSelection = findViewById(R.id.user_choice_text_view);
            userSelection.setText(selection);
        }

    }
}
