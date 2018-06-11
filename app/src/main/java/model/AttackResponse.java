package model;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackResponse {
    private String code;
    private Long attackTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(Long attackTime) {
        this.attackTime = attackTime;
    }

    @Override
    public String toString() {
        return "AttackResponse{" +
                "code='" + code + '\'' +
                ", attackTime=" + attackTime +
                '}';
    }
}
