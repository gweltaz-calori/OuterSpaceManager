package main.Building;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.OnBuildingClickListener;
import main.SharedPreferencesActivity;
import model.Building;
import model.User;

public class BuildingActivity extends SharedPreferencesActivity implements BuildingView{

    @BindView(R.id.buildingRecyclerView)
    RecyclerView mBuildingsRecyclerView;

    RecyclerView.LayoutManager mBuildingsLayoutManager;
    BuildingPresenterImpl presenter;
    BuildingListAdapter mBuildingsAdapter;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);
        setTitle("Buildings");
        ButterKnife.bind(this);
        presenter = new BuildingPresenterImpl(this);
        presenter.getBuildings(getAccessTokenFromPref());

        user = (User) getIntent().getSerializableExtra("user");

        mBuildingsLayoutManager = new LinearLayoutManager(this);
        mBuildingsRecyclerView.setLayoutManager(mBuildingsLayoutManager);
        mBuildingsAdapter = new BuildingListAdapter(getApplicationContext());
        mBuildingsRecyclerView.setAdapter(mBuildingsAdapter);

        mBuildingsAdapter.setOnBuildingClickListener(new OnBuildingClickListener() {
            @Override
            public void onClick(Building building) {
                presenter.showBuildChoiceDialog(building);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBuildings(ArrayList<Building> buildings) {
        mBuildingsAdapter.addAllBuildings(buildings);
    }

    @Override
    public void showBuildChoiceDialog(final Building building) {

        Float userGas = user.getGas()* user.getGasModifier();
        Float userminerals = user.getMinerals()* user.getMineralsModifier();

        Long minBuildingGas = building.getGasCostLevel0() + building.getGasCostByLevel() * building.getLevel();
        Long minBuildingMineral = building.getMineralCostLevel0() + building.getMineralCostByLevel() * building.getLevel();


        if(userGas < minBuildingGas || userminerals < minBuildingMineral)
            return;


        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Construction")
                .setMessage("Voulez vous construire une batiment")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.createBuilding(getAccessTokenFromPref(),building);
                    }
                })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onBuildingCreated(String name) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.buildingLayout),
                "Building "+name, Snackbar.LENGTH_SHORT);
        mySnackbar.show();

    }


}
