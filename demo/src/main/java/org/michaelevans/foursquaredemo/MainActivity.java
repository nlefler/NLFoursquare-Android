package org.michaelevans.foursquaredemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nlefler.nlfoursquare.Model.FoursquareResponse.NLFoursquareResponse;
import com.nlefler.nlfoursquare.Model.NLFoursquareClientParameters;
import com.nlefler.nlfoursquare.Model.Venue.NLFoursquareVenue;
import com.nlefler.nlfoursquare.Model.Venue.NLFoursquareVenueSearchResponse;
import com.nlefler.nlfoursquare.Search.NLFoursquareVenueSearch;
import com.nlefler.nlfoursquare.Search.NLFoursquareVenueSearchParametersBuilder;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView outputView = (TextView)findViewById(R.id.output_view);

        NLFoursquareClientParameters clientParameters = new NLFoursquareClientParameters(
                getString(R.string.client_id),
                getString(R.string.client_secret)
        );
        NLFoursquareVenueSearchParametersBuilder paramsBuilder = new NLFoursquareVenueSearchParametersBuilder();
        paramsBuilder.latLon(40.705622, -74.013584);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.foursquare.com/v2")
                .build();
        NLFoursquareVenueSearch searchEndpoint = restAdapter.create(NLFoursquareVenueSearch.class);
        searchEndpoint.search(paramsBuilder.buildWithClientParameters(clientParameters),
                new Callback<NLFoursquareResponse<NLFoursquareVenueSearchResponse>>() {
                    @Override
                    public void success(NLFoursquareResponse<NLFoursquareVenueSearchResponse> foursquareResponse,
                                        Response response) {
                        StringBuilder sb = new StringBuilder();
                        for (NLFoursquareVenue venue : foursquareResponse.response.venues) {
                            sb.append(venue.name).append("\n");
                        }
                        outputView.setText("SUCCESS: " + sb.toString());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        outputView.setText("ERROR: " + retrofitError.getResponse().getUrl());
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
