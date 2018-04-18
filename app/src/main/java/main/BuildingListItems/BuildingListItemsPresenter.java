package main.BuildingListItems;

import model.Building;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface BuildingListItemsPresenter {

    void getBuildings(String token);
    void showBuildChoiceDialog(Building building);
    void createBuilding(String token, Building building);
}
