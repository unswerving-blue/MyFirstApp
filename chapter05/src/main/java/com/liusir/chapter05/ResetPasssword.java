package com.liusir.chapter05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class ResetPasssword extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    
    //新密码
    private String newPwd;
    
    //确认新密码
    private String confirmPwd;
    
    //新密码框
    private EditText etNewPwd;
    
    //确认新密码框
    private EditText etConfirmPwd;
    
    //验证码框
    private EditText etCaptcha;
    private String captcha;
    private String mCaptcha;
    
    //手机号
    private String phone;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_passsword);
        etConfirmPwd = (EditText) findViewById(R.id.et_confirm_pwd);
        etNewPwd = (EditText) findViewById(R.id.et_new_pwd);
        Button btnGetCaptcha = (Button) findViewById(R.id.btn_getcaptcha);
        etCaptcha = (EditText) findViewById(R.id.et_captcha);
        newPwd = etNewPwd.getText().toString();
        confirmPwd = etConfirmPwd.getText().toString();
        captcha = etCaptcha.getText().toString();
        phone = getIntent().getStringExtra("phone");
    
        //按钮注册监听事件
        etCaptcha.setOnFocusChangeListener(this);
        ((Button) findViewById(R.id.btn_done)).setOnClickListener(this);
        etConfirmPwd.setOnFocusChangeListener(this);
    }
    
    /**
     * @Description: 按钮事件
     * @param v: 
     * @return void
     * @Author: Charlie liu
     * @Date: 2023/5/19
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getcaptcha:
                //使用0填充  六位数
                mCaptcha = String.format("%06d", new Random().nextInt(999999));
                AlertDialog.Builder alertCaptcha = new AlertDialog.Builder(this);
                alertCaptcha.setTitle("请记住验证码");
                alertCaptcha.setMessage("手机号" + phone + ",本次验证码是" + mCaptcha);
                alertCaptcha.setPositiveButton("好的", null);
                alertCaptcha.show();
                break;
            case R.id.btn_done:
                if (newPwd.length() < 6 || confirmPwd.length() < 6) {
                    Toast.makeText(this, "密码长度不够", Toast.LENGTH_SHORT).show();
                }
                if (!newPwd.equals(confirmPwd)) {
                    Toast.makeText(this, "两次密码不匹配", Toast.LENGTH_SHORT).show();
                }
                if (mCaptcha.length() == 0) {
                    Toast.makeText(this, "请先获取二维码", Toast.LENGTH_SHORT).show();
                }
                if (mCaptcha.equals(captcha)) {
                    Toast.makeText(this, "验证码不正确", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this, "密码修改成功", Toast.LENGTH_SHORT).show();
                //以下把修好的新密码返回给上一个页面
                Intent intent = new Intent();
                intent.putExtra("newpassword", newPwd);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
        }
    }
    
    /**
     * @Description: 保证新密码位数正确
     * @param v: 当前视图
	 * @param hasFocus: 是否获得焦点
     * @return void
     * @Author: Charlie liu
     * @Date: 2023/5/19
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.et_confirm_pwd:
                if (newPwd.length() < 6 && hasFocus) {
                    // 重新回到新密码框
                    etNewPwd.requestFocus();
                    Toast.makeText(this, "密码长度不低于6位", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}