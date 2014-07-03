package org.michaelevans.foursquaredemo;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.nlefler.nlfoursquare.Model.Venue.NLFoursquareVenue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lefler on 7/2/14.
 */
public class VenueListAdapter implements ListAdapter {

    private List<NLFoursquareVenue> venueList = new ArrayList<NLFoursquareVenue>();
    private LayoutInflater layoutInflater;
    private Set<DataSetObserver> observers = new HashSet<DataSetObserver>();

    public VenueListAdapter(LayoutInflater inflater) {
        super();

        this.layoutInflater = inflater;
    }

    public void setVenueList(List<NLFoursquareVenue> venueList) {
        this.venueList = venueList;
        for (DataSetObserver observer : observers) {
            observer.onChanged();
        }
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        observers.add(dataSetObserver);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        observers.remove(dataSetObserver);
    }

    @Override
    public int getCount() {
        return venueList.size();
    }

    @Override
    public Object getItem(int i) {
        return venueList.get(i);
    }

    @Override
    public long getItemId(int i) {
        NLFoursquareVenue venue = (NLFoursquareVenue)getItem(i);
        return venue.id.hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NLFoursquareVenue venue = (NLFoursquareVenue)getItem(i);

        LinearLayout venueLayout = (LinearLayout)layoutInflater.inflate(R.layout.venue_list_item, null);
        TextView venueName = (TextView)venueLayout.findViewById(R.id.venue_name);
        TextView venueAddress = (TextView)venueLayout.findViewById(R.id.venue_address);

        venueName.setText(venue.name);
        venueAddress.setText(venue.location.address);

        return venueLayout;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
