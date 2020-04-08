package learn.lhb.lhb_caipu;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction beginTransaction;


    // 设置文字
    private String[] settingText = {"" +
        "1.Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点。\n" +
        "2.摒弃了C++里难以理解的多继承、指针等概念。\n" +
        "3.Java语言具有功能强大和简单易用两个特征。\n" +
        "4.Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。\n" +
        "5.Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点。" +
        "6.Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。\n" +
        "1.Vue.js是一套构建用户界面的渐进式框架。与其他重量级框架不同的是，Vue 采用自底向上增量开发的设计。\n" +
        "2.Vue 的核心库只关注视图层，并且非常容易学习，非常容易与其它库或已有项目整合。\n" +
        "3.另一方面，Vue 完全有能力驱动采用单文件组件和Vue生态系统支持的库开发的复杂单页应用。\n" +
        "4.Vue.js 的目标是通过尽可能简单的 API 实现响应的数据绑定和组合的视图组件。\n" +
        "5.Vue.js 自身不是一个全能框架——它只聚焦于视图层。因此它非常容易学习，非常容易与其它库或已有项目整合。\n" +
        "6.另一方面，在与相关工具和支持库一起使用时，Vue.js 也能完美地驱动复杂的单页应用。\n"};

    private String[] settingTexts = {"" +
            "1.将鸡蛋清和淀粉"};
    // 设置图标
    private int[] settingicon = {R.drawable.img1,R.drawable.img2};
    private String[] name = {"Java", "VUE"};
    // 获取图标数组的方法
    public int[] getIcons() {
        return settingicon;
    }
    // 获取设置菜品名称的方法
    public String[] getName() {
        return name;
    }
    // 获取设置文字的方法
    public String[] getSettingText() {
        return settingText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 传教Fragment
        ContentFragment contentFragment = new ContentFragment();
        MenuFragment menuFragment = new MenuFragment();

//        FragmentManager fragmentManager = getFragmentManager();
//
//        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        // 获取事务
        beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.javacontent, contentFragment);
        beginTransaction.replace(R.id.menu, menuFragment);
        beginTransaction.commit();


//        beginTransaction = getSupportFragmentManager().beginTransaction();
//        // 添加
//        beginTransaction.replace(R.id.javacontent, contentFragment);
//        beginTransaction.replace(R.id.menu, menuFragment);
//        // 提交事务
//        beginTransaction.commit();
    }
}
