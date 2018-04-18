package services;

/**
 * Created by gcalori on 18/04/2018.
 */

public class ShipRequestBody {
    Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public ShipRequestBody(Long amount) {
        this.amount = amount;
    }
}
