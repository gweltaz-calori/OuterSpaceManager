package main.SignIn;

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
import main.SharedPreferencesActivity;
import services.SignInRequestBody;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

public class SignInActivity extends SharedPreferencesActivity implements SignInView {

    private SignInPresenterImpl presenter;

    @BindView(R.id.signInButton)
    Button mSignUpButton;

    @BindView(R.id.passworSignInTextfield)
    EditText mPasswordEditText;

    @BindView(R.id.usernameSignInTextfield)
    EditText mUsernameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        presenter = new SignInPresenterImpl(this);


        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInRequestBody body = new SignInRequestBody(mPasswordEditText.getText().toString(),mUsernameEditText.getText().toString());
                presenter.signIn(body);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onSignedIn(SignUpResponseBody body) {
        System.out.println("Signed in :)");
        storeAccessToken(body.getToken());
    }

    @Override
    public void onSignedInError() {
        Toast.makeText(getApplicationContext(),"An error occured",Toast.LENGTH_SHORT).show();
    }

}
