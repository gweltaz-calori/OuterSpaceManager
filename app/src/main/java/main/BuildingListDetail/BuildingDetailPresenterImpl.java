package main.BuildingListDetail;

import model.Building;
import model.BuildingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

/**
 * Created by gcalori on 26/03/2018.
 */

public class BuildingDetailPresenterImpl implements BuildingDetailPresenter {

    private BuildingDetailView view;

    public BuildingDetailView getView() {
        return view;
    }

    BuildingDetailPresenterImpl(BuildingDetailView view) {
        this.view = view;
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
                    view.onBuildingCreated("Searching "+building.getName());
                }
                else  {
                    view.onBuildingCreated("No enough resources");
                }
            }

            @Override
            public void onFailure(Call<BuildingResponse> call, Throwable t) {

            }
        });
    }

}
