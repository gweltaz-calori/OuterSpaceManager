package main.Fleet;

import model.BuildingResponse;
import model.FleetResponse;
import model.Ship;
import model.ShipResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

/**
 * Created by gcalori on 26/03/2018.
 */

public class FleetPresenterImpl implements FleetPresenter {

    private FleetView view;

    public FleetView getView() {
        return view;
    }

    FleetPresenterImpl(FleetView view) {
        this.view = view;
    }



    @Override
    public void getFleet(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<FleetResponse> call = apiService.getFleet(token);

        call.enqueue(new Callback<FleetResponse>() {
            @Override
            public void onResponse(Call<FleetResponse> call, Response<FleetResponse> response) {
                if(response.isSuccessful()) {
                    view.onFleet(response.body().getShips());
                }
            }

            @Override
            public void onFailure(Call<FleetResponse> call, Throwable t) {

            }
        });
    }
}
