package learn.lhb.lhb_calculator_demo02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 声明按钮1234567890数字
    private Button btn0,btn1,btn2,btn3,btn4,btn5
            ,btn6,btn7,btn8,btn9;
    // 声明按钮+-*/
    private Button btnJia,btnJian,btnCheng,btnChu;
    // 声明功能按钮，C,回退，.，=
    private Button btnDian,btnDengyu,btnQingchu,btnHuiShan;
    // 声明结果文本
    private TextView etResult;

    private String str = null;
    String[] strings;
    Integer sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton();
    }

    // 通过接口获取组件
    public void getButton() {
        // 获取按钮组件
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn4);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnJia = (Button) findViewById(R.id.btnJia);
        btnJian = (Button) findViewById(R.id.btnJian);
        btnCheng = (Button) findViewById(R.id.btnCheng);
        btnChu = (Button) findViewById(R.id.btnChu);
        btnDian = (Button) findViewById(R.id.btnDian);
        btnDengyu = (Button) findViewById(R.id.btnDengyu);
        btnQingchu = (Button) findViewById(R.id.btnQingchu);
        btnHuiShan = (Button) findViewById(R.id.btnHuishan);


        // 获取结果textVies组件
        etResult = (TextView) findViewById(R.id.etResult);
        // 绑定监听
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnJia.setOnClickListener(this);
        btnJian.setOnClickListener(this);
        btnCheng.setOnClickListener(this);
        btnChu.setOnClickListener(this);
        btnDian.setOnClickListener(this);
        btnDengyu.setOnClickListener(this);
        btnQingchu.setOnClickListener(this);
        btnHuiShan.setOnClickListener(this);

    }

    // 实现接口方法
    @Override
    public void onClick(View v) {
        // 计算的结果文本
        str = etResult.getText().toString();
        // 循环遍历
        switch (v.getId()) {
            // 0-9的数字按钮
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                etResult.setText(str+((Button)v).getText());
                break;
            // + - * /
            case R.id.btnJia:
            case R.id.btnJian:
            case R.id.btnCheng:
            case R.id.btnChu:
                etResult.setText(str+((Button)v).getText());
                break;
            // 点功能不实现
            case R.id.btnDian:
                Dialog1();
                break;
            // 清楚
            case R.id.btnQingchu:
                etResult.setText("");
                break;
            case R.id.btnDengyu:
                getResult();
                break;
            // 回退功能
            case R.id.btnHuishan:
                str = etResult.getText().toString();
                try {
                    etResult.setText(str.substring(0, str.length() - 1));
                } catch (Exception e) {
                    e.printStackTrace();
                    etResult.setText("");
                }
                break;
        }
    }

    // 算法逻辑
    public void getResult() {
        str = etResult.getText().toString();
        // 将str存入数组
        strings = new String[str.length()];
        // 记录下标
        int num = 0;
        for (int i = 0; i < strings.length; i++) {
            // 遍历数组
            strings[i] = str.substring(i, i + 1);
            if (strings[i].equals("+") || strings[i].equals("-") || strings[i].equals("*") || strings[i].equals("/")) {
                num = i;
            }
        }
        // 第一个数
        Integer num1 = Integer.parseInt(str.substring(0, num));
        // 计算符号
        String fuhao = str.substring(num, num + 1);
        // 第二个数
        Integer num2 = Integer.parseInt(str.substring(num + 1));

        if (fuhao.equals("+")) {
            sum = num1+num2;
        } else if (fuhao.equals("-")) {
            sum = num1 - num2;
        } else if (fuhao.equals("*")) {
            sum = num1 * num2;
        } else if (fuhao.equals("/")) {
            if (num2 == 0) {
                etResult.setText("被除数不能为0");
                return;
            }
            sum = num1 / num2;
        }
        etResult.setText(num1+fuhao+num2+" = "+sum);
    }

    // . 按钮弹窗提示
    public void Dialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(".的功能不实现")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
