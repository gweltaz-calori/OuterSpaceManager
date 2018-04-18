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



        mBuildingsLayoutManager = new LinearLayoutManager(getContext());
        mBuildingsRecyclerView.setLayoutManager(mBuildingsLayoutManager);
        mBuildingsAdapter = new BuildingListAdapter(getContext());
        mBuildingsRecyclerView.setAdapter(mBuildingsAdapter);

        mBuildingsAdapter.setOnBuildingClickListener(new OnBuildingClickListener() {
            @Override
            public void onClick(Building building) {
                activity.showDetailFragment(building);

            }
        });

        return view;
    }



    @Override
    public void onBuildings(ArrayList<Building> buildings) {
        mBuildingsAdapter.addAllBuildings(buildings);
    }


}
