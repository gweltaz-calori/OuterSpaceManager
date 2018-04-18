package main.BuildingDetail;

import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListDetail.BuildingDetailFragment;
import main.SharedPreferencesActivity;
import model.Building;

public class BuildingDetailActivity extends SharedPreferencesActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_detail);
        ButterKnife.bind(this);

        Building building = (Building) getIntent().getExtras().get("building");

        setTitle(building.getName());

        BuildingDetailFragment newFragment = BuildingDetailFragment.newInstance(building);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.buildingDetailInfosFragment, newFragment);
        transaction.commit();
    }
}
