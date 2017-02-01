package eat.just.com.justeatdemo.main;

import java.util.ArrayList;

import eat.just.com.justeatdemo.models.Restaurants;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public interface IHomeView {

    void fetchData();
    // use List interface 
    void updateView(ArrayList<Restaurants> data);

}
