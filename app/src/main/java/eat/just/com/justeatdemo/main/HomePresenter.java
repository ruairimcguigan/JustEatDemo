package eat.just.com.justeatdemo.main;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import eat.just.com.justeatdemo.models.Restaurant;
import eat.just.com.justeatdemo.networking.RestaurantServiceAPI;
import eat.just.com.justeatdemo.util.Util;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public class HomePresenter {

    private static final String TAG = HomePresenter.class.getSimpleName();
    private HomeView view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ArrayList<Restaurant> restaurantsList;

    public HomePresenter(HomeView view){
        this.view = view;
    }

    public void requestJson(){
        RestaurantServiceAPI restaurantServiceAPI = new Retrofit.Builder()
                .baseUrl(Util.SERVICE_END_POINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestaurantServiceAPI.class);

        compositeDisposable.add(restaurantServiceAPI.getRestaurantsList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));

    }

    private void handleResponse(List<Restaurant> restaurants) {
        restaurantsList = new ArrayList<>(restaurants);
        view.updateView(restaurants);

    }

    private void handleError(Throwable error) {
        Toast.makeText((Context) view, "Error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "handleError: Error: " +error.getLocalizedMessage());
    }

    public void clearDisposable(){
        compositeDisposable.clear();
    }

}
