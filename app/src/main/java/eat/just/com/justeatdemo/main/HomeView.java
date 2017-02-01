package eat.just.com.justeatdemo.main;

import java.util.List;

import eat.just.com.justeatdemo.models.Restaurant;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public interface HomeView {

    void requestRestaurantData();
    void updateView(List<Restaurant> data);

}
