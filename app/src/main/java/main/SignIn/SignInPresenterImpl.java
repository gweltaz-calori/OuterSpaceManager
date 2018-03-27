package main.SignIn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.SignInRequestBody;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public class SignInPresenterImpl implements SignInPresenter {

    private SignInView view;

    public SignInView getView() {
        return view;
    }

    SignInPresenterImpl(SignInView view) {
        this.view = view;
    }


    @Override
    public void signIn(SignInRequestBody body) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<SignUpResponseBody> call = apiService.signIn(body);

        call.enqueue(new Callback<SignUpResponseBody>() {
            @Override
            public void onResponse(Call<SignUpResponseBody> call, Response<SignUpResponseBody> response) {
                if(response.code() == 200) {
                    view.onSignedIn(response.body());
                }
                else {
                    view.onSignedInError();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponseBody> call, Throwable t) {
                view.onSignedInError();
            }
        });
    }
}
