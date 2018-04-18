package model;

import java.io.Serializable;

/**
 * Created by gcalori on 27/03/2018.
 */

public class Ship implements Serializable {
    Long gasCost;
    Long life;
    long maxAttack;
    long minAttack;
    long mineralCost;
    String name;
    Long shipId;
    Long shield;
    Long spatioportLevelNeeded;
    Long speed;
    Long timeToBuild;

    public Long getGasCost() {
        return gasCost;
    }

    public void setGasCost(Long gasCost) {
        this.gasCost = gasCost;
    }

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
        this.life = life;
    }

    public long getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(long maxAttack) {
        this.maxAttack = maxAttack;
    }

    public long getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(long minAttack) {
        this.minAttack = minAttack;
    }

    public long getMineralCost() {
        return mineralCost;
    }

    public void setMineralCost(long mineralCost) {
        this.mineralCost = mineralCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getShield() {
        return shield;
    }

    public void setShield(Long shield) {
        this.shield = shield;
    }

    public Long getSpatioportLevelNeeded() {
        return spatioportLevelNeeded;
    }

    public void setSpatioportLevelNeeded(Long spatioportLevelNeeded) {
        this.spatioportLevelNeeded = spatioportLevelNeeded;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public Long getTimeToBuild() {
        return timeToBuild;
    }

    public void setTimeToBuild(Long timeToBuild) {
        this.timeToBuild = timeToBuild;
    }
}
