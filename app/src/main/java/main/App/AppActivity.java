package main.App;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.BuildingListContent.BuildingListContentActivity;
import main.Home.HomeActivity;
import main.SharedPreferencesActivity;
import model.User;

public class AppActivity extends SharedPreferencesActivity implements AppView {

    @BindView(R.id.pointsTextView)
    TextView mPointsTextView;

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    @BindView(R.id.logoutButton)
    Button mLogoutButton;

    @BindView(R.id.goToBuildingslButton)
    Button mBuildingsButton;

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

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logout();
            }
        });
    }

    @Override
    public void onUserLoaded(User user) {
        this.user = user;
        mPointsTextView.setText(user.getPoints().toString());
        mUsernameTextView.setText(user.getUsername());
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
    public void logout() {
        clearToken();
        presenter.navigateToHome();
    }
}
