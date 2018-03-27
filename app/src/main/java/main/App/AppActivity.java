package main.App;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gcalori.outerspacemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.SharedPreferencesActivity;
import model.User;

public class AppActivity extends SharedPreferencesActivity implements AppView {

    @BindView(R.id.pointsTextView)
    TextView mPointsTextView;

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    AppPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);
        presenter = new AppPresenterImpl(this);
        presenter.getCurrentUser(getAccessTokenFromPref());
    }

    @Override
    public void onUserLoaded(User user) {

        mPointsTextView.setText(user.getPoints().toString());
        mUsernameTextView.setText(user.getUsername());
    }
}
