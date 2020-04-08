package learn.lhb.lhb_customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_dialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final CommonDialog commonDialog = new CommonDialog(MainActivity.this);
//        commonDialog.setTitle("提示");
//        commonDialog.setMessage("你确定要删除信息?");
//        commonDialog.setNegtive("取 消");
//        commonDialog.setPositive("确 定");
//        commonDialog.setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
//            // 编写点击确定按钮的逻辑代码
//            @Override
//            public void onPositiveClick() {
//                commonDialog.dismiss();
//            }
//            // 编写点击取消按钮的逻辑代码
//            @Override
//            public void onNegtiveClick() {
//                commonDialog.dismiss();
//            }
//        });
        commonDialog.setTitle("提示")
                .setMessage("你确定要删除信息?")
                .setNegtive("取 消")
                .setPositive("确 定")
                .setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        commonDialog.dismiss();
                    }

                    @Override
                    public void onNegtiveClick() {
                        commonDialog.dismiss();
                    }
                });
        // 使自定义对话框显示
        commonDialog.show();
    }
}
