package main.ResearchDetail;

import android.util.Log;

import main.Research.ResearchPresenter;
import main.Research.ResearchView;
import model.Building;
import model.BuildingResponse;
import model.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

import static android.content.ContentValues.TAG;

/**
 * Created by gcalori on 11/06/2018.
 */

public class ResearchDetailPresenterImpl implements ResearchDetailPresenter {


    private ResearchDetailView view;

    public ResearchDetailView getView() {
        return view;
    }

    ResearchDetailPresenterImpl(ResearchDetailView view) {
        this.view = view;
    }


    @Override
    public void showBuildChoiceDialog(Building building) {
        view.showBuildChoiceDialog(building);
    }

    @Override
    public void createResearch(String token, final Building building) {

        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<BuildingResponse> call = apiService.createSearch(building.getSearchId(),token);

        call.enqueue(new Callback<BuildingResponse>() {
            @Override
            public void onResponse(Call<BuildingResponse> call, Response<BuildingResponse> response) {

                if(response.isSuccessful()) {
                    view.onResearchCreated(building.getName());
                }
                else  {
                    view.onResearchCreated("No enough resources");
                }
            }

            @Override
            public void onFailure(Call<BuildingResponse> call, Throwable t) {
                Log.d("bodyFail", "onResponse: "+t);
            }
        });
    }
}
