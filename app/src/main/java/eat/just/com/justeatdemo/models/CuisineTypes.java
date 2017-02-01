package eat.just.com.justeatdemo.models;

import java.util.ArrayList;

/**
 * Created by rmcg2 on 31/01/2017.
 */

public class CuisineTypes {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSeoName() {
        return SeoName;
    }

    public void setSeoName(String seoName) {
        SeoName = seoName;
    }

    private String Id;
    private String Name;
    private String SeoName;
}
