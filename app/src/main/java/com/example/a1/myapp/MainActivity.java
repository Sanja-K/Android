package com.example.a1.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    TextView hTextView;
    Button startButton ;
    Handler h;

    String qwe="0";
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


    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.button);
        hTextView = (TextView)findViewById(text_v);

        mRelativeLayout=(RelativeLayout) findViewById(R.id.activity_main) ;


        h=new Handler() {

            public  void  handleMessage(android.os.Message msg){

                mRelativeLayout.setBackgroundColor(getResources().getColor(msg.what));
                Log.d(TAG, "STATUS_NONE! "+ msg.what);


            }
        };

        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for( int i=0; i<codeMorse[10].length();i++){

                            switch (codeMorse[10].charAt(i)) {
                                case '1':{
                                    h.sendEmptyMessage(screenWhite);
                                    text_output(2);
                                    h.sendEmptyMessage(screenBlack);
                                    text_output(1);
                                    break;
                                }
                                case '0':{
                                    h.sendEmptyMessage(screenWhite);
                                    text_output(4);
                                    h.sendEmptyMessage(screenBlack);
                                    text_output(1);
                                    break;
                                }

                                default:{
                                    h.sendEmptyMessage(secondary_text);
                                    break;
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

            TimeUnit.SECONDS.sleep(sec);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       //
    }
}
