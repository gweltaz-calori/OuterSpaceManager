package model;

import java.io.Serializable;

/**
 * Created by gcalori on 23/05/2018.
 */

public class LeaderboardUser implements Serializable {

    private Double points;
    private String username;

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
