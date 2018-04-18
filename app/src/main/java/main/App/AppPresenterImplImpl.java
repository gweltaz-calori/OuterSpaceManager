package main.App;

import main.AuthPresenter;
import main.AuthPresenterImpl;
import main.AuthView;

/**
 * Created by gcalori on 26/03/2018.
 */

class AppPresenterImpl extends AuthPresenterImpl implements AppPresenter {

    private AppView view;

    AppPresenterImpl(AppView view) {
        this.view = view;
    }

    @Override
    public void navigateToBuilding() {
        this.view.navigateToBuilding();
    }

    @Override
    public void navigateToHome() {
        this.view.navigateToHome();
    }

    @Override
    public void navigateToShips() {
        view.navigateToShips();
    }

    @Override
    public void navigateToFleet() {
        this.view.navigateToFleet();
    }

    @Override
    protected AuthView getAuthView() {
        return view;
    }
}
