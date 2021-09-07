package com.example.calc001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView shiki;
    TextView kotae;
    List<String> shisoku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shiki = findViewById(R.id.tv_label);
        kotae = findViewById(R.id.tv_result);
        shisoku = new ArrayList<String>();

        //表示ボタンであるButtonオブジェクトを取得
        Button btZero = findViewById(R.id.btZero);
        //リスナのインスタンスを生成
        HelloListener listener = new HelloListener();
        //表示ボタンにリスナを設定
        btZero.setOnClickListener(listener);

        Button btOne = findViewById(R.id.btOne);//1
        btOne.setOnClickListener(listener);

        Button btTwo = findViewById(R.id.btTwo);//2
        btTwo.setOnClickListener(listener);

        Button btThree = findViewById(R.id.btThree);//3
        btThree.setOnClickListener(listener);

        Button btFour = findViewById(R.id.btFour);//4
        btFour.setOnClickListener(listener);

        Button btFive = findViewById(R.id.btFive);//5
        btFive.setOnClickListener(listener);

        Button btSix = findViewById(R.id.btSix);//6
        btSix.setOnClickListener(listener);

        Button btSeven = findViewById(R.id.btSeven);//7
        btSeven.setOnClickListener(listener);

        Button btEight = findViewById(R.id.btEight);//8
        btEight.setOnClickListener(listener);

        Button btNine = findViewById(R.id.btNine);//9
        btNine.setOnClickListener(listener);

        Button btAddition = findViewById(R.id.btAdd);//+
        btAddition.setOnClickListener(listener);

        Button btSubtraction = findViewById(R.id.btSub);//-
        btSubtraction.setOnClickListener(listener);

        Button btMultiplication = findViewById(R.id.btMulti);//x
        btMultiplication.setOnClickListener(listener);

        Button btDivision = findViewById(R.id.btDiv);//÷
        btDivision.setOnClickListener(listener);

        Button btEqual = findViewById(R.id.btEqual);//=
        btEqual.setOnClickListener(listener);

        //クリアボタンのオブジェクト生成
        Button btAc = findViewById(R.id.btAc);//AC
        //クリアボタンのリスナ
        btAc.setOnClickListener(listener);

    }
    private class HelloListener implements View.OnClickListener {
        int n = 0;

        @Override
        public void onClick(View view) {

            int id = view.getId();

            switch (id) {
                case R.id.btAdd:
                    switch (n) {
                        case 1:
                            shiki.setText(shiki.getText().toString() + "+");
                            shisoku.add("+");
                            n = 0;
                            break;
                    }
                    break;
                case R.id.btSub:
                    switch (n) {
                        case 1:
                            shiki.setText(shiki.getText().toString() + "-");
                            shisoku.add("-");
                            n = 0;
                            break;
                    }
                    break;
                case R.id.btMulti:
                    switch (n) {
                        case 1:
                            shiki.setText(shiki.getText().toString() + "×");
                            shisoku.add("×");
                            n = 0;
                            break;
                    }
                    break;
                case R.id.btDiv:
                    switch (n) {
                        case 1:
                            shiki.setText(shiki.getText().toString() + "÷");
                            shisoku.add("÷");
                            n = 0;
                            break;
                    }
                    break;
                case R.id.btEqual:
                    double num1;
                    double num2 = 0.0;
                    switch (n){
                        case 0:
                            break;
                        default:
                            if (shiki.length() > 1) {
                                n = 0;
                                String TextShiki = shiki.getText().toString();
                                List<String> nums = Arrays.asList(TextShiki.split("[\\+\\-×÷]", -1));
                                for (int i = 0; i < shisoku.size(); i++) {
                                    switch (shisoku.get(i)) {
                                        case "×":
                                            num1 = Double.parseDouble(nums.get(i)) * Double.parseDouble(nums.get(i + 1));
                                            nums.set(i, "0");
                                            nums.set(i + 1, String.valueOf(num1));
                                            System.out.println(num1);
                                            break;
                                        case "÷":
                                            num1 = Double.parseDouble(nums.get(i)) / Double.parseDouble(nums.get(i + 1));
                                            nums.set(i, "0");
                                            nums.set(i + 1, String.valueOf(num1));
                                            break;
                                        case "-":
                                            nums.set(i + 1, String.valueOf(Double.parseDouble(nums.get(i + 1)) * -1));
                                            break;
                                    }
                                }
                                for (String num : nums) {
                                    num2 += Double.parseDouble(num);
                                }
                                System.out.println(num2);
                                kotae.setText(BigDecimal.valueOf(num2).toPlainString());
                            }
                            break;
                    }
                    break;



                case R.id.btAc:
                    shiki.setText("");
                    kotae.setText("");
                    shisoku.clear();
                    n = 0;
                    break;
                case R.id.btZero:
                    shiki.setText(shiki.getText().toString()+"0");
                    n = 1;
                    break;
                case R.id.btOne:
                    shiki.setText(shiki.getText().toString()+"1");
                    n = 1;
                    break;
                case R.id.btTwo:
                    shiki.setText(shiki.getText().toString()+"2");
                    n = 1;
                    break;
                case R.id.btThree:
                    shiki.setText(shiki.getText().toString()+"3");
                    n = 1;
                    break;
                case R.id.btFour:
                    shiki.setText(shiki.getText().toString()+"4");
                    n = 1;
                    break;
                case R.id.btFive:
                    shiki.setText(shiki.getText().toString()+"5");
                    n = 1;
                    break;
                case R.id.btSix:
                    shiki.setText(shiki.getText().toString()+"6");
                    n = 1;
                    break;
                case R.id.btSeven:
                    shiki.setText(shiki.getText().toString()+"7");
                    n = 1;
                    break;
                case R.id.btEight:
                    shiki.setText(shiki.getText().toString()+"8");
                    n = 1;
                    break;
                case R.id.btNine:
                    shiki.setText(shiki.getText().toString()+"9");
                    n = 1;
                    break;
            }
        }
    }
}