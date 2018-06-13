package main.Report;

import java.util.ArrayList;

import main.AuthView;
import model.Report;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface ReportView extends AuthView {
    void onReports(ArrayList<Report> reports);
}
