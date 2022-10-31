package com.example.chimptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0_0,btn0_1,btn0_2,btn1_0,btn1_1,btn1_2,btn2_0,btn2_1,btn2_2,btnStart;
    Button[][] buttons=new Button[3][3];
    GridLayout gl;
    int btnOrder=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        gl=findViewById(R.id.gl);
        btn0_0=findViewById(R.id.btn0_0);
        btn0_0.setOnClickListener(this);
        btn0_1=findViewById(R.id.btn0_1);
        btn0_1.setOnClickListener(this);
        btn0_2=findViewById(R.id.btn0_2);
        btn0_2.setOnClickListener(this);
        btn1_0=findViewById(R.id.btn1_0);
        btn1_0.setOnClickListener(this);
        btn1_1=findViewById(R.id.btn1_1);
        btn1_1.setOnClickListener(this);
        btn1_2=findViewById(R.id.btn1_2);
        btn1_2.setOnClickListener(this);
        btn2_0=findViewById(R.id.btn2_0);
        btn2_0.setOnClickListener(this);
        btn2_1=findViewById(R.id.btn2_1);
        btn2_1.setOnClickListener(this);
        btn2_2=findViewById(R.id.btn2_2);
        btn2_2.setOnClickListener(this);

        buttons[0][0]=btn0_0;
        buttons[0][1]=btn0_1;
        buttons[0][2]=btn0_2;
        buttons[1][0]=btn1_0;
        buttons[1][1]=btn1_1;
        buttons[1][2]=btn1_2;
        buttons[2][0]=btn2_0;
        buttons[2][1]=btn2_1;
        buttons[2][2]=btn2_2;

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        if (buttonText.equalsIgnoreCase("start game")){
            gl.setVisibility(View.VISIBLE);
            createBoard();
            btnStart.setVisibility(View.INVISIBLE);
        }
        if (buttonText.equals(btnOrder+"")){
            b.setVisibility(View.INVISIBLE);
            btnOrder++;
        }

    }


    public void createBoard(){
        int visibleButtons=0;
        int index=1;

        while(visibleButtons<=2){
            Random random = new Random();
            int max=3;
            int rnd1=random.nextInt(max);
            int rnd2=random.nextInt(max);
            if (buttons[rnd1][rnd2].getVisibility() != View.VISIBLE) {
                buttons[rnd1][rnd2].setVisibility(View.VISIBLE);
                buttons[rnd1][rnd2].setText(index+"");
                visibleButtons++;
                index++;
            }
        }
    }

}