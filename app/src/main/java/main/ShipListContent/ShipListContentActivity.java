package main.ShipListContent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.gcalori.outerspacemanager.R;

import main.BuildingDetail.BuildingDetailActivity;
import main.BuildingListDetail.BuildingDetailFragment;
import main.SharedPreferencesActivity;
import main.ShipListItems.ShipListFragment;
import model.Building;

public class ShipListContentActivity extends SharedPreferencesActivity implements ShipListContentView {

    private ShipListContentPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_list);
        presenter = new ShipListContentPresenterImpl(this);

        ShipListFragment newFragment = new ShipListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.shipListFragment, newFragment);
        transaction.commit();
    }
}
