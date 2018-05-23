package main.Leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.helper.ItemTouchHelper;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.AttackChoice.AttackChoiceActivity;
import main.SharedPreferencesActivity;
import main.SwipeToDeleteCallback;
import model.AttackResponse;
import model.LeaderboardUser;
import model.ShipAmount;
import model.User;

/**
 * Created by gcalori on 23/05/2018.
 */

public class LeaderboardActivity extends SharedPreferencesActivity implements LeaderboardView {

    private static final int ATTACK_REQUEST_CODE = 1;

    private LeaderboardPresenter presenter;
    private ArrayList<ShipAmount> fleet;

    @BindView(R.id.leaderboardRecyclerView)
    RecyclerView mLeaderboardRecyclerView;

    RecyclerView.LayoutManager mLeaderboardLayoutManager;
    LeaderboardListAdapter mLeaderboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        ButterKnife.bind(this);

        presenter = new LeaderboardPresenterImpl(this);

        presenter.getUserFleet(getAccessTokenFromPref());

        mLeaderboardLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLeaderboardRecyclerView.setLayoutManager(mLeaderboardLayoutManager);
        mLeaderboardAdapter = new LeaderboardListAdapter(getApplicationContext());
        mLeaderboardRecyclerView.setAdapter(mLeaderboardAdapter);

        SwipeToDeleteCallback handler = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                LeaderboardUser user = mLeaderboardAdapter.getUserAtPosition(viewHolder.getAdapterPosition());
                presenter.navigateToAttackChoice(user.getUsername(),fleet);
                //presenter.attack(user.getUsername(),getAccessTokenFromPref());
            }

            @Override
            public boolean onMove(@Nullable RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder target) {
                return super.onMove(recyclerView, viewHolder, target);
            }

        };

        ItemTouchHelper helper = new ItemTouchHelper(handler);
        helper.attachToRecyclerView(mLeaderboardRecyclerView);

    }


    @Override
    public void onLeaderboardUsers(ArrayList<LeaderboardUser> users) {
        mLeaderboardAdapter.addAllUsers(users);
    }

    @Override
    public void onAttacked(AttackResponse response) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ATTACK_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
               System.out.println("RESULT");
            }
        }
    }

    @Override
    public void onNavigateToAttackChoice(String username, List<ShipAmount> fleet) {
        Intent intent = new Intent(LeaderboardActivity.this, AttackChoiceActivity.class);
        startActivityForResult(intent,ATTACK_REQUEST_CODE);
    }

    @Override
    public void onUserLoaded(User user) {

    }

    @Override
    public void onFleet(ArrayList<ShipAmount> fleet) {
        this.fleet = fleet;
        presenter.getLeaderboardUsers(getAccessTokenFromPref());
    }

    @Override
    public void logout() {

    }
}
