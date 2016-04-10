package com.nlefler.nlfoursquare.Search;

import com.nlefler.nlfoursquare.Model.FoursquareResponse.NLFoursquareResponse;
import com.nlefler.nlfoursquare.Model.Venue.Search.NLFoursquareVenueSearchResponse;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Nathan Lefler on 5/19/14.
 */
public interface NLFoursquareVenueSearch {
    @GET("/venues/search")
    void search(@QueryMap Map<String, String> parameters,
                Callback<NLFoursquareResponse<NLFoursquareVenueSearchResponse>> callback);
}
