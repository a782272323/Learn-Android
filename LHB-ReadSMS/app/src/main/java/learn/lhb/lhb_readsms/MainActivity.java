package learn.lhb.lhb_readsms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvSms, tvDes;
    private Button btnSms;
    private String text = "";
    private List<SmsInfo> smsInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvSms = (TextView) findViewById(R.id.tv_sms);
        tvDes = (TextView) findViewById(R.id.tv_des);
        btnSms = (Button) findViewById(R.id.btn_sms);
        smsInfos = new ArrayList<SmsInfo>();
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_SMS}, 1);
            }
        });
    }

    public void getSms() {
        Uri uri = Uri.parse("content://sms/");
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{"_id", "address", "body"}, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            tvDes.setVisibility(View.VISIBLE);
            if (smsInfos != null) {
                smsInfos.clear();
            }
            text = "";
            while (cursor.moveToNext()) {
                int _id = cursor.getInt(0);
                String address = cursor.getString(1);
                String body = cursor.getString(2);
                SmsInfo smsInfo = new SmsInfo(_id, address, body);
                smsInfos.add(smsInfo);
            }
            cursor.close();
        }
        for (int i = 0; i < smsInfos.size(); i++) {
            text += "手机号码: " + smsInfos.get(i).getAddress() + "\n";
            text += "短信内容: " + smsInfos.get(i).getBody() + "\n";
        }
        tvSms.setText(text);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    getSms();
                } else {
                    Toast.makeText(this, "" + "权限" + permissions[i]
                    + "申请失败，不能读取系统短信", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
