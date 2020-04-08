package learn.lhb.lhb_multichoicedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CharSequence[] items = new CharSequence[]{"旅游", "美食", "看电影", "运动"};
    private boolean[] checkedItems = new boolean[]{false, true, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       findViewById(R.id.bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // 设置标题名称
        builder.setTitle("请添加兴趣爱好!")
                // 设置图标
                .setIcon(R.drawable.xiaomai1)
                // 多选对话框内容设置, 参数描述， 数组，数组对应元素的状态（布尔值），多选对话框点击事件的监听器
                .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // 判断状态是否选中
                        checkedItems[which] = isChecked;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i <= checkedItems.length - 1; i++) {
                            if (checkedItems[i]) {
                                stringBuffer.append(items[i]).append(" ");
                            }
                        }
                        if (stringBuffer != null) {
                            Toast.makeText(MainActivity.this,"" + stringBuffer
                                    ,Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }

                })
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        // 创建对话框
        dialog = builder.create();
        // 对话框显示
        dialog.show();
    }
}
