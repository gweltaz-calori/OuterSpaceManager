package main.ResearchDetail;

import java.util.ArrayList;

import model.Building;

/**
 * Created by gcalori on 11/06/2018.
 */

public interface ResearchDetailView {
    void showBuildChoiceDialog(Building building);
    void onResearchCreated(String name);
}
