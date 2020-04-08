package learn.lhb.my_dialog_demo01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AlertDialog dialog;
//        dialog = new AlertDialog.Builder(this).setTitle("普通对话框")
//                .setMessage("是否确定退出?")
//                .setIcon(R.mipmap.ic_launcher)
//                .setPositiveButton("确定",null)
//                .setNegativeButton("取消",null)
//                .create();
//        dialog.show();
        new AlertDialog.Builder(this)
                .setTitle("单选对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(new String[]{"男", "女"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定",null)
                .show();
    }
}
