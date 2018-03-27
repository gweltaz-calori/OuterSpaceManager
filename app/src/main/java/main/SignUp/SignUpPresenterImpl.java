package main.SignUp;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpView view;

    public SignUpView getView() {
        return view;
    }

    SignUpPresenterImpl(SignUpView view) {
        this.view = view;
    }


    @Override
    public void signUp(SignUpRequestBody body) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<SignUpResponseBody> call = apiService.signUp(body);

        call.enqueue(new Callback<SignUpResponseBody>() {
            @Override
            public void onResponse(Call<SignUpResponseBody> call, Response<SignUpResponseBody> response) {
                if(response.code() == 200) {
                    view.onSignedUp(response.body());
                }
                else {
                    view.onSignedUpError();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponseBody> call, Throwable t) {
                view.onSignedUpError();
            }
        });
    }

    @Override
    public void navigateToApp() {
        this.view.navigateToApp();
    }
}
