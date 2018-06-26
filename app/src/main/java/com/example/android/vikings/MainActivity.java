package com.example.android.vikings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // "Go to Second Activity" button click
    public void startQuiz(View view) {

        // get the text to pass
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String textToPass = editText.getText().toString();

        // start the SecondActivity
        Intent intent = new Intent(this, Welcome.class);
        intent.putExtra(Intent.EXTRA_TEXT, textToPass);
        startActivity(intent);
    }
}