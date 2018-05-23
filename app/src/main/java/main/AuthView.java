package main;

import java.util.ArrayList;

import model.ShipAmount;
import model.User;

/**
 * Created by gcalori on 27/03/2018.
 */

public interface AuthView {
    void onUserLoaded(User user);
    void onFleet(ArrayList<ShipAmount> fleet);
    void logout();
}
