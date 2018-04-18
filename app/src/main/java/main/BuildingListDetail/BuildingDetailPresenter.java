package main.BuildingListDetail;

import model.Building;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface BuildingDetailPresenter {


    void showBuildChoiceDialog(Building building);
    void createBuilding(String token, Building building);
}
