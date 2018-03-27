package main.Home;

import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface HomeView {
    void navigateToSignUp();
    void navigateToSignIn();
    void navigateToApp();
}
