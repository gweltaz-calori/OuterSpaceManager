package main.SignUp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gcalori.outerspacemanager.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.App.AppActivity;
import main.SharedPreferencesActivity;
import main.SignIn.SignInActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

public class SignupActivity extends SharedPreferencesActivity implements SignUpView {

    private SignUpPresenterImpl presenter;

    @BindView(R.id.signUpButton)
    Button mSignUpButton;

    @BindView(R.id.passwordSignUpTextfield)
    EditText mPasswordEditText;

    @BindView(R.id.usernameSignUpTextfield)
    EditText mUsernameEditText;

    @BindView(R.id.emailSignupTextfield)
    EditText mEmailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("Sign Up");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        presenter = new SignUpPresenterImpl(this);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpRequestBody body = new SignUpRequestBody(mEmailEditText.getText().toString(),mPasswordEditText.getText().toString(),mUsernameEditText.getText().toString());
                presenter.signUp(body);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onSignedUp(SignUpResponseBody body) {
        storeAccessToken(body.getToken());
        presenter.navigateToApp();
    }

    @Override
    public void navigateToApp() {
        Intent intent = new Intent(getApplicationContext(), AppActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSignedUpError() {
        Toast.makeText(getApplicationContext(),"An error occured",Toast.LENGTH_SHORT).show();
    }

}
