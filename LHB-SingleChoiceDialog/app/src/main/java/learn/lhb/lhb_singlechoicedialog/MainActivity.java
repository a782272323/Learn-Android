package learn.lhb.lhb_singlechoicedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int textSize = 1;
    private int[] textSizeArray = {10, 20, 25, 30, 40};
    private TextView tv;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置对话框显示样式
        builder.setIcon(R.drawable.xiaomai1)
                // 设置对话框标题
                .setTitle("单选对话框")
                // 设置对话框文本内容,数组，默认的数组下标，点击事件
                .setSingleChoiceItems(new String[]{"小号,", "默认", "中号", "大号", "超大号"}, textSize, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textSize = which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = textSizeArray[textSize];
                        tv.setTextSize(size);
                        // 取消对话框的显示
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        // 创建对话框对象
        AlertDialog dialog = builder.create();
        // 显示对话框在界面上
        dialog.show();
    }
}
