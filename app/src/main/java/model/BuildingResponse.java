package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 27/03/2018.
 */

public class BuildingResponse {
    int size;
    ArrayList<Building> buildings = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
}
