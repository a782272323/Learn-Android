package learn.lhb.lhb_recyclerviewshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Integer> Datas;
    private HomeAdpter homeAdpter;
    private int[] img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = (RecyclerView) this.findViewById(R.id.id_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutM)
    }
}
