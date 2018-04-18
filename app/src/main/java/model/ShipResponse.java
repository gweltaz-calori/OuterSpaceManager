package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 27/03/2018.
 */

public class ShipResponse {
    int size;
    ArrayList<Ship> ships = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setBuildings(ArrayList<Ship> ships) {
        this.ships = ships;
    }
}
