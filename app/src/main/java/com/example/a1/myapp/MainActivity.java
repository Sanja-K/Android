package com.example.a1.myapp;

import android.support.constraint.ConstraintLayout;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import java.util.logging.LogRecord;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.a1.myapp.R.color.colorAccent;
import static com.example.a1.myapp.R.color.screenBlack;
import static com.example.a1.myapp.R.color.screenGreen;
import static com.example.a1.myapp.R.color.screenWhite;
import static com.example.a1.myapp.R.color.secondary_text;
import static com.example.a1.myapp.R.id.text_v;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    RelativeLayout mRelativeLayout;
    ConstraintLayout mTwolinear;

    TextView hTextView;
    Button startButton ;
    Handler h;
    private EditText editText;

    ArrayMap<String, String> arrayMap = new ArrayMap<>();

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startButton = (Button)findViewById(R.id.button);
        hTextView = (TextView)findViewById(text_v);
        editText = (EditText) findViewById(R.id.editTextActMain);

        mRelativeLayout=(RelativeLayout) findViewById(R.id.activity_main) ;
        mTwolinear=(ConstraintLayout) findViewById(R.id.activity_two) ;

        arrayMap.put("а", "*--");
        arrayMap.put("б", "-***");
        arrayMap.put("в", "*-- ");
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


        h=new Handler() {

            public  void  handleMessage(android.os.Message msg){
                mRelativeLayout.setBackgroundColor(getResources().getColor(msg.what));
               // mTwolinear.setBackgroundColor(getResources().getColor(msg.what));
                Log.d(TAG, "STATUS_NONE! "+ msg.what);
            }
        };

        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {

                    for (int j=0; j<editText.getText().toString().length();j++){

                    for(int g=0; g<arrayMap.size();g++) {
                        if(String.valueOf(editText.getText().toString().charAt(j)).equals(arrayMap.keyAt(g))){

                            for( int i=0; i<arrayMap.valueAt(g).length();i++){

                                switch (arrayMap.valueAt(g).charAt(i)) {
                                    case '-':{
                                        h.sendEmptyMessage(screenWhite);
                                        text_output(1000);
                                        h.sendEmptyMessage(screenBlack);
                                        text_output(500);
                                        break;
                                    }
                                    case '*':{
                                        h.sendEmptyMessage(screenWhite);
                                        text_output(2000);
                                        h.sendEmptyMessage(screenBlack);
                                        text_output(500);
                                        break;
                                    }

                                    case '_':{
                                        text_output(4000);
                                        break;
                                    }

                                    default:{
                                        h.sendEmptyMessage(secondary_text);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                    }

                });
                t.start();
            }
        });
    }

    public void text_output(int sec){
        try {

            TimeUnit.MILLISECONDS.sleep(sec);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
