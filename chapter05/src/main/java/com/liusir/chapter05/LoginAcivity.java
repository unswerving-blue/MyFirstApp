package com.liusir.chapter05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.toast.Toaster;

import java.util.Random;

public class LoginAcivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    
    private TextView tvPassword;
    //忘记密码
    private Button btnForget;
    //记住密码
    private CheckBox ckRemember;
    
    private ActivityResultLauncher<Intent> register;
    //密码登录按钮
    private RadioButton rbPassword;
    
    //设置默认密码
    private String password ="123456";
    
    //验证码
    private String captcha;
    //电话号码
    private EditText phone;
    //验证码登录
    private RadioButton rbCaptcha;
    
    private Button btnLogin;
    
    //密码框
    private EditText etPassword;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acivity);
        tvPassword = (TextView) findViewById(R.id.tv_password);
        btnForget = (Button) findViewById(R.id.btn_forget);
        btnForget.setOnClickListener(this);
        ckRemember = (CheckBox) findViewById(R.id.ck_remember);
        rbPassword = (RadioButton) findViewById(R.id.rb_password);
        phone = (EditText) findViewById(R.id.et_phone);
        rbCaptcha = (RadioButton) findViewById(R.id.rb_captcha);
        btnLogin = (Button) findViewById(R.id.btn_login);
        etPassword = (EditText) findViewById(R.id.et_passsword);
        // 使用ActivityResultLauncher启动一个Activity，并且在Activity返回结果后处理
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Intent intent = result.getData();
            if (intent!=null && result.getResultCode()==Activity.RESULT_OK) {
            //    用户密码已经为新密码，故更新密码变量
                password = intent.getStringExtra("newPassword");
            }
        });
        
        //复选框改变
        ((RadioGroup) findViewById(R.id.rg_login)).setOnCheckedChangeListener(this);
        
    }
    
    /**
     * @Description: 登录页面复选框设置
     * @param group:
     * @param checkedId:
     * @return void
     * @Author: Charlie liu
     * @Date: 2023/5/17
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_captcha:
                tvPassword.setText("验证码登录");
                btnForget.setText("获取验证码");
                ckRemember.setVisibility(View.GONE);
                break;
            case R.id.rb_password:
                tvPassword.setText("密码登录");
                btnForget.setText("忘记密码");
                ckRemember.setVisibility(View.VISIBLE);
                break;
        }
    }
    
    @Override
    public void onClick(View v) {
        if (phone.length()!=11) {
            Toast.makeText(this, "请输入正确的手机", Toast.LENGTH_SHORT);
            return;
        }
        switch (v.getId()) {
            case R.id.btn_forget:
                //进行密码重置
                if (rbPassword.isChecked()) {
                    Intent toRestPassword = new Intent(this, ResetPasssword.class);
                    toRestPassword.putExtra("phone", phone.getText().toString());
                    register.launch(toRestPassword);
                } else if (rbCaptcha.isChecked()) {
                    //生成6位数随机数的验证码
                    captcha = String.format("%06d", new Random().nextInt(9999));
                    //弹窗提醒对话框吗，提醒用户记住六位验证码
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("请记住验证码");
                    builder.setMessage("手机号" + phone + ",本次验证码是" + captcha);
                    builder.setPositiveButton("好的", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;
            case R.id.btn_login:
                String etPwd = etPassword.getText().toString();
                //密码登录
                if (rbPassword.isChecked()) {
                    if (!password.equals(etPwd)) {
                        Toast.makeText(this, "请输入正确的密码",Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        //提醒用户登录成功
                        loginSuccess();
                    }
                } else if (rbCaptcha.isChecked()) {
                    if (!captcha.equals(etPwd)) {
                        Toast.makeText(this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
                    }else {
                    //   提醒用户登录成功
                        loginSuccess();
                    }
                }
                break;
        }
    }
    
    //检验通过，登录成功
    private void loginSuccess() {
        String alertMsg = String.format("您的手机号是%s，恭喜你通过登录验证，点击“确定”按钮返回上个页面", phone.getText().toString());
        //以下弹窗提醒对话框,提醒用户登录
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(alertMsg);
        builder.setPositiveButton("确定返回", ((dialog, which) -> {
        //结束当前页面
            finish();
        }));
        builder.setNegativeButton("我再看看", null);
        AlertDialog loginAlert = builder.create();
        loginAlert.show();
    }
    
}