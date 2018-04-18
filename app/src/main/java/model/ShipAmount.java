package model;

import java.io.Serializable;

/**
 * Created by gcalori on 27/03/2018.
 */

public class ShipAmount extends Ship implements Serializable {

    Long amount;

    public Long getAmount() {
        return amount;
    }

    ShipAmount() {
        super();

    }


}
