package com.example.app_demo.Fragments.HomeFragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_demo.Models.Hike;
import com.example.app_demo.R;
import com.example.app_demo.SqlHelper.SqlHelper;

public class EditHikeActivity extends AppCompatActivity {
    EditText edtEditName, edtEditLocation, edtEditDateOfTheHike;
    Button btnUpdateHike;

    SqlHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hike);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        refView();

        sqlHelper = new SqlHelper(EditHikeActivity.this);

        Intent intent = getIntent();
        Hike hike = (Hike) intent.getSerializableExtra("hike");

        edtEditName.setText(hike.getName());
        edtEditLocation.setText(hike.getLocation());
        edtEditDateOfTheHike.setText(hike.getDateOfTheHike());

        btnUpdateHike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtEditName.getText().toString().trim();

                Hike hike1 = new Hike(hike.getId(), name, "1", "1", true, 1, "1", "1");
                sqlHelper.updateHike(hike1);
            }
        });

    }

    private void refView() {
        edtEditName = findViewById(R.id.edtEditName);
        edtEditLocation = findViewById(R.id.edtEditLocation);
        edtEditDateOfTheHike = findViewById(R.id.edtEditDateOfTheHike);
        btnUpdateHike = findViewById(R.id.btnUpdateHike);
    }
}