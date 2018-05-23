package main.Leaderboard;

import java.util.List;

import main.AuthPresenterImpl;
import main.AuthView;
import main.Fleet.FleetView;
import model.AttackResponse;
import model.FleetResponse;
import model.LeaderboardUserResponse;
import model.ShipAmount;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.AttackRequestBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public class LeaderboardPresenterImpl extends AuthPresenterImpl implements LeaderboardPresenter {

    private LeaderboardView view;

    public LeaderboardView getView() {
        return view;
    }

    LeaderboardPresenterImpl(LeaderboardView view) {
        this.view = view;
    }

    @Override
    public void getLeaderboardUsers(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<LeaderboardUserResponse> call = apiService.getLeaderboardUsers(0,10,token);

        call.enqueue(new Callback<LeaderboardUserResponse>() {
            @Override
            public void onResponse(Call<LeaderboardUserResponse> call, Response<LeaderboardUserResponse> response) {
                if(response.isSuccessful()) {
                    view.onLeaderboardUsers(response.body().getUsers());
                }
            }

            @Override
            public void onFailure(Call<LeaderboardUserResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void attack(String username, String token, AttackRequestBody body) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<AttackResponse> call = apiService.attackUser(username,body,token);

        call.enqueue(new Callback<AttackResponse>() {
            @Override
            public void onResponse(Call<AttackResponse> call, Response<AttackResponse> response) {
                if(response.isSuccessful()) {
                    view.onAttacked(response.body());
                }
            }

            @Override
            public void onFailure(Call<AttackResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void navigateToAttackChoice(String username, List<ShipAmount> fleet) {
        view.onNavigateToAttackChoice(username,fleet);
    }

    @Override
    protected AuthView getAuthView() {
        return view;
    }
}
