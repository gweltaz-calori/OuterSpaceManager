package main;

/**
 * Created by gcalori on 27/03/2018.
 */

public interface Auth {

    void storeAccessToken(String token);

    String getAccessTokenFromPref();
}
