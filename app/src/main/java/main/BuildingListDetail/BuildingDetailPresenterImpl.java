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

}
