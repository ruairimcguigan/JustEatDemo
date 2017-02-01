package eat.just.com.justeatdemo.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import eat.just.com.justeatdemo.R;
import eat.just.com.justeatdemo.models.Restaurants;

// "I" prefix is not needed here
public class HomeActivity extends AppCompatActivity implements IHomeView {

    // these variables should be private 
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
        // this should have a more descriptive name, what is the presenter actually doing here? Fetching restuarants?
        presenter.requestJson();
    }

    @Override
    public void updateView(ArrayList<Restaurants> data) {
        // 1. do not recreatd the adapter each time, create a method called populate(ArrayList<Restaurants> data) with the data
        // 2. use base type List instead of ArrayList
        adapter = new HomeAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clearDisposable();
    }
}
