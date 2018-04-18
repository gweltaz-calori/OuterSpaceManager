package main.ShipListItems;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.OnBuildingClickListener;
import main.OnShipClickListener;
import main.ShipDialog;
import main.ShipListContent.ShipListContentActivity;
import model.Building;
import model.Ship;


public class ShipListFragment extends Fragment implements ShipListItemsView {

    @BindView(R.id.buildingRecyclerView)
    RecyclerView mBuildingsRecyclerView;

    RecyclerView.LayoutManager mBuildingsLayoutManager;
    ShipListItemsPresenterImpl presenter;
    ShipsListAdapter mBuildingsAdapter;
    ShipListContentActivity activity;

    ShipDialog shipDialog = new ShipDialog();


    public ShipListFragment() {
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
        activity = (ShipListContentActivity) getActivity();

        ButterKnife.bind(this,view);
        presenter = new ShipListItemsPresenterImpl(this);
        presenter.getShips(activity.getAccessTokenFromPref());


        mBuildingsLayoutManager = new LinearLayoutManager(getContext());
        mBuildingsRecyclerView.setLayoutManager(mBuildingsLayoutManager);
        mBuildingsAdapter = new ShipsListAdapter(getContext());
        mBuildingsRecyclerView.setAdapter(mBuildingsAdapter);

        mBuildingsAdapter.setOnBuildingClickListener(new OnShipClickListener() {
            @Override
            public void onClick(Ship ship) {
                presenter.showCreateShipDialog(ship);
            }
        });

        return view;
    }



    @Override
    public void onShips(ArrayList<Ship> ships) {
        mBuildingsAdapter.addAllShips(ships);
    }

    @Override
    public void showCreateShipDialog(final Ship ship) {

        shipDialog.show(getFragmentManager(), "NoticeDialogFragment");
        shipDialog.setOnPositiveClickListener(new ShipDialog.ShipDialogListener() {
            @Override
            public void onDialogPositiveClick(DialogFragment dialog) {
                presenter.createShip(activity.getAccessTokenFromPref(),ship,shipDialog.getAmount());
            }
        });

    }

    @Override
    public void onShipCreated(Ship ship) {
        if(getActivity() == null)
            return;

        Snackbar mySnackbar = Snackbar.make(getActivity().findViewById(R.id.content),
                "Building "+ship, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }



}
