package eat.just.com.justeatdemo.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import eat.just.com.justeatdemo.R;
import eat.just.com.justeatdemo.models.Restaurants;

public class HomeActivity extends AppCompatActivity implements IHomeView {

    HomePresenter presenter;
    RecyclerView recyclerView;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachPresenter();
        initView();
        fetchData();
    }

    private void attachPresenter() {
        presenter = new HomePresenter(this);
    }

    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.restaurant_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void fetchData() {
        presenter.requestJson();
    }

    @Override
    public void updateView(ArrayList<Restaurants> data) {
        adapter = new HomeAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clearDisposable();
    }
}
