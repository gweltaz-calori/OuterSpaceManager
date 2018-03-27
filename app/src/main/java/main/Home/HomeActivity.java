package main.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gcalori.outerspacemanager.R;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.App.AppActivity;
import main.SharedPreferencesActivity;
import main.SignIn.SignInActivity;
import main.SignUp.SignUpPresenterImpl;
import main.SignUp.SignUpView;
import main.SignUp.SignupActivity;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

public class HomeActivity extends SharedPreferencesActivity implements HomeView{

    private HomePresenterImpl presenter;

    @BindView(R.id.goToSignInButton)
    Button mGoToSignInButton;

    @BindView(R.id.goToSignUpButton)
    Button mGoToSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        presenter = new HomePresenterImpl(this);

        if(userLogged()) {
            presenter.goToApp();
        }

        mGoToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToSignIn();
            }
        });

        mGoToSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToSignUp();
            }
        });
    }

    boolean userLogged() {
        return getAccessTokenFromPref() != null;
    }

    @Override
    public void navigateToSignUp() {
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToSignIn() {
        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToApp() {
        Intent intent = new Intent(getApplicationContext(), AppActivity.class);
        startActivity(intent);
    }
}
