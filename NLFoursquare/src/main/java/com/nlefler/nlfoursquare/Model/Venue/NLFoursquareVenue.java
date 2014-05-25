package com.nlefler.nlfoursquare.Model.Venue;

import java.util.List;

/**
 * Created by Nathan Lefler on 5/19/14.
 */
public class NLFoursquareVenue {
    public String id;
    public String name;
    public NLFoursquareVenueContact contact;
    public NLFoursquareLocation location;
    public List<NLFoursquareCategory> categories;
    public boolean verified;
    public NLFoursquareVenueStats stats;

    public String url;
}
