package com.example.myapplication3;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
       Intent intent=getIntent();
         TextView textView=(TextView)findViewById(R.id.textView4);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
         textView.setText(message);

        Context c=getApplicationContext();
        Toast t=Toast.makeText(c,"im want",Toast.LENGTH_SHORT);
        t.show();
    }

}
