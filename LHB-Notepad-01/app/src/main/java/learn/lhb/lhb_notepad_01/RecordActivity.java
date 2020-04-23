package learn.lhb.lhb_notepad_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import learn.lhb.lhb_notepad_01.database.SQLiteHelper;
import learn.lhb.lhb_notepad_01.utils.DBUtils;

public class RecordActivity extends Activity implements View.OnClickListener {

    ImageView note_back;
    TextView note_time;
    EditText content;
    ImageView delete;
    ImageView note_save;
    SQLiteHelper mSQLiteHelper;
    TextView noteName;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        note_back = (ImageView) findViewById(R.id.note_back);
        note_time =  (TextView) findViewById(R.id.tv_time);
        content = (EditText) findViewById(R.id.note_content);
        delete = (ImageView) findViewById(R.id.delete);
        note_save = (ImageView) findViewById(R.id.note_save);
        noteName = (TextView) findViewById(R.id.note_name);
        note_back.setOnClickListener(this);
        delete.setOnClickListener(this);
        note_save.setOnClickListener(this);
        initData();
    }

    protected void initData() {
        mSQLiteHelper = new SQLiteHelper(this);
        noteName.setText("添加记录");

        System.out.println("test1");
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            if (id != null) {
                noteName.setText("修改记录");
                content.setText(intent.getStringExtra("content"));
                note_time.setText(intent.getStringExtra("time"));
                note_time.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.note_back: // 后退键事件
                finish();
                break;
            case R.id.delete: // 清空按钮
                content.setText("");
                break;
            case R.id.note_save: // 保存
                String noteContent = content.getText().toString().trim();
                if (id != null) {
                    if (noteContent.length() > 0) {
                        if (noteContent.length() > 0) {
                            if (mSQLiteHelper.updateData(id, noteContent, DBUtils.getTime())) {
                                showToast("修改成功");
                                setResult(2);
                                finish();
                            } else  {
                                showToast("修改失败");
                            }
                        } else {
                            showToast(" 修改内容不能为空 ");
                        }
                    } else  {
                        // 添加记录
                        if (noteContent.length() > 0) {
                            if (mSQLiteHelper.insertData(noteContent, DBUtils.getTime())) {
                                showToast("保存成功");
                                setResult(2);
                                finish();
                            } else {
                                showToast("保存失败");
                            }
                        } else {
                            showToast(" 修改内容不能为空 ");
                        }
                    }
                }
                break;
        }
    }

    public void showToast(String message) {
        Toast.makeText(RecordActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
