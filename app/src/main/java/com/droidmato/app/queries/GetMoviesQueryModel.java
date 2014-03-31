package com.droidmato.app.queries;

import android.util.Log;

/**
 * Created by Rex St. John on 3/30/14.
 */
public class GetMoviesQueryModel {

    private int page_limit;
    private int page;
    private String country;

    public int getPage_limit() {
        return page_limit;
    }

    public void setPage_limit(int page_limit) {
        this.page_limit = page_limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page < 1){
            Log.d("DroidMato", "Warning: Page must be 1 or greater");
        }
        this.page = page;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}