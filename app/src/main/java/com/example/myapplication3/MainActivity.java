package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static  String EXTRA_MESSAGE ="com.example.myfirstapp.Message";
  // public static String EXTRA_MESSAGE="kkk";
  TextView t1;
  String[] str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.auto);
        str=getResources().getStringArray(R.array.sarray);
        ArrayAdapter<String> adap=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        textView.setAdapter(adap);

        Spinner s=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.arr,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              TextView t=(TextView)findViewById(R.id.tv5);
              t.setText(adapterView.getItemAtPosition(i).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        t1=(TextView)findViewById(R.id.textView);
        CheckBox ch=(CheckBox)findViewById(R.id.ch1);
         ch.setOnClickListener(this);

        Button b=(Button)findViewById(R.id.b2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t1=(TextView)findViewById(R.id.textView);
                ((Button) view).setText(t1.getText());
            }
        });
    }

    public void sendMessage(View view)
    {
        Intent intent=new Intent(this,MessageActivity.class);
        TextView textView=(TextView)findViewById(R.id.textView);
        String message=textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void onClick(View v)
    {
          boolean checked=((CheckBox)v).isChecked();
          CheckBox ch=(CheckBox)v;
          switch (v.getId()) {
              case R.id.ch1:
                  t1.setText(ch.getText());
                  break;
              case R.id.ch2:
                  t1.setText(ch.getText());


          }



    }
}
