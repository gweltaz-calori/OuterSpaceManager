package main.Research;

import java.util.ArrayList;

import model.Building;

/**
 * Created by gcalori on 11/06/2018.
 */

public interface ResearchView {

    void onSearches(ArrayList<Building> searches);
    void onShowingDetailResearch(Building building);
}
