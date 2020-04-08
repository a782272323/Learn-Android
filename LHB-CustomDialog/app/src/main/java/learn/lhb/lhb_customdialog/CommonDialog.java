package learn.lhb.lhb_customdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CommonDialog extends AlertDialog {
    // 显示的标题
    private TextView titleTv;
    // 显示的消息
    private TextView messageTv;
    // 确认和取消按钮
    private Button negtiveBn, positiveBn;

    protected CommonDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将自定义布局显示到这个类
        setContentView(R.layout.custom_dialog);
        // 调用初始化方法
        initView();
        // 调用确定按钮和取消按钮的初始化方法
        initEvent();
    }

    // 初始化界面控件
    private void initView() {
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);
        negtiveBn = (Button) findViewById(R.id.negtive);
        positiveBn = (Button) findViewById(R.id.positive);
    }

    // 设置点击确定按钮和取消按钮的监听器
    public interface OnClickBottomListener {
        // 实现确定按钮点击事件方法
        void onPositiveClick();
        // 实现取消按钮点击事件方法
        void onNegtiveClick();
    }

    // 设置确定取消按钮的回调
    public OnClickBottomListener onClickBottomListener;
    public CommonDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }

    // 初始化界面的确定和取消监听器
    private void initEvent() {
        // 设置确定按钮的点击事件的监听器
        positiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断接口参数是否为空，
                if (onClickBottomListener != null) {
                    onClickBottomListener.onPositiveClick();
                }
            }
        });
        // 设置取消按钮的点击事件的监听器
        negtiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断接口参数是否为空，
                if (onClickBottomListener != null) {
                    onClickBottomListener.onNegtiveClick();
                }
            }
        });
    }

    private String message;
    private String title;
    private String positive,negtive;

    public CommonDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonDialog setPositive(String positive) {
        this.positive = positive;
        return this;
    }

    public CommonDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CommonDialog setNegtive(String negtive) {
        this.negtive = negtive;
        return this;
    }

    // 初始化界面控件的显示数据
    private void refreshView() {
        // 如果自定义类title 和 message会显示自定义的消息，否则不显示title和message的消息
        if (!TextUtils.isEmpty(title)) {
            // 设置标题控件的文本为自定义的title
            titleTv.setText(title);
            titleTv.setVisibility(View.VISIBLE);
        } else {
            // 标题控件设置为隐藏控件
            titleTv.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(message)) {
            // 设置消息控件的文本为自定义的message消息
            messageTv.setText(message);
        }

        // 如果自定义类按钮的文本，则按钮显示自定义的文本，否则，按钮显示确定或者取消文本
        if (!TextUtils.isEmpty(positive)) {
            // 设置按钮的文本为自定义的文本信息
            positiveBn.setText(positive);
        } else {
            // 设置按钮文本为"确定"
            positiveBn.setText("确定");
        }
        if (!TextUtils.isEmpty(negtive)) {
            // 设置按钮的文本为自定义的文本信息
            negtiveBn.setText(negtive);
        } else {
            // 设置按钮文本为"确定"
            negtiveBn.setText("取消");
        }
    }

    // 显示
    @Override
    public void show() {
        super.show();
        refreshView();
    }
}
