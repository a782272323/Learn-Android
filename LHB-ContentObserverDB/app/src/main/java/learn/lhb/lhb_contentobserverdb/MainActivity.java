package learn.lhb.lhb_contentobserverdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ContentResolver resolver;
    private Uri uri;
    private ContentValues values;
    private Button btnInsert;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createDB();
    }

    private void initView(){
        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnSelect = (Button) findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }

    private void createDB() {
        PersonDBOpenHelper helper = new PersonDBOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        for (int i = 0; i < 3; i++) {
            ContentValues values = new ContentValues();
            values.put("name", "itcast" + i);
            db.insert("info", null, values);
        }
        db.close();
    }

    @Override
    public void onClick(View v) {
        resolver = getContentResolver();
        uri = Uri.parse("content://learn.lhb.lhb_contentobserverdb/info");
        values = new ContentValues();
        switch (v.getId()) {
            case R.id.btn_insert:
                Random random = new Random();
                values.put("name","add_itcast"+random.nextInt(10));
                Uri newuri = resolver.insert(uri, values);
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                Log.i("数据库应用", "添加");
                break;
            case R.id.btn_delete:
                int deleteCount = resolver.delete(uri, "name=?", new String[]{"itcast0"});
                Toast.makeText(this,"删除成功"+deleteCount+"行",Toast.LENGTH_SHORT).show();
                Log.i("数据库应用", "删除");
            case R.id.btn_select:
                List<Map<String,String>> data = new ArrayList<>();
                Cursor cursor = resolver.query(uri, new String[]{"_id", "name"}, null, null, null);
                while (cursor.moveToNext()) {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id", cursor.getString(0));
                    map.put("name", cursor.getString(1));
                    data.add(map);
                }
                cursor.close();
                Log.i("数据库应用", "查询结果 = " + data.toString());
                break;
            case R.id.btn_update:
                values.put("name","update_itcast");
                int updateCount = resolver.update(uri, values, "name=?", new String[]{"itcast1"});
                Toast.makeText(this, "更新成功" + updateCount + "行", Toast.LENGTH_SHORT).show();
                Log.i("数据库应用", "更新");
                break;
        }
    }
}
