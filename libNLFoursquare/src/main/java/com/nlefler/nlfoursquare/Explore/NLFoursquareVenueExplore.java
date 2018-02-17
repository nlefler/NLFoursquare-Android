package com.nlefler.nlfoursquare.Explore;

import com.nlefler.nlfoursquare.Model.FoursquareResponse.NLFoursquareResponse;
import com.nlefler.nlfoursquare.Model.Venue.Explore.NLFoursquareVenueExploreResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by lefler on 6/19/14.
 */
public interface NLFoursquareVenueExplore {
    @GET("venues/explore")
    Call<NLFoursquareResponse<NLFoursquareVenueExploreResponse>>
    explore(@QueryMap Map<String, String> parameters);
}
