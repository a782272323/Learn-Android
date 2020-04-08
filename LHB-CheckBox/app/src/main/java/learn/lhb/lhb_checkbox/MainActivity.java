package learn.lhb.lhb_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private TextView hoddy;
    private String hobbys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        hoddy = findViewById(R.id.hobby);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        hobbys = new String();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String text = buttonView.getText().toString();
        if (isChecked) {
            // 选中的状态
            if (!hobbys.contains(text)) {
                hobbys = hobbys + text;
                hoddy.setText(hobbys);
            }
        } else {
            // 为选中状态
            if (hobbys.contains(text)) {
                hobbys = hobbys.replace(text, "");
                hoddy.setText(hobbys);
            }
        }
    }
}
