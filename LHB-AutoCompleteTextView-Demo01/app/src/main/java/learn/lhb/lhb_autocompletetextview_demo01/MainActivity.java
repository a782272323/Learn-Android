package learn.lhb.lhb_autocompletetextview_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {

    private String[] Countries = {"China", "Russia", "Ukraine", "Germany", "Italy"
        ,"Australia", "Pakistan", "Iraq"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Countries);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView);

        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setThreshold(1);

    }
}
