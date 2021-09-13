package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity  {
    //声明所有按钮和一个文本编辑器
    RadioGroup radioGroup;
    RadioButton radio_B,radio_D,radio_O,radio_H;
    Button btn_sin,btn_cos,btn_tan,btn_C,btn_del,btn_sq,btn_B,btn_O,btn_D,btn_H,
            btn_rs,btn_lb,btn_rb,btn_ftl,btn_div,btn_pf,btn_7,btn_8,btn_9,btn_mul,btn_ef,
            btn_4,btn_5,btn_6,btn_min,btn_log,btn_1,btn_2,btn_3,btn_add,btn_ln,
            btn_pm,btn_0,btn_pt,btn_eq;
    private EditText edit_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndListener();
    }
    //定义函数initViewAndListener()，用于与用户界面程序中的组件建立关联，并分别注册监听接口
    private void initViewAndListener() {
        radioGroup= (RadioGroup) this.findViewById(R.id.radio_group);


        radio_B=(RadioButton)findViewById(R.id.radio_B);
        radio_B.setOnClickListener(new MyClickListener());


        radio_O=(RadioButton)findViewById(R.id.radio_O);

        radio_O.setOnClickListener(new MyClickListener());

        radio_D=(RadioButton)findViewById(R.id.radio_D);
        radio_D.setOnClickListener(new MyClickListener());

        radio_H=(RadioButton)findViewById(R.id.radio_H);
        radio_H.setOnClickListener(new MyClickListener());


        edit_input = (EditText)findViewById(R.id.edit_input);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new MyClickListener());

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new MyClickListener());


        btn_2 =(Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new MyClickListener());

        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new MyClickListener());

        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new MyClickListener());

        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new MyClickListener());

        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new MyClickListener());

        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new MyClickListener());

        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new MyClickListener());

        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new MyClickListener());

        btn_del = (Button)findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new MyClickListener());

        btn_div = (Button)findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new MyClickListener());

        btn_mul = (Button)findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new MyClickListener());

        btn_min = (Button)findViewById(R.id.btn_min);
        btn_min.setOnClickListener(new MyClickListener());


        btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new MyClickListener());

        btn_eq = (Button)findViewById(R.id.btn_eq);
        btn_eq.setOnClickListener(new MyClickListener());

        btn_pt = (Button)findViewById(R.id.btn_pt);
        btn_pt.setOnClickListener(new MyClickListener());

        btn_C = (Button)findViewById(R.id.btn_C);
        btn_C.setOnClickListener(new MyClickListener());

        btn_sin = (Button)findViewById(R.id.btn_sin);
        btn_sin.setOnClickListener(new MyClickListener());

        btn_cos = (Button)findViewById(R.id.btn_cos);
        btn_cos.setOnClickListener(new MyClickListener());

        btn_tan = (Button)findViewById(R.id.btn_tan);
        btn_tan.setOnClickListener(new MyClickListener());

        btn_sq = (Button)findViewById(R.id.btn_sq);
        btn_sq.setOnClickListener(new MyClickListener());

        btn_B = (Button)findViewById(R.id.btn_B);
        btn_B.setOnClickListener(new MyClickListener());

        btn_O = (Button)findViewById(R.id.btn_O);
        btn_O.setOnClickListener(new MyClickListener());

        btn_D = (Button)findViewById(R.id.btn_D);
        btn_D.setOnClickListener(new MyClickListener());

        btn_H = (Button)findViewById(R.id.btn_H);
        btn_H.setOnClickListener(new MyClickListener());

        btn_rs = (Button)findViewById(R.id.btn_rs);
        btn_rs.setOnClickListener(new MyClickListener());

        btn_lb = (Button)findViewById(R.id.btn_lb);
        btn_lb.setOnClickListener(new MyClickListener());

        btn_rb = (Button)findViewById(R.id.btn_rb);
        btn_rb.setOnClickListener(new MyClickListener());

        btn_ftl = (Button)findViewById(R.id.btn_ftl);
        btn_ftl.setOnClickListener(new MyClickListener());

        btn_pf = (Button)findViewById(R.id.btn_pf);
        btn_pf.setOnClickListener(new MyClickListener());

        btn_ef = (Button)findViewById(R.id.btn_ef);
        btn_ef.setOnClickListener(new MyClickListener());

        btn_log = (Button)findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new MyClickListener());

        btn_ln = (Button)findViewById(R.id.btn_ln);
        btn_ln.setOnClickListener(new MyClickListener());

        btn_pm = (Button)findViewById(R.id.btn_pm);
        btn_pm.setOnClickListener(new MyClickListener());

    }
    private boolean lastIsOperator;  //记录当前是否进行计算操作
    private String lastOperators = "";  //记录上一次进行计算操作的结果

    private double firstNumber = 0D;  //定义并初始化第一次的取值
    private double sencondNumber = 0D;  //定义并初始化第二次的取值

    class MyClickListener implements View.OnClickListener {
        // 实现监听器类必须实现的方法，该方法将会作为事件处理器
        @Override
        public void onClick(View view) {
            String currenText = edit_input.getText().toString();//获取当前文本编辑框的内容
            String operatortorNumber = "";//定义并初始化操作数为”“
            if (currenText.equals("0")) {
                edit_input.setText("");

            }
            operatortorNumber = edit_input.getText().toString();
            if (!lastOperators.equals("")) {//判断上一次操作的数是否为空，非空则建立索引，随之修改当前操作数
                int index = operatortorNumber.lastIndexOf(lastOperators);// 返回指定子字符串在此字符串中最右边出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
                operatortorNumber = operatortorNumber.substring(index + 1);
            }
            //分别获取按钮的内容到文本编辑框
            switch (view.getId()) {
                case R.id.btn_0:
                    edit_input.setText(edit_input.getText()+ "0");
                    lastIsOperator = false;
                    break;
                case R.id.btn_1:
                    edit_input.setText(edit_input.getText() + "1");
                    lastIsOperator = false;
                    break;
                case R.id.btn_2:
                    edit_input.setText(edit_input.getText() + "2");
                    lastIsOperator = false;
                    break;
                case R.id.btn_3:
                    edit_input.setText(edit_input.getText() + "3");
                    lastIsOperator = false;
                    break;
                case R.id.btn_4:
                    edit_input.setText(edit_input.getText() + "4");
                    lastIsOperator = false;
                    break;
                case R.id.btn_5:
                    edit_input.setText(edit_input.getText() + "5");
                    lastIsOperator = false;
                    break;
                case R.id.btn_6:
                    edit_input.setText(edit_input.getText() + "6");
                    lastIsOperator = false;
                    break;
                case R.id.btn_7:
                    edit_input.setText(edit_input.getText() + "7");
                    lastIsOperator = false;
                    break;
                case R.id.btn_8:
                    edit_input.setText(edit_input.getText() + "8");
                    lastIsOperator = false;
                    break;
                case R.id.btn_9:
                    edit_input.setText(edit_input.getText() + "9");
                    lastIsOperator = false;
                    break;
                case R.id.btn_pt:
                    edit_input.setText(edit_input.getText() + ".");
                    lastIsOperator = false;
                    break;
                //归零按钮，将当前操作数归零
                case R.id.btn_C:
                    edit_input.setText("");
                    lastIsOperator = false;
                    firstNumber = 0D;
                    sencondNumber = 0D;
                    lastOperators = "";
                    break;
                //清除按钮，若当前文本编辑器内容不为空，则点击一次删除一个最右边的字符
                case R.id.btn_del:
                    if (TextUtils.isEmpty(edit_input.getText())) {
                        return;
                    }
                    lastIsOperator = false;
                    edit_input.setText(currenText.substring(0, currenText.length() - 1).length() > 0 ? currenText.substring(0, currenText.length() - 1) : "0");
                    break;
                //计算按钮，若当前内容非空、或者以及上一次有操作记录且记录不是”=”的情况下，将当前的操作记录设置为+、-、*、/、=
                case R.id.btn_div:
                    if ((TextUtils.isEmpty(edit_input.getText()) || lastIsOperator) && !lastOperators.equals("=")) {
                        return;
                    }
                    opratorCalc(operatortorNumber, "÷");
                    lastIsOperator = true;
                    edit_input.setText(edit_input.getText() + "÷");
                    lastOperators = "÷";
                    break;
                case R.id.btn_mul:
                    if ((TextUtils.isEmpty(edit_input.getText()) || lastIsOperator) && !lastOperators.equals("=")) {
                        return;
                    }
                    opratorCalc(operatortorNumber, "*");
                    lastIsOperator = true;
                    edit_input.setText(edit_input.getText() + "*");
                    lastOperators = "*";
                    break;
                case R.id.btn_add:
                    if ((TextUtils.isEmpty(edit_input.getText()) || lastIsOperator) && !lastOperators.equals("=")) {
                        return;
                    }
                    opratorCalc(operatortorNumber, "+");
                    lastIsOperator = true;
                    edit_input.setText(edit_input.getText() + "+");
                    lastOperators = "+";
                    break;
                case R.id.btn_min:
                    if ((TextUtils.isEmpty(edit_input.getText()) || lastIsOperator) && !lastOperators.equals("=")) {
                        return;
                    }
                    opratorCalc(operatortorNumber, "-");
                    lastIsOperator = true;
                    edit_input.setText(edit_input.getText() + "-");
                    lastOperators = "-";
                    break;
                case R.id.btn_eq:
                    double result = 0D;
                    if (TextUtils.isEmpty(lastOperators)) {
                        return;
                    }
                    opratorResult(operatortorNumber);
                    sencondNumber = 0D;
                    lastOperators = "=";
                    lastIsOperator = true;
                    edit_input.setText(edit_input.getText() + "\n" + String.valueOf(firstNumber));
                    break;
            }
        }
    }
    private void operate(String operatorNumber){
        if(sencondNumber !=0D){
            if(lastOperators.equals("+")){
                sencondNumber=Double.parseDouble(operatorNumber);
                firstNumber=firstNumber+sencondNumber;
            }
            else if(lastOperators.equals("-")){
                sencondNumber=Double.parseDouble(operatorNumber);
                firstNumber=firstNumber-sencondNumber;
            }
            else if(lastOperators.equals("*")){
                sencondNumber=sencondNumber*Double.parseDouble(operatorNumber);
                firstNumber=firstNumber*sencondNumber;
            }
            else if(lastOperators.equals("÷")){
                sencondNumber=sencondNumber/Double.parseDouble(operatorNumber);
                firstNumber=firstNumber/sencondNumber;
            }
        }
        else{
            if(lastOperators.equals("+")){
                firstNumber=firstNumber+sencondNumber;
            }
            else if(lastOperators.equals("-")){
                firstNumber=firstNumber-sencondNumber;
            }
            else if(lastOperators.equals("*")){
                firstNumber=firstNumber*sencondNumber;
            }
            else if(lastOperators.equals("÷")){
                firstNumber=firstNumber/sencondNumber;
            }
        }
    }

    private void opratorResult(String operatortorNumber) {
        operate(operatortorNumber);
    }

    private void opratorCalc(String operatortorNumber, String currentOprator) {
        if(TextUtils.isEmpty(lastOperators)){
            firstNumber=Double.parseDouble(operatortorNumber);
            return;
        }
        if(lastOperators.equals(currentOprator)){
            if(lastOperators.equals("+")){
                firstNumber=firstNumber+sencondNumber;
            }
            else if(lastOperators.equals("-")){
                firstNumber=firstNumber-sencondNumber;
            }
            else if(lastOperators.equals("*")){
                firstNumber=firstNumber*sencondNumber;
            }
            else if(lastOperators.equals("÷")){
                firstNumber=firstNumber/sencondNumber;
            }
            return;
        }
        operate(operatortorNumber);
    }
}