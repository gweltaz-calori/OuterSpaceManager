package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 23/05/2018.
 */

public class LeaderboardUserResponse {
    ArrayList<LeaderboardUser> users = new ArrayList<>();

    public ArrayList<LeaderboardUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<LeaderboardUser> users) {
        this.users = users;
    }
}

