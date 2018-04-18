package main.BuildingListContent;

import model.Building;
import model.BuildingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;

/**
 * Created by gcalori on 26/03/2018.
 */

public class BuildingListContentPresenterImpl implements BuildingListContentPresenter {

    private BuildingListContentView view;

    public BuildingListContentView getView() {
        return view;
    }

    BuildingListContentPresenterImpl(BuildingListContentView view) {
        this.view = view;
    }

    @Override
    public void showDetailFragment(Building building) {
        view.showDetailFragment(building);
    }
}
