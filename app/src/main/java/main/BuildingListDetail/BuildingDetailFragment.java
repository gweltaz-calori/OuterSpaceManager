package main.BuildingListDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import model.Building;


public class BuildingDetailFragment extends Fragment {

    @BindView(R.id.buildingDetailLevel)
    TextView mBuildingDetailLevel;

    @BindView(R.id.buildingDetailEffect)
    TextView mBuildingDetailEffect;

    @BindView(R.id.buildingDetailName)
    TextView mBuildingDetailName;


    Building building;

    public BuildingDetailFragment() {
        // Required empty public constructor
    }


    public static BuildingDetailFragment newInstance(Building building) {
        BuildingDetailFragment myFragment = new BuildingDetailFragment();

        Bundle args = new Bundle();
        args.putSerializable("building", building);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_building_detail, container, false);

        ButterKnife.bind(this,view);

        Bundle args = getArguments();

        if(args != null) {
            building = (Building) args.getSerializable("building");

            mBuildingDetailEffect.setText(building.getEffect());
            mBuildingDetailLevel.setText(building.getLevel().toString());
            mBuildingDetailName.setText(building.getName());

        }


        // Inflate the layout for this fragment
        return view;
    }


}
