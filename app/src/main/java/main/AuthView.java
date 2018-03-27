package main;

import model.User;

/**
 * Created by gcalori on 27/03/2018.
 */

public interface AuthView {
    void onUserLoaded(User user);
    void logout();
}
