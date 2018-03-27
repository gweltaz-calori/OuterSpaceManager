package services;

/**
 * Created by gcalori on 26/03/2018.
 */

public class SignUpResponseBody {

    public SignUpResponseBody(String token, double expires) {
        this.token = token;
        this.expires = expires;
    }

    private String token;
    private double expires;

    public double getExpires() {
        return expires;
    }

    public void setExpires(double expires) {
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SignUpResponseBody{" +
                "token='" + token + '\'' +
                ", expires=" + expires +
                '}';
    }
}
