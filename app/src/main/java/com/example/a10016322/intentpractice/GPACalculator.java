package com.example.a10016322.intentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GPACalculator extends AppCompatActivity {

    TextView hello;
    EditText math, english, physics;
    Button button1;
    double mathGPA, englishGPA, physicsGPA, totalGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);

        hello = (TextView)(findViewById(R.id.hello_id));
        math = (EditText)(findViewById(R.id.math_id));
        english = (EditText)(findViewById(R.id.english_id));
        physics = (EditText)(findViewById(R.id.physics_id));
        button1 = (Button)(findViewById(R.id.button1_id));

        hello.setText("Hello " + getIntent().getStringExtra("NAME"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (math.getText().equals("A"))
                    mathGPA = 4.0;
                else if (math.getText().equals("B"))
                    mathGPA = 3.0;
                else if (math.getText().equals("C"))
                    mathGPA = 2.0;
                else if (math.getText().equals("D"))
                    mathGPA = 1.0;
                else if (math.getText().equals("F"))
                    mathGPA = 0.0;

                if (english.getText().equals("A"))
                    englishGPA = 4.0;
                else if (english.getText().equals("B"))
                    englishGPA = 3.0;
                else if (english.getText().equals("C"))
                    englishGPA = 2.0;
                else if (english.getText().equals("D"))
                    englishGPA = 1.0;
                else if (english.getText().equals("F"))
                    englishGPA = 0.0;

                if (physics.getText().equals("A"))
                    physicsGPA = 4.0;
                else if (physics.getText().equals("B"))
                    physicsGPA = 3.0;
                else if (physics.getText().equals("C"))
                    physicsGPA = 2.0;
                else if (physics.getText().equals("D"))
                    physicsGPA = 1.0;
                else if (physics.getText().equals("F"))
                    physicsGPA = 0.0;

                totalGPA = (mathGPA+englishGPA+physicsGPA)/3;

                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(MainActivity.CODE, totalGPA);
                setResult(RESULT_OK, sendInfoBack);
                finish();
            }
        });

    }
}
