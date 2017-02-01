package eat.just.com.justeatdemo.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eat.just.com.justeatdemo.R;
import eat.just.com.justeatdemo.models.Restaurant;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresenter presenter;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachPresenter();
        initView();
        setListAdapter();
        requestRestaurantData();
    }

    private void setListAdapter() {
        adapter = new HomeAdapter(restaurantList);
        recyclerView.setAdapter(adapter);
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
    public void requestRestaurantData() {
        presenter.requestJson();
    }

    @Override
    public void updateView(List<Restaurant> data) {
        restaurantList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clearDisposable();
    }
}
