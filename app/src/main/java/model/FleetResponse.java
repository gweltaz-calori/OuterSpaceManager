package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 27/03/2018.
 */

public class FleetResponse {
    int size;
    ArrayList<ShipAmount> ships = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ShipAmount> getShips() {
        return ships;
    }

    public void setBuildings(ArrayList<ShipAmount> ships) {
        this.ships = ships;
    }
}
