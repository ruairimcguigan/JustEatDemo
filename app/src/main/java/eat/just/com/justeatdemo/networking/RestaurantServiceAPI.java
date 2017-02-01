package eat.just.com.justeatdemo.networking;

import java.util.ArrayList;

import eat.just.com.justeatdemo.models.Restaurants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * a network service which will be used to call API from a mock server
 */

public interface RestaurantServiceAPI {

    @Headers({"Accept-Tenant: uk", "Accept-Language: en-GB",
            "Authorization: Basic VGVjaFRlc3RBUEk6dXNlcjI=", "Host: public.je-apis.com" })
    @GET("/restaurants?q=")
    Observable<ArrayList<Restaurants>> getRestaurantsList();
}
