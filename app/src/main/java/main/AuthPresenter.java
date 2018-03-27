package main;

import model.User;

/**
 * Created by gcalori on 27/03/2018.
 */

public interface AuthPresenter {
    void getCurrentUser(String token);
    void logout();
}
