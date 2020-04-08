package learn.lhb.lhb_saveqq;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SPSaveQQ {
    // 保存qq账号密码到data.xml文件中
    public static boolean saveUserInfo(Context context, String account, String password) {
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("userName", account);
        edit.putString("pwd", password);
        edit.commit();
        return true;
    }

    // 读取数据
    public static Map<String, String> getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String account = sp.getString("userName", null);
        String password = sp.getString("pwd", null);
        Map<String, String> userMap = new HashMap<>();
        userMap.put("account", account);
        userMap.put("password", password);
        return userMap;
    }
}
