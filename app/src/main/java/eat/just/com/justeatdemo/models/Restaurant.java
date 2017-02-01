package eat.just.com.justeatdemo.models;

import android.graphics.Bitmap;
/**
 * Created by rmcg2 on 31/01/2017.
 */

public class Restaurant {
    private String Name;
    private String Address;
    private String Postcode;
    private String City;
    private Double RatingAverage;
    private Bitmap Logo;
    private CuisineTypes cuisineTypes;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Double getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public Bitmap getLogo() {
        return Logo;
    }

    public void setLogo(Bitmap logo) {
        Logo = logo;
    }

    public CuisineTypes getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(CuisineTypes cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public String toString() {
        return "Name: " + Name + "\n"
                + "Address: " + Address + "\n"
                + "Postcode: " + Postcode + "\n"
                + "City: " +City + "\n"
                + "RatingsAvg: " + RatingAverage + "\n"
                + "CuisineTypes: " + cuisineTypes.toString();
    }
}
