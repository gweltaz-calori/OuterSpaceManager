package main.ResearchDetail;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.BuildingListItems.BuildingListAdapter;
import main.Research.ResearchPresenterImpl;
import main.SharedPreferencesActivity;
import model.Building;
import model.User;

/**
 * Created by gcalori on 11/06/2018.
 */

public class ResearchDetailActivity extends SharedPreferencesActivity implements ResearchDetailView
{
    ResearchDetailPresenterImpl presenter;
    Building building;
    User user;

    @BindView(R.id.researchButton)
    Button mResearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_detail);
        ButterKnife.bind(this);

        building = (Building) getIntent().getSerializableExtra("building");
        user = (User) getIntent().getSerializableExtra("user");


        presenter = new ResearchDetailPresenterImpl(this);

        mResearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showBuildChoiceDialog(building);
            }
        });

    }

    @Override
    public void showBuildChoiceDialog(final Building building) {
        if(!user.hasResources(building)) {
            return;
        }

        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Construction")
                .setMessage("Voulez vous faire une research")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.createResearch(getAccessTokenFromPref(),building);
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
    public void onResearchCreated(String name) {

        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.content),
                "Seearching "+name, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
