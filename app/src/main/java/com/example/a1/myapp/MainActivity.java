package com.example.a1.myapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

/// что каждый сделал ( что сделал я и что сделал антоха) и почему у нас не получилось

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
               // mTwolinear.setBackgroundColor(getResources().getColor(msg.what));
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

                        // получаем экземпляр FragmentTransaction
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager
                                .beginTransaction();

                        // добавляем фрагмент
                        Fregment_flash fregment_flash = new Fregment_flash();
                        fragmentTransaction.add(R.id.frame, fregment_flash);
                        fragmentTransaction.commit();

                        Bundle bundle = new Bundle();

                       // String qwe=arrayMap.valueAt(9);
                       // bundle.putString("key", qwe);
                       // fregment_flash.setArguments(bundle);


                       // bundle.putBoolean("key", arrayMap.containsKey(0));

                   //   Log.d(TAG, "containsKey! "+ arrayMap.containsKey("а"));

                      //  Log.d(TAG, "arrayMap.get! "+ arrayMap.get(String.valueOf(text_input.charAt(0))));
                      //  Log.d(TAG, "text_input.charAt(0)! "+ text_input);

                        /*if(arrayMap.containsKey(String.valueOf(text_input.charAt(0)))){

                            Log.d(TAG, "arrayMap.get Fragments! "+ arrayMap.get(String.valueOf(text_input.charAt(0))));
                            Log.d(TAG, "text_input.charAt(0)! "+ text_input);
                        }*/

                   //     bundle.putString("key", arrayMap.valueAt(1));
                     //   fregment_flash.setArguments(bundle);

                    //    Log.d(TAG, "text_input.charAt(0)! "+ text_input);

                        /*bundle.putInt("length", text_input.length());
                        fregment_flash.setArguments(bundle);

                        for(int i=0; i<text_input.length(); i++){

                            String key=String.valueOf(text_input.charAt(i));
                            if(arrayMap.containsKey(key)){


                                bundle.putString("key"+i, arrayMap.get(key));
                                fregment_flash.setArguments(bundle);
                                // Log.d(TAG, "text_input.charAt(i)! "+ text_input.charAt(i));
                                Log.d(TAG, "arrayMap.get! "+ arrayMap.get(key));
                            }

                        }*/

                        for(int i=0; i<text_input.length(); i++){

                            String key=String.valueOf(text_input.charAt(i));
                            if(arrayMap.containsKey(key)){


                                bundle.putString("key"+i, arrayMap.get(key));
                                fregment_flash.setArguments(bundle);
                                // Log.d(TAG, "text_input.charAt(i)! "+ text_input.charAt(i));
                                Log.d(TAG, "arrayMap.get! "+ arrayMap.get(key));
                            }

                        }




                      /*  // получаем экземпляр FragmentTransaction
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager
                                .beginTransaction();

                        // добавляем фрагмент
                        Fregment_flash fregment_flash = new Fregment_flash();
                        fragmentTransaction.add(R.id.frame, fregment_flash);
                        fragmentTransaction.commit();*/



                        /*
                        String qwe="qwerty ";
                        Bundle bundle = new Bundle();
                        bundle.putString("key", qwe);
                        fregment_flash.setArguments(bundle);

                        */

                     //   fragmentTransaction=getFragmentManager().beginTransaction();


                    //    fragmentTransaction.add(R.id.frame,fregment_flash);
                     //   fragmentTransaction.commit();


               /*     for(int i=0; i<text_input.length(); i++){

                        if(arrayMap.containsKey(text_input.charAt(i))){

                        }
                    }


                        Set<Map.Entry<String, String>> set=hashmap.entrySet();
                        Log.d(TAG, "SET! "+ set);

                        if(arrayMap.containsValue("--")){

                            Log.d(TAG, "HACH! value a "+ arrayMap.get("а"));
                        }
                        */


                       // hashmap.containsValue("а");
                       // Intent intent = new Intent(MainActivity.this,ActivityTwo.class);
                       // intent.putExtra("array_key",index);
                       // Arrays.sort(set);

                      //  int index= Arrays.binarySearch(set,"а");

                       // for(int i=0;i<codeMorse.length;i++) {
                         //   Log.d(TAG, "codeMorse! " + index);
                      //  }

                    //hTextView.setText(index);

                       // startActivity(intent);
                  /*  for (int j=0; j<text_input.length();j++){


                    for(int g=0; g<arrayMap.size();g++) {

                        if(String.valueOf(text_input.charAt(j)).equals(arrayMap.keyAt(g))){

                            for( int i=0; i<arrayMap.valueAt(g).length();i++){

                                switch (arrayMap.valueAt(g).charAt(i)) {
                                    case '-':{
                                        handler.sendEmptyMessage(screenWhite);
                                        text_output(1000);
                                        handler.sendEmptyMessage(screenBlack);
                                        text_output(500);
                                        break;
                                    }
                                    case '*':{
                                        handler.sendEmptyMessage(screenWhite);
                                        text_output(2000);
                                        handler.sendEmptyMessage(screenBlack);
                                        text_output(500);
                                        break;
                                    }

                                    case '_':{
                                        text_output(4000);
                                        break;
                                    }

                                    default:{
                                        handler.sendEmptyMessage(secondary_text);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }*/
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
