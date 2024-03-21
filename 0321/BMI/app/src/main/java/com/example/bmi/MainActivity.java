package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txvShow=(TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);

        Button btnCount=(Button) findViewById(R.id.btnCount);
        Button btnClear=(Button) findViewById(R.id.btnClear);
        btnCount.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edtHeight =(EditText) findViewById(R.id.edtHeight);
        EditText edtWeight =(EditText) findViewById(R.id.edtWeight);
        TextView txvShow=(TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);

        if(v.getId() == R.id.btnCount){
            double height=Double.parseDouble((edtHeight.getText().toString()));
            double weight=Double.parseDouble((edtWeight.getText().toString()));
            double bmi = weight/Math.pow(height/100.0,2);
            if(bmi>=24)
                txvShow.setTextColor(Color.RED);
            else if(bmi<18.5)
                txvShow.setTextColor(Color.BLUE);
            else
                txvShow.setTextColor(Color.GREEN);

            txvShow.setText(String.format("%.2f",bmi));
        }
        else{
            edtWeight.setText("0");
            edtHeight.setText("0");
            txvShow.setText("");
        }
    }
}