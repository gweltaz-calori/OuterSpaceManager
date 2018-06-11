package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 11/06/2018.
 */

public class Report {
    ArrayList<ShipAmount> attackerFleet;
    BattleFleet attackerFleetAfterBattle;
    BattleFleet defenderFleetAfterBattle;
    Long date;
    Long dateInv;
    String from;
    Double gasWon;
    Double mineralsWon;
    String to;
    String type;

    public ArrayList<ShipAmount> getAttackerFleet() {
        return attackerFleet;
    }

    public BattleFleet getAttackerFleetAfterBattle() {
        return attackerFleetAfterBattle;
    }

    public BattleFleet getDefenderFleetAfterBattle() {
        return defenderFleetAfterBattle;
    }

    public Long getDate() {
        return date;
    }

    public Long getDateInv() {
        return dateInv;
    }

    public String getFrom() {
        return from;
    }

    public Double getGasWon() {
        return gasWon;
    }

    public Double getMineralsWon() {
        return mineralsWon;
    }

    public String getTo() {
        return to;
    }

    public String getType() {
        return type;
    }
}
