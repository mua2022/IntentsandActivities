package com.example.intentandactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Activity2 for result
        Intent intentActivity2 = new Intent("net.learn2develop.ACTIVITY2");
        startActivityForResult(intentActivity2, REQUEST_CODE);

        // Passing data to Activity2
        Intent intentWithData = new Intent("net.learn2develop.ACTIVITY2");
        Bundle extras = new Bundle();
        extras.putString("Name", "Your name here");
        intentWithData.putExtras(extras);
        startActivityForResult(intentWithData, REQUEST_CODE);

        // Open a web browser
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
        startActivity(browserIntent);

        // Make a call
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+651234567"));
        startActivity(callIntent);

        // Open map location
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
        startActivity(mapIntent);

        // Choose a contact
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK);
        pickContactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.getData() != null) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
