package main.Research;

import main.BuildingListItems.BuildingListItemsView;
import model.Building;
import model.BuildingResponse;
import model.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

/**
 * Created by gcalori on 11/06/2018.
 */

public class ResearchPresenterImpl implements ResearchPresenter {


    private ResearchView view;

    public ResearchView getView() {
        return view;
    }

    ResearchPresenterImpl(ResearchView view) {
        this.view = view;
    }


    @Override
    public void getResearch(String token) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Call<SearchResponse> call = apiService.getSearch(token);

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()) {
                    view.onSearches(response.body().getSearches());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void showDetailResearch(Building building) {
        view.onShowingDetailResearch(building);
    }
}
