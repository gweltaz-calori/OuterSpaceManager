package main.ResearchDetail;

import model.Building;

/**
 * Created by gcalori on 11/06/2018.
 */

public interface ResearchDetailPresenter {
    void showBuildChoiceDialog(Building building);
    void createResearch(String token,Building building);
}
