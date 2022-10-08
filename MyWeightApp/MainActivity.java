package com.zybooks.MyWeight;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
/*
 *===================================================================================================
 * The MainActivity is the home screen for the application.
 *
 * BEFORE CHANGES:
 * The main activity had a login feature and sign up feature which were
 * working perfectly. The button to enter was labelled "sign in" and there was no title text.
 *
 * AFTER CHANGES:
 * The login feature and sign up feature were removed based on design decisions as the application
 * was intended to be a local and offline used app. A title was added to the home screen, and the
 * sign in button is now labelled "start tracking". Changes are reflected in the activity_main.xml
 * file.
 *
 *===================================================================================================
 */

public class MainActivity extends AppCompatActivity {
    Button btEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnter = findViewById(R.id.bt_enter);

        //On click listener for submit button
        btEnter.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HomeActivity.class)));
    }
}