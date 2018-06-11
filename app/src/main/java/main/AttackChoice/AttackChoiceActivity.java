package main.AttackChoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.SharedPreferencesActivity;
import model.Ship;
import model.ShipAmount;
import model.User;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackChoiceActivity extends SharedPreferencesActivity implements AttackChoiceView {

    private AttackChoicePresenterImpl presenter;

    @BindView(R.id.fleetChoiceRecyclerView)
    RecyclerView mFleetRecyclerView;

    @BindView(R.id.attackButton)
    Button mAttackButton;

    RecyclerView.LayoutManager mFleetLayoutManager;
    AttackChoiceAdapter mFleetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_choice);
        ButterKnife.bind(this);

        presenter = new AttackChoicePresenterImpl(this);

        mFleetLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFleetRecyclerView.setLayoutManager(mFleetLayoutManager);
        mFleetAdapter = new AttackChoiceAdapter(getApplicationContext());
        mFleetRecyclerView.setAdapter(mFleetAdapter);

        presenter.getUserFleet(getAccessTokenFromPref());


        mAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAttack();
            }
        });
    }


    @Override
    public void onUserLoaded(User user) {

    }

    @Override
    public void onFleet(ArrayList<ShipAmount> fleet) {
        mFleetAdapter.addAllShips(fleet);
    }

    @Override
    public void logout() {

    }


    @Override
    public void onAttack() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("ships",mFleetAdapter.getShips());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
