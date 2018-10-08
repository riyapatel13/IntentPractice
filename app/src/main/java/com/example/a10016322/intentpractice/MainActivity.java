package com.example.a10016322.intentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText enterName;
    TextView gpa;
    Button button;
    static final int GPA_CODE = 123;
    static final String CODE = "CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = (EditText)(findViewById(R.id.enterName_id));
        gpa = (TextView)(findViewById(R.id.gpa_id));
        button = (Button)(findViewById(R.id.button_id));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToOpenApp = new Intent(MainActivity.this, GPACalculator.class);
                Log.d("nam", enterName.getText().toString());
                intentToOpenApp.putExtra("NAME", enterName.getText());
                startActivityForResult(intentToOpenApp, GPA_CODE);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GPA_CODE && resultCode == RESULT_OK) //if the app sending info is NUMBER_CODE, then do something
            gpa.setText("GPA: "+ data.getStringExtra(CODE));
    }

}
