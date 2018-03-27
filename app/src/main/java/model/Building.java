package model;

/**
 * Created by gcalori on 27/03/2018.
 */

public class Building {
    Long level;
    Long amountOfEffectByLevel;
    Long amountOfEffectLevel0;
    Long buildingId;
    boolean building;
    String effect;
    Long gasCostByLevel;
    Long gasCostLevel0;
    String imageUrl;
    Long mineralCostByLevel;
    Long mineralCostLevel0;
    String name;
    Long timeToBuildByLevel;
    Long timeToBuildLevel0;

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getAmountOfEffectByLevel() {
        return amountOfEffectByLevel;
    }

    public void setAmountOfEffectByLevel(Long amountOfEffectByLevel) {
        this.amountOfEffectByLevel = amountOfEffectByLevel;
    }

    public Long getAmountOfEffectLevel0() {
        return amountOfEffectLevel0;
    }

    public void setAmountOfEffectLevel0(Long amountOfEffectLevel0) {
        this.amountOfEffectLevel0 = amountOfEffectLevel0;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public boolean isBuilding() {
        return building;
    }

    public void setBuilding(boolean building) {
        this.building = building;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Long getGasCostByLevel() {
        return gasCostByLevel;
    }

    public void setGasCostByLevel(Long gasCostByLevel) {
        this.gasCostByLevel = gasCostByLevel;
    }

    public Long getGasCostLevel0() {
        return gasCostLevel0;
    }

    public void setGasCostLevel0(Long gasCostLevel0) {
        this.gasCostLevel0 = gasCostLevel0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getMineralCostByLevel() {
        return mineralCostByLevel;
    }

    public void setMineralCostByLevel(Long mineralCostByLevel) {
        this.mineralCostByLevel = mineralCostByLevel;
    }

    public Long getMineralCostLevel0() {
        return mineralCostLevel0;
    }

    public void setMineralCostLevel0(Long mineralCostLevel0) {
        this.mineralCostLevel0 = mineralCostLevel0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimeToBuildByLevel() {
        return timeToBuildByLevel;
    }

    public void setTimeToBuildByLevel(Long timeToBuildByLevel) {
        this.timeToBuildByLevel = timeToBuildByLevel;
    }

    public Long getTimeToBuildLevel0() {
        return timeToBuildLevel0;
    }

    public void setTimeToBuildLevel0(Long timeToBuildLevel0) {
        this.timeToBuildLevel0 = timeToBuildLevel0;
    }

    @Override
    public String toString() {
        return "Building{" +
                "level=" + level +
                ", amountOfEffectByLevel=" + amountOfEffectByLevel +
                ", amountOfEffectLevel0=" + amountOfEffectLevel0 +
                ", buildingId=" + buildingId +
                ", building=" + building +
                ", effect='" + effect + '\'' +
                ", gasCostByLevel=" + gasCostByLevel +
                ", gasCostLevel0=" + gasCostLevel0 +
                ", imageUrl='" + imageUrl + '\'' +
                ", mineralCostByLevel=" + mineralCostByLevel +
                ", mineralCostLevel0=" + mineralCostLevel0 +
                ", name='" + name + '\'' +
                ", timeToBuildByLevel=" + timeToBuildByLevel +
                ", timeToBuildLevel0=" + timeToBuildLevel0 +
                '}';
    }
}
