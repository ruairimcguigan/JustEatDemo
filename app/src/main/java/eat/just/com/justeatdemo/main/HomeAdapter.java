package eat.just.com.justeatdemo.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eat.just.com.justeatdemo.R;
import eat.just.com.justeatdemo.models.Restaurant;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Restaurant> restaurants;
    private Context context;

    public HomeAdapter(List<Restaurant> dataList) {
        restaurants = dataList;
    }

//    public void populateAdapter(List<Restaurant> dataList){
//        this.restaurants = dataList;
//        this.notifyDataSetChanged();
//    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        holder.name.setText(restaurant.getName());
        holder.address.setText(restaurant.getAddress());
        holder.rating.setText(String.valueOf(restaurant.getRatingAverage()));
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, address, rating;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.restaurant_name);
            address = (TextView)itemView.findViewById(R.id.restaurant_address);
            rating = (TextView)itemView.findViewById(R.id.restaurant_rating);
        }
    }
}
