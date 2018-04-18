package main.Fleet;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.SharedPreferencesActivity;
import model.ShipAmount;

public class FleetActivity extends SharedPreferencesActivity implements FleetView {

    private FleetPresenterImpl presenter;

    @BindView(R.id.fleetRecyclerView)
    RecyclerView mFleetRecyclerView;

    RecyclerView.LayoutManager mFleetLayoutManager;
    FleetAdapter mFleetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);
        ButterKnife.bind(this);
        presenter = new FleetPresenterImpl(this);

        presenter.getFleet(getAccessTokenFromPref());

        mFleetLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFleetRecyclerView.setLayoutManager(mFleetLayoutManager);
        mFleetAdapter = new FleetAdapter(getApplicationContext());
        mFleetRecyclerView.setAdapter(mFleetAdapter);


    }


    @Override
    public void onFleet(ArrayList<ShipAmount> fleet) {
        mFleetAdapter.addAllFleets(fleet);
    }
}
