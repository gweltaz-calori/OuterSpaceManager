package services;

import java.util.ArrayList;

import model.AttackShipAmount;
import model.ShipAmount;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackRequestBody {
    private ArrayList<AttackShipAmount> ships;

    public ArrayList<AttackShipAmount> getShips() {
        return ships;
    }

    public void setShips(ArrayList<AttackShipAmount> ships) {
        this.ships = ships;
    }
}
