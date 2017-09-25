package com.example.wendaqin.fourthgradeflashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button button;
    EditText useredit;
    EditText passedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button)findViewById(R.id.button);
        useredit   = (EditText)findViewById(R.id.useredit);
        passedit   = (EditText)findViewById(R.id.passedit);
        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(useredit.getText().toString().equals("User") && passedit.getText().toString().equals("pass")){
                            String username = "User";
                            String pass = "pass";
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("MyUser", username);
                            i.putExtra("MyPass", pass);
                            startActivity(i);

                        }
                    }
                });
    }
}
