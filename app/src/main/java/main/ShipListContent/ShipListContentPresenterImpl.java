package main.ShipListContent;

import model.Building;

/**
 * Created by gcalori on 26/03/2018.
 */

public class ShipListContentPresenterImpl implements ShipListContentPresenter {

    private ShipListContentView view;

    public ShipListContentView getView() {
        return view;
    }

    ShipListContentPresenterImpl(ShipListContentView view) {
        this.view = view;
    }


}
