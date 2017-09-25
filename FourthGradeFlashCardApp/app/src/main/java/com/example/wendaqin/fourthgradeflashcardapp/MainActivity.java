package com.example.wendaqin.fourthgradeflashcardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "dota";
    private TextView txtDivend;
    private TextView txtDivsor;
    private TextView txtDivOpr;
    private TextView textView2;
    private  TextView correct;

    private Button btnGenPbms;
    private Button btnSub;
    private EditText edtAns;
    private int[] endAry = new int[10];
    private int[] sorAry = new int[10];
    private int[] ansAry = new int[10];
    private int[] subAry = new int[10];
    private int currentProblemIndex = 0;
    private int correctCount =0;
    private boolean isGen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDivend = (TextView) findViewById(R.id.txtDivend);
        txtDivsor = (TextView) findViewById(R.id.txtDivsor);
        txtDivOpr = (TextView) findViewById(R.id.txtDivOpr);
        btnGenPbms = (Button) findViewById(R.id.btnGenPbms);
        edtAns = (EditText) findViewById(R.id.edtAns);
        btnSub = (Button) findViewById(R.id.btnSub);
        textView2 = (TextView) findViewById(R.id.textView2);
        correct = (TextView) findViewById(R.id.correct);
        txtDivend.setText("");
        txtDivsor.setText("");
        txtDivOpr.setText("");


        Toast.makeText(getApplicationContext(),"Welcome User", Toast.LENGTH_LONG).show();

        btnGenPbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<10;i++) {
                    int rand1 = 1 + (int) (Math.random() * 100);
                    int rand2 = 1 + (int) (Math.random() * 100);
                    while (rand1 * rand2 >= 100)
                    {
                        Log.i(MyFlag,"<100");
                        rand1 = 1 + (int) (Math.random() * 100);
                        rand2 = 1 + (int) (Math.random() * 100);
                    }
                    endAry[i] = rand1 * rand2;
                    sorAry[i] = rand1;
                    ansAry[i] = rand2;
                }
                isGen=true;
                currentProblemIndex=0;
                correctCount =0;
                txtDivend.setText(Integer.toString(endAry[0]));
                txtDivsor.setText(Integer.toString(sorAry[0]));

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isGen==false)
                {
                 //   Toast.makeText(MainActivity.this,"The problem set is not generate yet, please generate!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(currentProblemIndex<10)
                    {
                        String ansString = edtAns.getText().toString();
                        int ansInt = Integer.parseInt(ansString);
                        if (ansInt == ansAry[currentProblemIndex]) {
                            Log.i(MyFlag,"correct!");
                            correctCount++;


                        }
                        currentProblemIndex++;
                        edtAns.setText("");
                        if(currentProblemIndex<10)
                        {
                            txtDivend.setText(Integer.toString(endAry[currentProblemIndex]));
                            txtDivsor.setText(Integer.toString(sorAry[currentProblemIndex]));


                        }
                        else
                        {
                            txtDivend.setText("");
                            txtDivsor.setText("");
                            Toast.makeText(MainActivity.this,"Score: "+Integer.toString(correctCount),Toast.LENGTH_LONG).show();

                        }

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"The problem set is ended, please regenerate!",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("total1", txtDivend.getText().toString());
        outState.putString("total2", txtDivsor.getText().toString());
        outState.putString("total3", txtDivOpr.getText().toString());
        outState.putInt("total4",currentProblemIndex);
        outState.putInt("total5",correctCount);
        outState.putBoolean("genthing",isGen);
        outState.putIntArray("startarray",sorAry);
        outState.putIntArray("endarray",endAry);
        outState.putIntArray("ansarray",ansAry);
        super.onSaveInstanceState(outState);  //QUESTION: why do we do this last?

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {   //QUESTIONS: Will this always be called, if not, why not?
        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
        String savedTotal1;
        String savedTotal2;
        String savedTotal3;
        int savedTotal4;
        int savedTotal5;
        savedTotal1 = savedInstanceState.getString("total1");
        savedTotal2 = savedInstanceState.getString("total2");
        savedTotal3 = savedInstanceState.getString("total3");
        currentProblemIndex = savedInstanceState.getInt("total4");
        correctCount = savedInstanceState.getInt("total5");
        txtDivend.setText(savedTotal1);
        txtDivsor.setText(savedTotal2);
        txtDivOpr.setText(savedTotal3);
        isGen = savedInstanceState.getBoolean("genthing");
        ansAry = savedInstanceState.getIntArray("ansarray");
        sorAry = savedInstanceState.getIntArray("startarray");
        endAry = savedInstanceState.getIntArray("endarray");
//        }


    }


}
