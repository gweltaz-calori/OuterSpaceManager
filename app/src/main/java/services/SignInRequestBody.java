package services;

/**
 * Created by gcalori on 26/03/2018.
 */

public class SignInRequestBody {

    private String password;
    private String username;


    public SignInRequestBody( String password, String username) {
        this.password = password;
        this.username = username;
    }

}
