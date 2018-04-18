package main.BuildingListDetail;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.SharedPreferencesActivity;
import model.Building;
import model.User;


public class BuildingDetailFragment extends Fragment implements BuildingDetailView {

    private BuildingDetailPresenter presenter;

    @BindView(R.id.buildingDetailLevel)
    TextView mBuildingDetailLevel;

    @BindView(R.id.buildingDetailEffect)
    TextView mBuildingDetailEffect;

    @BindView(R.id.buildingDetailName)
    TextView mBuildingDetailName;

    @BindView(R.id.buildButton)
    Button mBuildButton;


    Building building;

    private SharedPreferencesActivity activity;

    User user;

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

        presenter = new BuildingDetailPresenterImpl(this);
        user = (User) getActivity().getIntent().getSerializableExtra("user");

        activity = (SharedPreferencesActivity) getActivity();

        ButterKnife.bind(this,view);

        Bundle args = getArguments();

        if(args != null) {
            building = (Building) args.getSerializable("building");

            mBuildingDetailEffect.setText(building.getEffect());
            mBuildingDetailLevel.setText(building.getLevel().toString());
            mBuildingDetailName.setText(building.getName());

            mBuildButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.showBuildChoiceDialog(building);
                }
            });
        }


        // Inflate the layout for this fragment
        return view;
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
                .show();
    }

    @Override
    public void onBuildingCreated(String name) {

        if(getActivity() == null)
            return;

        Snackbar mySnackbar = Snackbar.make(getActivity().findViewById(R.id.content),
                "Building "+name, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
