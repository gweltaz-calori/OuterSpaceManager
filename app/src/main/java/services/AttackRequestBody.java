package services;

import java.util.ArrayList;

import model.AttackShipAmount;
import model.ShipAmount;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackRequestBody {
    private ArrayList<ShipAmount> ships;

    public ArrayList<ShipAmount> getShips() {
        return ships;
    }

    public void setShips(ArrayList<ShipAmount> ships) {
        this.ships = ships;
    }
}
