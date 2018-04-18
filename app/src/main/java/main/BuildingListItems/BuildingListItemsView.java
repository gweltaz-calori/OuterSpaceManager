package main.BuildingListItems;

import java.util.ArrayList;

import model.Building;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface BuildingListItemsView {
    void onBuildings(ArrayList<Building> buildings);
}
