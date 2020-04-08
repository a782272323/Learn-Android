package learn.lhb.lhb_caipu;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import org.w3c.dom.Text;

@SuppressLint("NewApi")
public class MenuFragment extends Fragment {

    private View view;
    private int[] settingicon;
    private String[] javaNames;
    private String[] settingText;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 解析布局
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        // 获取实例对象
        MainActivity activity = (MainActivity) getActivity();
        // 获取 activity 的图标数组
        settingicon = activity.getIcons();
        // 获取名称
        javaNames = activity.getName();
        // 获取 activity 设置的文字数组
        settingText = activity.getSettingText();
        if (view != null) {
            initView();
        }

        // 为ListView设置条目监听
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 点击左侧列表item, 右侧内容改变
                ContentFragment listFragment = (ContentFragment) ((MainActivity) getActivity()).getFragmentManager().findFragmentById(R.id.javacontent);
//                ContentFragment listFragment = (ContentFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentById(R.id.javacontent);
                // 设置列表点击位置
                listFragment.setText(settingText[position]);
            }
        });

        return view;
    }

    // 初始化控件方法
    private void initView() {
        mListView = (ListView) view.findViewById(R.id.menu_list);
        if (settingicon != null) {
            mListView.setAdapter(new MyAdapter());
        }
    }

    // 适配器
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return settingicon.length;
        }

        @Override
        public Object getItem(int position) {
            return settingicon[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(), R.layout.item_list, null);
            ImageView mNameTV = (ImageView) convertView.findViewById(R.id.java_icon);
            mNameTV.setBackgroundResource(settingicon[position]);
            TextView mJavaName = (TextView) convertView.findViewById(R.id.java_name);
//            TextView mJavaName = (TextView) convertView.findViewById(R.id.java_icon);
            mJavaName.setText(javaNames[position]);
            return convertView;
        }
    }
}
