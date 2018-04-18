package main.BuildingListContent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.gcalori.outerspacemanager.R;

import main.BuildingDetail.BuildingDetailActivity;
import main.BuildingListDetail.BuildingDetailFragment;
import main.SharedPreferencesActivity;
import model.Building;

public class BuildingListContentActivity extends SharedPreferencesActivity implements BuildingListContentView {

    private BuildingListContentPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_list);
        presenter = new BuildingListContentPresenterImpl(this);
    }


    @Override
    public void showDetailFragment(Building building) {

        View fragment = findViewById(R.id.buildingDetailFragment);
        if(fragment == null) {
            Intent intent = new Intent(this, BuildingDetailActivity.class);
            intent.putExtra("building",building);
            intent.putExtra("user",getIntent().getExtras().getSerializable("user"));
            startActivity(intent);
        }
        else {
            BuildingDetailFragment newFragment = BuildingDetailFragment.newInstance(building);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.buildingDetailFragment, newFragment);
            transaction.commit();
        }


    }
}
