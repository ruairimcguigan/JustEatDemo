package eat.just.com.justeatdemo.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Because the API returns a list of restaurants and not just an individual one,
 * we also need to create a class that will map the restaurants key to a list of
 * restaurant objects.
 */

public class RestaurantsResponse {

    List<Restaurant> restaurants;

    /**
     * a public constructor may be needed to initialize the list. To avoid null
     * pointer exceptions that may result from trying to get back the movie lists,
     * it is highly recommended to initialize these objects in the empty constructor.
     */
    public RestaurantsResponse(){
        restaurants = new ArrayList<>();
    }

    public static RestaurantsResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        RestaurantsResponse restaurantsResponse = gson.fromJson(response, RestaurantsResponse.class);
        return restaurantsResponse;
    }
}
