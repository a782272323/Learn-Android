package learn.lhb.lhb_button2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // 匿名类方式
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText("按钮2被点击了");
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    // 与界面控件绑定的方法
    public void click(View view) {
        button1.setText("按钮一被点击了");
    }

    // 实现接口的方法
    @Override
    public void onClick(View v) {
        button3.setText("按钮三被点击了");
    }
}
