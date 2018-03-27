package main.App;

import main.AuthPresenter;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface AppPresenter extends AuthPresenter {

    void navigateToBuilding();
    void navigateToHome();

}
