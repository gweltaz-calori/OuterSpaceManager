package main;

import android.util.Log;

import model.FleetResponse;
import model.ShipResponse;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

import static android.content.ContentValues.TAG;

/**
 * Created by gcalori on 27/03/2018.
 */

public abstract class AuthPresenterImpl implements AuthPresenter {

    @Override
    public void getCurrentUser(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<User> call = apiService.getUser(token);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.code() == 200) {
                    User user = response.body();
                    getAuthView().onUserLoaded(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public void getUserFleet(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<FleetResponse> call = apiService.getFleet(token);

        call.enqueue(new Callback<FleetResponse>() {
            @Override
            public void onResponse(Call<FleetResponse> call, Response<FleetResponse> response) {
                if(response.isSuccessful()) {
                    getAuthView().onFleet(response.body().getShips());
                }
            }

            @Override
            public void onFailure(Call<FleetResponse> call, Throwable t) {

            }
        });
    }



    @Override
    public void logout() {
        this.getAuthView().logout();
    }

    protected abstract AuthView getAuthView();
}
