package main.BuildingListItems;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.OnBuildingClickListener;
import model.Building;
import model.User;


public class BuildingListFragment extends Fragment implements BuildingListItemsView {

    @BindView(R.id.buildingRecyclerView)
    RecyclerView mBuildingsRecyclerView;

    RecyclerView.LayoutManager mBuildingsLayoutManager;
    BuildingListItemsPresenterImpl presenter;
    BuildingListAdapter mBuildingsAdapter;
    BuildingListContentActivity activity;

    User user;


    public BuildingListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building_list, container, false);
        activity = (BuildingListContentActivity) getActivity();

        ButterKnife.bind(this,view);
        presenter = new BuildingListItemsPresenterImpl(this);
        presenter.getBuildings(activity.getAccessTokenFromPref());

        user = (User) getActivity().getIntent().getSerializableExtra("user");

        mBuildingsLayoutManager = new LinearLayoutManager(getContext());
        mBuildingsRecyclerView.setLayoutManager(mBuildingsLayoutManager);
        mBuildingsAdapter = new BuildingListAdapter(getContext());
        mBuildingsRecyclerView.setAdapter(mBuildingsAdapter);

        mBuildingsAdapter.setOnBuildingClickListener(new OnBuildingClickListener() {
            @Override
            public void onClick(Building building) {
                presenter.showBuildChoiceDialog(building);

            }
        });

        return view;
    }



    @Override
    public void onBuildings(ArrayList<Building> buildings) {
        mBuildingsAdapter.addAllBuildings(buildings);
    }

    @Override
    public void showBuildChoiceDialog(final Building building) {

        activity.showDetailFragment(building);


        /*Float userGas = user.getGas()* user.getGasModifier();
        Float userminerals = user.getMinerals()* user.getMineralsModifier();

        Long minBuildingGas = building.getGasCostLevel0() + building.getGasCostByLevel() * building.getLevel();
        Long minBuildingMineral = building.getMineralCostLevel0() + building.getMineralCostByLevel() * building.getLevel();


        if(userGas < minBuildingGas || userminerals < minBuildingMineral)
            return;


        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Construction")
                .setMessage("Voulez vous construire une batiment")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.createBuilding(activity.getAccessTokenFromPref(),building);
                    }
                })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();*/
    }

    @Override
    public void onBuildingCreated(String name) {
        Snackbar mySnackbar = Snackbar.make(getView().findViewById(R.id.buildingLayout),
                "Building "+name, Snackbar.LENGTH_SHORT);
        mySnackbar.show();

    }
}
