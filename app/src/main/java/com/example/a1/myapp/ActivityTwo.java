package com.example.a1.myapp;

import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import static com.example.a1.myapp.R.color.screenBlack;
import static com.example.a1.myapp.R.color.screenWhite;
import static com.example.a1.myapp.R.id.text_v;

public class ActivityTwo extends AppCompatActivity {

    private static final String TAG = "myLogs";
    ConstraintLayout constraintLayout;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView pTextView;

        constraintLayout=(ConstraintLayout) findViewById(R.id.activity_two) ;

      //  String array_undex=getIntent().getExtras().getString("array_key");

        pTextView = (TextView)findViewById(R.id.text_two);

        //pTextView.setText(array_undex);


        handler=new Handler() {

/*            public  void  handleMessage(android.os.Message msg){
                constraintLayout.setBackgroundColor(getResources().getColor(msg.what));

                isFlashingScreen();
            }*/

            public void handleMessage(android.os.Message color){

             //   try {
                    constraintLayout.setBackgroundColor(getResources().getColor(color.what));
                  //  TimeUnit.MILLISECONDS.sleep(color.arg1);

               // } catch (InterruptedException e) {
               //     e.printStackTrace();
               // }

            }
        };


        Thread thread  = new Thread(new Runnable() {


            @Override
            public void run() {
                String array_undex=getIntent().getExtras().getString("array_key");

                Message msg;

    for( int i=0; i<array_undex.length();i++){

            switch (array_undex.charAt(i)) {
                case '-':{
                    Log.d(TAG, "короткий");
                    handler.sendEmptyMessage(screenWhite);
                    text_output(1000);
                    handler.sendEmptyMessage(screenBlack);
                    text_output(500);

                  //  msg=handler.obtainMessage(screenWhite,1000);
                  //  handler.sendMessage(msg);
                  //  msg=handler.obtainMessage(screenBlack,500);
                  //  handler.sendMessage(msg);

                 //   isFlashingScreen(1000,screenWhite);
                   // isFlashingScreen(500,screenBlack);

                    break;
                }
                case '*':{

                    Log.d(TAG, "длиный");
                    handler.sendEmptyMessage(screenWhite);
                    text_output(2000);
                    handler.sendEmptyMessage(screenBlack);
                    text_output(500);
                  //  msg=handler.obtainMessage(screenWhite,2000);
                    //handler.sendMessage(msg);
                  //  msg=handler.obtainMessage(screenBlack,500);
                  //  handler.sendMessage(msg);
                   // isFlashingScreen(2000,screenWhite);
                   // isFlashingScreen(500,screenBlack);
                    break;
                }

                case '_':{

                    text_output(3000);
                    break;

                }

                default:{
                    Log.d(TAG, "Я вообще без понятия что произошло.");
                    break;
                }
            }
        }

            }
        });
        thread.start();





    /*    for( int i=0; i<array_undex.length();i++){

            switch (array_undex.charAt(i)) {
                case '-':{
                    isFlashingScreen(1000,screenWhite);
                    isFlashingScreen(500,screenBlack);

                    break;
                }
                case '*':{
                    isFlashingScreen(2000,screenWhite);
                    isFlashingScreen(500,screenBlack);
                    break;
                }

                case '_':{

                    try {
                        TimeUnit.MILLISECONDS.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                }

                default:{
                    Log.d(TAG, "Я вообще без понятия что произошло.");
                    break;
                }
            }
        }*/



    }

    public void text_output(int sec){
        try {

            TimeUnit.MILLISECONDS.sleep(sec);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

/*    public void isFlashingScreen(int timeFlashing,int color){

        try {
            constraintLayout.setBackgroundColor(getResources().getColor(color));
            TimeUnit.MILLISECONDS.sleep(timeFlashing);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/




}
