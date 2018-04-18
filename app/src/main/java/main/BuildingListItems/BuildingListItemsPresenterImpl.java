package main.BuildingListItems;

import model.Building;
import model.BuildingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

/**
 * Created by gcalori on 26/03/2018.
 */

public class BuildingListItemsPresenterImpl implements BuildingListItemsPresenter {

    private BuildingListItemsView view;

    public BuildingListItemsView getView() {
        return view;
    }

    BuildingListItemsPresenterImpl(BuildingListItemsView view) {
        this.view = view;
    }


    @Override
    public void getBuildings(String token) {

        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<BuildingResponse> call = apiService.getBuildings(token);

        call.enqueue(new Callback<BuildingResponse>() {
            @Override
            public void onResponse(Call<BuildingResponse> call, Response<BuildingResponse> response) {
                if(response.isSuccessful()) {
                    view.onBuildings(response.body().getBuildings());
                }
            }

            @Override
            public void onFailure(Call<BuildingResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void showBuildChoiceDialog(Building building) {
        view.showBuildChoiceDialog(building);
    }

    @Override
    public void createBuilding(String token, final Building building) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<BuildingResponse> call = apiService.createBuilding(building.getBuildingId(),token);

        call.enqueue(new Callback<BuildingResponse>() {
            @Override
            public void onResponse(Call<BuildingResponse> call, Response<BuildingResponse> response) {
                if(response.isSuccessful()) {
                    view.onBuildingCreated(building.getName());
                }
            }

            @Override
            public void onFailure(Call<BuildingResponse> call, Throwable t) {

            }
        });
    }
}
