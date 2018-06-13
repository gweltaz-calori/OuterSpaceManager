package main.Report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.SharedPreferencesActivity;
import model.Report;
import model.Ship;
import model.ShipAmount;
import model.User;

/**
 * Created by gcalori on 23/05/2018.
 */

public class ReportActivity extends SharedPreferencesActivity implements ReportView {

    private ReportPresenterImpl presenter;

    @BindView(R.id.reportRecyclerView)
    RecyclerView mFleetRecyclerView;

    RecyclerView.LayoutManager mFleetLayoutManager;
    ReportAdapter mFleetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        ButterKnife.bind(this);

        presenter = new ReportPresenterImpl(this);

        mFleetLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFleetRecyclerView.setLayoutManager(mFleetLayoutManager);
        mFleetAdapter = new ReportAdapter(getApplicationContext());
        mFleetRecyclerView.setAdapter(mFleetAdapter);

        presenter.getReports(getAccessTokenFromPref());
    }


    @Override
    public void onUserLoaded(User user) {

    }

    @Override
    public void onFleet(ArrayList<ShipAmount> fleet) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void onReports(ArrayList<Report> reports) {
        Log.d("reports", "onReports: "+reports);
        mFleetAdapter.addAllReports(reports);
    }
}
