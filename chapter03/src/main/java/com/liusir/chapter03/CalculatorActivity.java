package com.liusir.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;
    //      第一个操作数
    private String firstNum = "";
    //      第二个操作数
    private String secondNum = "";
    //      运算符
    private String operator = "";
    //      当前计算的结果
    private String result = "";
    //      显示文本内容
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
//        从布局文件中获取名叫tv_result
        tv_result = (TextView) findViewById(R.id.tv_result);
//        下面每个按钮控件都注册了点击监听器
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_mutiply).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.ib_sqrt).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_equals).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String inputText;

//       获取按钮文本 将根号转换
        if (v.getId() == R.id.ib_sqrt) {
            inputText = "√";
        } else {
            inputText = ((TextView) v).getText().toString();
        }

        switch (v.getId()) {
//            点击清楚按钮
            case R.id.btn_clear:
                clear();
                break;
//            点击了取消按钮
            case R.id.btn_cancel:
//             点击了加减乘除
            case R.id.btn_add:
            case R.id.btn_minus:
            case R.id.btn_mutiply:
            case R.id.btn_divide:
                operator = inputText;
                refreshText(showText+inputText);
                break;
//             点击了等号按钮
            case R.id.btn_equals:
                refreshText(showText + inputText);
                Double calculateResult = calculateFour();
                refreshOperator(String.valueOf(calculateResult));
                refreshText(showText + calculateResult);
                break;
//          点击了根号按钮
            case R.id.ib_sqrt:
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperator(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + sqrt_result);
                break;
//                获取分数
            case R.id.btn_reciprocal:
                double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
                refreshOperator(String.valueOf(reciprocal_result));
                refreshText(showText+"/");
                break;
//               点击了点按钮
            case R.id.btn_point:
//                解决第一个操作数 点过多
                if (!firstNum.contains(".")) {
                    refreshText(inputText+showText);
                }else {
                    if (operator.equals("")&&firstNum.contains(".")) {
                        break;
//                 解决第二个操作熟 点过多
                    }else if (!operator.equals("")&&secondNum.contains(".")){
                        break;
                    }
                }

            default:
                if (operator == "" && result.length() > 0) {
                    clear();
                }
//                点击数字键
//                给FirstNum， secondNum赋值
                if (operator.equals("")) {
                    firstNum += inputText;
                }else {
//                  有运算符，则继续拼接第二个操作数
                    secondNum += inputText;
                }
//                if (showText.equals("0")&&!inputText.equals(".")) {
//                规范化整数   不需要0在前边
                if (showText.equals("0")&&!inputText.equals(".")) {
                    refreshText(inputText);
                }else{
                    if (operator.equals("")) {
                        refreshText(showText + inputText);
                    } else if (secondNum.startsWith("0")) {
                        secondNum = "";
                    }else {
                        refreshText(showText+inputText);
                    }
                }
                break;
        }
    }

//    四则运算
    private Double calculateFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);

            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);

            case "*":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);

            default:
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    /*点击了清楚按钮*/
    private void clear() {
        refreshText("");
        refreshOperator("");
    }

    //刷新运算结果
    private void refreshOperator(String new_result) {
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }


    /*刷新文本显示*/
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(text);
    }
}