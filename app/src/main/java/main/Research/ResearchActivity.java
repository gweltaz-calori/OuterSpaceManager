package main.Research;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.BuildingListItems.BuildingListAdapter;
import main.OnBuildingClickListener;
import main.ResearchDetail.ResearchDetailActivity;
import main.SharedPreferencesActivity;
import model.Building;

public class ResearchActivity extends SharedPreferencesActivity implements ResearchView {


    @BindView(R.id.researchRecyclerView)
    RecyclerView mBuildingsRecyclerView;

    RecyclerView.LayoutManager mBuildingsLayoutManager;
    ResearchPresenterImpl presenter;
    BuildingListAdapter mBuildingsAdapter;
    BuildingListContentActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        ButterKnife.bind(this);

        presenter = new ResearchPresenterImpl(this);

        mBuildingsLayoutManager = new LinearLayoutManager(this);
        mBuildingsRecyclerView.setLayoutManager(mBuildingsLayoutManager);
        mBuildingsAdapter = new BuildingListAdapter(this);
        mBuildingsRecyclerView.setAdapter(mBuildingsAdapter);

        presenter.getResearch(getAccessTokenFromPref());

        mBuildingsAdapter.setOnBuildingClickListener(new OnBuildingClickListener() {
            @Override
            public void onClick(Building building) {
                presenter.showDetailResearch(building);
            }
        });

    }

    @Override
    public void onSearches(ArrayList<Building> searches) {
        mBuildingsAdapter.addAllBuildings(searches);
    }

    @Override
    public void onShowingDetailResearch(Building building) {
        Intent intent = new Intent(this, ResearchDetailActivity.class);
        intent.putExtra("building",building);
        intent.putExtra("user",getIntent().getExtras().getSerializable("user"));
        startActivity(intent);
    }
}
