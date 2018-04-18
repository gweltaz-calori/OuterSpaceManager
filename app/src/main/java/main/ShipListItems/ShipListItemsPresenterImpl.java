package main.ShipListItems;

import model.BuildingResponse;
import model.Ship;
import model.ShipResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.ShipRequestBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public class ShipListItemsPresenterImpl implements ShipListItemsPresenter {

    private ShipListItemsView view;

    public ShipListItemsView getView() {
        return view;
    }

    ShipListItemsPresenterImpl(ShipListItemsView view) {
        this.view = view;
    }



    @Override
    public void getShips(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<ShipResponse> call = apiService.getShips(token);

        call.enqueue(new Callback<ShipResponse>() {
            @Override
            public void onResponse(Call<ShipResponse> call, Response<ShipResponse> response) {
                if(response.isSuccessful()) {
                    view.onShips(response.body().getShips());
                }
            }

            @Override
            public void onFailure(Call<ShipResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void showCreateShipDialog(Ship ship) {
        view.showCreateShipDialog(ship);
    }


    @Override
    public void createShip(String token, final Ship ship,int amount) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        final ShipRequestBody body = new ShipRequestBody((long) amount);

        Call<ShipResponse> call = apiService.createShip(ship.getShipId(),body,token);

        call.enqueue(new Callback<ShipResponse>() {
            @Override
            public void onResponse(Call<ShipResponse> call, Response<ShipResponse> response) {

                if(response.isSuccessful()) {
                    System.out.println(body.getAmount());
                    view.onShipCreated(ship);
                }
            }

            @Override
            public void onFailure(Call<ShipResponse> call, Throwable t) {

            }
        });
    }

}
