package com.example.peleg.ex3;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import static com.example.peleg.ex3.R.id.textViewTheAnswer;


public class MainActivity extends AppCompatActivity {
    Button minus;
    Button plus;
    Button caful;
    Button hiluk;
    EditText edt;
    EditText edt2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        minus = (Button) findViewById(R.id.button2);
        caful = (Button) findViewById(R.id.button3);
        hiluk = (Button) findViewById(R.id.button4);
        plus = (Button) findViewById(R.id.button1);
        edt = (EditText) findViewById(R.id.input1);
        edt2 = (EditText) findViewById(R.id.input2);
        tv = (TextView) findViewById(textViewTheAnswer);

        minus.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public void onClick(View v)
                                     {
                                         int num1 = Integer.parseInt(edt.getText().toString());
                                         int num2 = Integer.parseInt(edt2.getText().toString());
                                         tv.setText(String.valueOf(num1 - num2));
                                     }
                                 }
        );

        plus.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        int num1 = Integer.parseInt(edt.getText().toString());
                                        int num2 = Integer.parseInt(edt2.getText().toString());
                                        tv.setText(String.valueOf(num1 + num2));
                                    }
                                }
        );

        caful.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public void onClick(View v)
                                     {
                                         int num1 = Integer.parseInt(edt.getText().toString());
                                         int num2 = Integer.parseInt(edt2.getText().toString());
                                         tv.setText(String.valueOf(num1 * num2));
                                     }
                                 }
        );

        hiluk.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public void onClick(View v)
                                     {
                                         int num1 = Integer.parseInt(edt.getText().toString());
                                         int num2 = Integer.parseInt(edt2.getText().toString());
                                         tv.setText(String.valueOf(num1 / num2));
                                     }
                                 }
        );


    }




}
