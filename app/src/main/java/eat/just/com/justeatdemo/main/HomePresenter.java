package eat.just.com.justeatdemo.main;

import android.content.Context;
import android.util.Log;
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

    public static final String TAG = HomePresenter.class.getSimpleName();
    // private variable
    IHomeView view;
    // private variable, I didn't know about this class, thanks
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    // 1. private variable
    // 2. use List interface
    ArrayList<Restaurants> restaurantsList;

    public HomePresenter(IHomeView view){
        this.view = view;
    }

    public void requestJson(){
        // this should be built once at the start of the app, you could attach it to JustEatApplication and pass it in as a dependency to the presenter
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
        // why create a new list? Pass straight to updateView
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
