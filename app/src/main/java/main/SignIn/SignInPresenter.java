package main.SignIn;

import services.SignInRequestBody;
import services.SignUpRequestBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface SignInPresenter {

    void signIn(SignInRequestBody body);

}
