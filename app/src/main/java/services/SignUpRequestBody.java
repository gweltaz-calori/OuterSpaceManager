package services;

/**
 * Created by gcalori on 26/03/2018.
 */

public class SignUpRequestBody {
    private String email;
    private String password;
    private String username;


    public SignUpRequestBody(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

}
