package learn.lhb.layout_lhb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 调用布局控件自定义的id,初始化布局
        RelativeLayout relativeLayout = findViewById(R.id.layoutid);

        /**
         * java控制布局文件
         */
//        // java控制布局文件
//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        // 包裹内容的显示
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        // 居中布局显示
//        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//        // 设置文本文字，颜色，大小
//        TextView textView = new TextView(this);
//        textView.setText("Java代码实现界面布局效果(梁鸿斌)");
//        textView.setTextColor(Color.GREEN);
//        textView.setTextSize(18);
//        // 把 textView 添加到 RelativeLayout
//        relativeLayout.addView(textView,layoutParams);
//        setContentView(relativeLayout);
    }
}
