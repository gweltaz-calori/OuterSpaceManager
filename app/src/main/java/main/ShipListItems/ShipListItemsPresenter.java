package main.ShipListItems;

import model.Ship;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface ShipListItemsPresenter {

    void getShips(String token);
    void showCreateShipDialog(Ship ship);
    void createShip(String token,Ship ship,int amount);
}
