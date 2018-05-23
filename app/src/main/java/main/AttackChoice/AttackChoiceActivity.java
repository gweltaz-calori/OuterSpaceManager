package main.AttackChoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackChoiceActivity extends AppCompatActivity implements AttackChoiceView {

    private AttackChoicePresenterImpl presenter;

    @BindView(R.id.fleetChoiceRecyclerView)
    RecyclerView mFleetRecyclerView;

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
    }
}
