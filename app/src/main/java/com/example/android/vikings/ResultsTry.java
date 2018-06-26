package com.example.android.vikings;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultsTry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_try);
    }

    /**
     * Creates method to open Youtube and load Viking videos
     */

    public void openYoutube(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6QVp-d-3_Us"));
        startActivity(browserIntent);
    }

}
