package main.App;

import main.AuthView;
import model.User;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface AppView extends AuthView {
    void navigateToBuilding();
    void navigateToHome();
    void navigateToShips();
    void navigateToFleet();
}
