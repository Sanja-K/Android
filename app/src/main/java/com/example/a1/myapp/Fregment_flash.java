package com.example.a1.myapp;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by 1 on 21.03.2017.
 */

public class Fregment_flash extends Fragment {

    final String TAG = "myLogs";

    LinearLayout mLinearLayout;
    FrameLayout framer;

   // String codeMorse[];
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

   // mLinearLayout=(LinearLayout)findViewById(R.id.fragment1) ;
    Bundle bundle = getArguments();
    View view = inflater.inflate(R.layout.output_flash, container,false);
    view.setBackgroundColor(Color.GREEN);
    framer = (FrameLayout) view.findViewById(R.id.fre);
   // setImageViewBackground();
    return view ;



   // int lengthString = bundle.getInt("length",0);

    //String myString = bundle.getString("key","1");
    /*
    Context context = getActivity().getApplicationContext();
    FrameLayout layout = new FrameLayout(context);
    layout.setBackgroundColor(Color.BLUE);
    TextView text = new TextView(context);
    text.setText("Это область фрагмента");
    layout.addView(text);

    //View view=inflater.inflate(R.lz)
    return layout;*/
}



public void onCreate(){



}

    public void setImageViewBackground() {

        //view.setBackgroundColor(Color.GREEN);

            framer.setBackgroundColor(Color.RED);
       // return view;
     //   return ;
    }


public void isOutput(){

   // getView().setBackgroundColor(Color.GREEN);
    //fra.setBackgroundColor(Color.WHITE);


    //layout.getRootView().setBackgroundColor(Color.WHITE);
    //.getView().setBackgroundColor(Color.WHITE);

   /* for(int i=0;i<lengthString;i++){

        String myString = bundle.getString("key"+i,"1");
        //layout.setBackgroundColor(Color.BLUE);

       // codeMorse[i]=bundle.getString("key"+i,"1");
      //  Log.d(TAG, "Fragment ! " +codeMorse[i] + "код" +i);
    }
    */
    //layout.getView().setBackgroundColor(Color.WHITE);

}
/*

public  void isOutputLightMorse(){


    for(int i = 0; i<myString.length(); i++){

    switch (myString.charAt(i)){

        case '-':{

            break;
        }
        case '*':{

            break;
        }

        case '_':{

            break;
        }

    }

    }

}


    public void Light(int color){

     //   .setBackgroundColor(getResources().getColor(color));

    }


    public void text_output(int sec){
        try {

            TimeUnit.MILLISECONDS.sleep(sec);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

}
