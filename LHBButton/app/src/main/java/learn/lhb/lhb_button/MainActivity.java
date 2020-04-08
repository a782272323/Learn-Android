package learn.lhb.lhb_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 获取按钮
        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
        button3 = (Button) this.findViewById(R.id.button3);

        // 添加注册监听事件
        button3.setOnClickListener(this);

        // 设置监听方法
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("按钮一被电击了");

            }
        });

    }

    public void click(View view) {
        button2.setText("按钮2被电击了");
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button3: button3.setText("按钮3被电击了");
        }

    }


}
