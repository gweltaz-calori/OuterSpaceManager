package main.Research;

import model.Building;

/**
 * Created by gcalori on 11/06/2018.
 */

public interface ResearchPresenter {
    void getResearch(String token);
    void showDetailResearch(Building building);
}
