package main.App;

import model.User;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface AppView {
    void onUserLoaded(User user);
}
