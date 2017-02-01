package eat.just.com.justeatdemo.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eat.just.com.justeatdemo.R;
import eat.just.com.justeatdemo.models.Restaurants;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private ArrayList<Restaurants> restaurants;

    // This should use a populate method, see below
    public HomeAdapter(ArrayList<Restaurants> dataList) {
        restaurants = dataList;
    }

    // I created thie populate method:
    public void populate(List<Restaurants> dataList) {
        restaurants = dataList;
        notifyDataSetChanged();
    }
    
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.name.setText(restaurants.get(position).getName());
        holder.address.setText(restaurants.get(position).getAddress());
        holder.rating.setText(String.valueOf(restaurants.get(position).getName()));
    }

    @Override
    public int getItemCount() {
        // should be the count of the items held in the resturants array list
        return 0;
    }

    // use butter knife here?
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
