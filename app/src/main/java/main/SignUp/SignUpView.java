package main.SignUp;

import services.SignUpRequestBody;
import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface SignUpView {
    void onSignedUp(SignUpResponseBody body);
    void onSignedUpError();
    void navigateToApp();
}
