package eat.just.com.justeatdemo.main;

import android.content.Context;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import eat.just.com.justeatdemo.models.Restaurants;
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

    IHomeView view;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ArrayList<Restaurants> restaurantsList;

    public HomePresenter(IHomeView view){
        this.view = view;
    }

    public void requestJson(){
        RestaurantServiceAPI restaurantServiceAPI = new Retrofit.Builder()
                .baseUrl(Util.SERVICE_END_POINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestaurantServiceAPI.class);

//        compositeDisposable.add(restaurantServiceAPI.getRestaurantsList()
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())
//        .subscribe(this::handleResponse, this::handleError));

        compositeDisposable.add(restaurantServiceAPI.getRestaurantsList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));

    }

    private void handleResponse(ArrayList<Restaurants> restaurants) {
        restaurantsList = new ArrayList<>(restaurants);
        view.updateView(restaurants);

    }

    private void handleError(Throwable error) {
        Toast.makeText((Context) view, "Error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    public void clearDisposable(){
        compositeDisposable.clear();
    }

}
