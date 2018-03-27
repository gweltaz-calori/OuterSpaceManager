package main.SignIn;

import services.SignUpResponseBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface SignInView {
    void onSignedIn(SignUpResponseBody body);
    void onSignedInError();
}
