package main.ShipListItems;

import java.util.ArrayList;

import model.Building;
import model.Ship;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface ShipListItemsView {
    void onShips(ArrayList<Ship> ships);
    void showCreateShipDialog(Ship ship);
    void onShipCreated(Ship ship);
}
