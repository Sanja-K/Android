package com.example.a1.myapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import android.util.ArrayMap;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.util.Arrays.*;

import java.lang.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import android.os.Handler;

import static java.util.Arrays.binarySearch;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    RelativeLayout mRelativeLayout;
    ConstraintLayout mTwolinear;

    TextView hTextView;
    Button startButton ;
    Handler handler;
    private EditText editText;
    String text_input;

    Fregment_flash fregment_flash;

  final   ArrayMap<String, String> arrayMap = new ArrayMap<>();


    private static final String TAG = "myLogs";
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startButton = (Button)findViewById(R.id.button);
        hTextView = (TextView)findViewById(R.id.text_v);
        editText = (EditText) findViewById(R.id.editTextActMain);

        mRelativeLayout=(RelativeLayout) findViewById(R.id.activity_main) ;
        mTwolinear=(ConstraintLayout) findViewById(R.id.activity_two) ;

        final Intent intent = new Intent(MainActivity.this,ActivityTwo.class);

        fregment_flash=new Fregment_flash();

        arrayMap.put("а", "*--");
        arrayMap.put("б", "-***");
        arrayMap.put("в", "*--*");
        arrayMap.put("г", "--*");
        arrayMap.put("д", "-** ");
        arrayMap.put("е", "*");
        arrayMap.put("ё", "*");
        arrayMap.put("ж", "***-");
        arrayMap.put("з", "--**");
        arrayMap.put("и", "**");
        arrayMap.put("й", "*---");
        arrayMap.put("к", "-*-");
        arrayMap.put("л", "*-**");
        arrayMap.put("м", "--");
        arrayMap.put("н", "-*");
        arrayMap.put("о", "---");
        arrayMap.put("п", "*--*");
        arrayMap.put("р", "*-*");
        arrayMap.put("с", "***");
        arrayMap.put("т", "-");
        arrayMap.put("у", "**-");
        arrayMap.put("ф", "**-*");
        arrayMap.put("х", "****");
        arrayMap.put("ц", "-*-*");
        arrayMap.put("ч", "---*");
        arrayMap.put("ш", "----");
        arrayMap.put("щ", "--*-");
        arrayMap.put("ъ", "--*--");
        arrayMap.put("ы", "-*--");
        arrayMap.put("ь", "-**-");
        arrayMap.put("э", "**-**");
        arrayMap.put("ю", "**--");
        arrayMap.put("я", "*-*-");

        arrayMap.put("0", "-----");
        arrayMap.put("1", "*----");
        arrayMap.put("2", "**---");
        arrayMap.put("3", "***--");
        arrayMap.put("4", "****-");
        arrayMap.put("5", "*****");
        arrayMap.put("6", "-****");
        arrayMap.put("7", "--***");
        arrayMap.put("8", "---**");
        arrayMap.put("9", "----*");
        arrayMap.put(" ", "_");

        handler=new Handler() {

            public  void  handleMessage(android.os.Message msg){
                mRelativeLayout.setBackgroundColor(getResources().getColor(msg.what));
                Log.d(TAG, "STATUS_NONE! "+ msg.what);
            }
        };

        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        text_input=editText.getText().toString();

                        String inputText="";
                        for(int i=0; i<text_input.length(); i++){

                            String key=String.valueOf(text_input.charAt(i));
                            if(arrayMap.containsKey(key)){
                                inputText=inputText.concat(arrayMap.get(key)+"_");
                                Log.d(TAG, "arrayMap.get! "+ arrayMap.get(key));
                            }
                        }

                        intent.putExtra("array_key",inputText);
                        startActivity(intent);
                    }
                });
                t.start();
            }
        });
    }

}
