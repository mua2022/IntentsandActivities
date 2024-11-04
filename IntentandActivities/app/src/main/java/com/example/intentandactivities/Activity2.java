package com.example.intentandactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        // Retrieve data passed from MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String defaultName = extras.getString("Name");
            EditText txt_username = findViewById(R.id.txt_username);
            txt_username.setHint(defaultName);
        }

        // Return data to MainActivity
        EditText txt_username = findViewById(R.id.txt_username);
        Intent data = new Intent();
        data.setData(Uri.parse(txt_username.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
    }
}
