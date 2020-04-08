package learn.lhb.hello;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 引用图片资源
        getResources().getDrawable(R.mipmap.ic_launcher);
        getResources().getDrawable(R.drawable.xiaomai_1);
        // 引用主题资源
        setTheme(R.style.AppTheme);
        // 引用布局资源
        setContentView(R.layout.activity_main);
        // 引用字符串资源
        getResources().getString(R.string.app_name);
        // 引用尺寸资源
        getResources().getDimension(R.dimen.layout_size);
    }
}
