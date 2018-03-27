package main.Home;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.SignUpRequestBody;
import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeView view;

    public HomeView getView() {
        return view;
    }

    HomePresenterImpl(HomeView view) {
        this.view = view;
    }


    @Override
    public void goToSignUp() {
        this.view.navigateToSignUp();
    }

    @Override
    public void goToSignIn() {

        this.view.navigateToSignIn();
    }

    @Override
    public void goToApp() {
        this.view.navigateToApp();
    }
}
