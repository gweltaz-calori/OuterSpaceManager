package main.Fleet;

import java.util.ArrayList;

import model.Ship;
import model.ShipAmount;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface FleetView {
    void onFleet(ArrayList<ShipAmount> fleet);
}
