package learn.lhb.lhb_saveqq;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSaveQQ {
    // 保存QQ账户和登录密码到data.txt文件中
    public static boolean saveUserInfo(Context context, String account,String password) {
        FileOutputStream fos = null;
        try {
            // 获取文件到输出流对象
            fos = context.openFileOutput("data.txt", Context.MODE_PRIVATE);
            // 将数据转换为字节码到形式写入data.txt
            fos.write((account + ": " + password).getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 从data.txt中获取存储的qq账户和密码
    public static Map<String, String> getUserInfo(Context context) {
        String content = "";
        FileInputStream fis = null;
        try {
            // 获取文件的输入流对象fis
            fis = context.openFileInput("data.txt");
            // 将输入流对象中的数据转换为字节码
            byte[] buffer = new byte[fis.available()];
            // 通过read（）方法读取字节码中的数据
            fis.read(buffer);
            // 将获取的字节码转换为字符串
            Map<String, String> userMap = new HashMap<>();
            // 将字符串以 ： 分隔后形成一个数组形式
            String[] infes = content.split(":");
            // 将数组中的第一个数据放入userMap集合中
            userMap.put("account", infes[0]);
            // 将数组中第二个数据放入userMap中
            userMap.put("password", infes[1]);
            return userMap;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
