package main.BuildingListDetail;

import java.util.ArrayList;

import model.Building;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface BuildingDetailView {
    void showBuildChoiceDialog(Building building);
    void onBuildingCreated(String name);
}
