package main.Building;

import java.util.ArrayList;

import model.Building;
import model.User;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface BuildingView {
    void onBuildings(ArrayList<Building> buildings);
    void showBuildChoiceDialog(Building building);
    void onBuildingCreated(String name);
}
