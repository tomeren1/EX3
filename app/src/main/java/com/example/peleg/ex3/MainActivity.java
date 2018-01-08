package com.example.peleg.ex3;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import static com.example.peleg.ex3.R.id.textViewTheAnswer;


public class MainActivity extends AppCompatActivity {
    Button minus;
    Button clean;
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
        clean = (Button) findViewById(R.id.buttonc);

        clean.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public void onClick(View v)
                                     {
                                         edt.setText(null);
                                         edt2.setText(null);
                                         tv.setText(null);
                                     }
                                 }
        );
        minus.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public void onClick(View v)
                                     {
                                         if(edt.getText().length()==0||edt2.getText()==null)
                                             return;
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
                                        if(edt.getText().length()==0||edt2.getText()==null)
                                            return;
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
                                         if(edt.getText().length()==0||edt2.getText()==null)
                                             return;
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
                                         if(edt.getText().length()==0||edt2.getText()==null)
                                             return;
                                         int num1 = Integer.parseInt(edt.getText().toString());
                                         int num2 = Integer.parseInt(edt2.getText().toString());
                                         tv.setText(String.valueOf(num1 / num2));
                                     }
                                 }
        );
        ((EditText) findViewById(R.id.input1)).addTextChangedListener(tw);
        ((EditText) findViewById(R.id.input2)).addTextChangedListener(tw);
    }
    private TextWatcher tw = new TextWatcher(){
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (edt.getText().length()==0||edt2.getText().length()==0) {
                minus.setEnabled(false);
                plus.setEnabled(false);
                hiluk.setEnabled(false);
                caful.setEnabled(false);
            }
            else if(edt2.getText().toString().equals("0")) {
                hiluk.setEnabled(false);
                minus.setEnabled(true);
                plus.setEnabled(true);

                caful.setEnabled(true);
            }else{
                minus.setEnabled(true);
                plus.setEnabled(true);
                hiluk.setEnabled(true);
                caful.setEnabled(true);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("Answer", tv.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null) {
            tv.setText((String) savedInstanceState.getString("Answer"));

        }
    }




}