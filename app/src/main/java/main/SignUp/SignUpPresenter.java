package main.SignUp;

import services.SignUpRequestBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface SignUpPresenter {

    void signUp(SignUpRequestBody body);
    void navigateToApp();
}
