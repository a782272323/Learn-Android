package learn.lhb.lhb_saveqq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 账户输入框
    private EditText et_account;
    // 密码输入框
    private EditText et_password;
    // 登录按钮
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // 通过工具类获取qq账号和密码信息
//        Map<String, String> userInfo = FileSaveQQ.getUserInfo(this);
        Map<String, String> userInfo = SPSaveQQ.getUserInfo(this);

        if (userInfo != null) {
            et_account.setText(userInfo.get("account"));
            et_password.setText(userInfo.get("password"));
        }
    }


    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        // 设置按钮的点击监听事件
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // 点击登录按钮是，获取界面上输入的qq账户和密码
                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString();
                // 校验账号密码是否为空
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this,"请输入QQ账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                // 保存用户信息
//                boolean isSaveSuccess = FileSaveQQ.saveUserInfo(this, account, password);
                boolean isSaveSuccess = SPSaveQQ.saveUserInfo(this, account, password);
                if (isSaveSuccess) {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT);
                }
                break;
        }
    }
}
