package com.liusir.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hjq.toast.Toaster;
import com.liusir.chapter05.util.ViewUtil;

public class EditFocusActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    
    private EditText etUserName;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_focus);
        etUserName = (EditText) findViewById(R.id.et_username);
        EditText etPassword = (EditText) findViewById(R.id.et_passsword);
        //焦点触发事件
        etPassword.setOnFocusChangeListener(this);
        
        //给密码编辑框添加文本变化监听器
        etPassword.addTextChangedListener(new HideTextWatcher(etPassword, 6));
    }
    
    
    /**
     * @Description: 焦点变更事件的处理方法
     * @param v: 当前视图
     * @param hasFocus: 当前空间是否获获得焦点
     * @return void
     * @Author: Charlie liu
     * @Date: 2023/5/16
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (R.id.et_passsword==v.getId() && hasFocus) {
            String username = etUserName.getText().toString();
            //手机不足11位
            if (TextUtils.isEmpty(username) || username.length() < 11) {
            //    username编辑框请求焦点，也就是把光标移回手机号码编辑框
                etUserName.requestFocus();
                Toast.makeText(this, "请输入11位账号", Toast.LENGTH_LONG).show();
            }
        }
    }
    
    private class HideTextWatcher implements TextWatcher {
        //声明一个编辑框对象
        private EditText mView;
        // 声明一个最大长度变量
        private int mMaxLength;
        public HideTextWatcher(EditText v, int mMaxLength) {
            this.mView = v;
            this.mMaxLength = mMaxLength;
        }
        
        
        /**
         * @Description: 在编辑框得输入文本变化前触发
         * @param s:
         * @param start:
         * @param count:
         * @param after:
         * @return void
         * @Author: Charlie liu
         * @Date: 2023/5/16
         */
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        
        }
        
        /**
         * @Description: 在编辑框得输入文本变化时触发
         * @param s:
         * @param start:
         * @param before:
         * @param count:
         * @return void
         * @Author: Charlie liu
         * @Date: 2023/5/16
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        
        }
        
        /**
         * @Description: 文本改变之后触发
         * @param s: 
         * @return void
         * @Author: Charlie liu
         * @Date: 2023/5/16
         */
        @Override
        public void afterTextChanged(Editable s) {
        //    获得已经输入得文本
            String str = s.toString();
        //    密码输入到规定得位数关闭输入法
            if (str.length()==mMaxLength) {
            //    隐藏输入法
                ViewUtil.hideOneInputMethod(EditFocusActivity.this, mView);
            }
        }
        
        
    }

}