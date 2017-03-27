package com.example.a1.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.a1.myapp.R.id.text_v;

public class ActivityTwo extends AppCompatActivity {



    String[] codeMorse = new String[]{ "01", "0111", "100", "110",
            "100", "0", "0001", "1100",
            "00", "0111", "010", "0100",
            "11", "10", "111", "0110",
            "010", "000", "1", "001",
            "0010", "0000", "1010",
            "0001", "1111", "1101",
            "1011", "1001", "00100",
            "0011", "0101", "01111",
            "00111", "00011", "00001",
            "00000", "10000", "11000",
            "11100", "11110", "11111" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView pTextView;
        String array_undex=getIntent().getExtras().getString("array_key");

        pTextView = (TextView)findViewById(R.id.text_two);

        pTextView.setText(array_undex);

    }


}
