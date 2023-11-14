package com.example.app_demo.Fragments.HomeFragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_demo.Models.Hike;
import com.example.app_demo.R;

public class EditHikeActivity extends AppCompatActivity {
    EditText edtEditName, edtEditLocation, edtEditDateOfTheHike;
    Button btnUpdateHike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hike);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        refView();

        Intent intent = getIntent();
        Hike hike = (Hike) intent.getSerializableExtra("hike");

        edtEditName.setText(hike.getName());
        edtEditLocation.setText(hike.getLocation());
        edtEditDateOfTheHike.setText(hike.getDateOfTheHike());

    }

    private void refView() {
        edtEditName = findViewById(R.id.edtEditName);
        edtEditLocation = findViewById(R.id.edtEditLocation);
        edtEditDateOfTheHike = findViewById(R.id.edtEditDateOfTheHike);
        btnUpdateHike = findViewById(R.id.btnUpdateHike);
    }
}