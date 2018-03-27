package model;

/**
 * Created by gcalori on 26/03/2018.
 */

public class User {
    private float gas;
    private Long gasModifier;
    private float minerals;
    private Long mineralsModifier;
    private Long points;
    private String username;


    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public Long getGasModifier() {
        return gasModifier;
    }

    public void setGasModifier(Long gasModifier) {
        this.gasModifier = gasModifier;
    }

    public float getMinerals() {
        return minerals;
    }

    public void setMinerals(float minerals) {
        this.minerals = minerals;
    }

    public Long getMineralsModifier() {
        return mineralsModifier;
    }

    public void setMineralsModifier(Long mineralsModifier) {
        this.mineralsModifier = mineralsModifier;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "gas=" + gas +
                ", gasModifier=" + gasModifier +
                ", minerals=" + minerals +
                ", mineralsModifier=" + mineralsModifier +
                ", points=" + points +
                ", username='" + username + '\'' +
                '}';
    }
}
