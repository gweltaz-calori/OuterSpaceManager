package main.Leaderboard;

import java.util.List;

import main.AuthPresenter;
import model.ShipAmount;
import services.AttackRequestBody;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface LeaderboardPresenter extends AuthPresenter {
    void getLeaderboardUsers(String token);
    void attack(String username,  String token,AttackRequestBody body);
    void navigateToAttackChoice(String username, List<ShipAmount> fleet);
}
