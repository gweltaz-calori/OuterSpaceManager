package main.Leaderboard;

import java.util.ArrayList;
import java.util.List;

import main.AuthView;
import model.AttackResponse;
import model.LeaderboardUser;
import model.ShipAmount;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface LeaderboardView extends AuthView{
    void onLeaderboardUsers(ArrayList<LeaderboardUser> users);
    void onAttacked(AttackResponse response);
    void onNavigateToAttackChoice(String username, List<ShipAmount> fleet);
}
