package main.App;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.Fleet.FleetActivity;
import main.Home.HomeActivity;
import main.Leaderboard.LeaderboardActivity;
import main.SharedPreferencesActivity;
import main.ShipListContent.ShipListContentActivity;
import model.ShipAmount;
import model.User;

public class AppActivity extends SharedPreferencesActivity implements AppView {

    @BindView(R.id.pointsTextView)
    TextView mPointsTextView;

    @BindView(R.id.userGas)
    TextView mGas;

    @BindView(R.id.userMinerals)
    TextView mMinerals;

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    @BindView(R.id.logoutButton)
    Button mLogoutButton;

    @BindView(R.id.goToBuildingslButton)
    Button mBuildingsButton;

    @BindView(R.id.goToFlotteButton)
    Button mShipsButton;

    @BindView(R.id.goToSpatialButton)
    Button mFleetButton;

    @BindView(R.id.goToUsersButton)
    Button mUsersLeaderboard;

    AppPresenterImpl presenter;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setTitle("Manager");
        ButterKnife.bind(this);
        presenter = new AppPresenterImpl(this);
        presenter.getCurrentUser(getAccessTokenFromPref());

        mBuildingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToBuilding();
            }
        });

        mShipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToFleet();
            }
        });

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logout();
            }
        });

        mFleetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToShips();
            }
        });

        mUsersLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToLeaderboard();
            }
        });
    }

    @Override
    public void onUserLoaded(User user) {
        this.user = user;
        mPointsTextView.setText(user.getPoints().toString()+" pts");
        mGas.setText("Gas : "+String.valueOf(user.getGas()));
        mMinerals.setText("Minerals : "+String.valueOf(user.getMinerals()));
        mUsernameTextView.setText(user.getUsername());
    }

    @Override
    public void onFleet(ArrayList<ShipAmount> fleet) {

    }

    @Override
    public void navigateToBuilding() {
        Intent intent = new Intent(getApplicationContext(), BuildingListContentActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);

    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToShips() {
        Intent intent = new Intent(getApplicationContext(), ShipListContentActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToFleet() {
        Intent intent = new Intent(getApplicationContext(), FleetActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToLeaderboard() {
        Intent intent = new Intent(getApplicationContext(), LeaderboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void logout() {
        clearToken();
        presenter.navigateToHome();
    }
}
