package model;

import java.util.ArrayList;

/**
 * Created by gcalori on 11/06/2018.
 */

public class SearchResponse {

    int size;
    ArrayList<Building> searches = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Building> getSearches() {
        return searches;
    }

    public void setSearches(ArrayList<Building> searches) {
        this.searches = searches;
    }
}
