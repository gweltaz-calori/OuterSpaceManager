package main.Report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import main.OnBuildingClickListener;
import main.OnShipClickListener;
import model.Building;
import model.Report;
import model.Ship;
import model.ShipAmount;

/**
 * Created by gcalori on 11/06/2018.
 */

public class ReportAdapter extends RecyclerView.Adapter<main.Report.ReportAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Report> reports = new ArrayList<>();


    public ReportAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public main.Report.ReportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_report, parent, false);

        return new main.Report.ReportAdapter.ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(main.Report.ReportAdapter.ViewHolder holder, final int position) {
        Report report = reports.get(position);
        holder.from.setText("From : " +report.getFrom());
        holder.gasWon.setText("Gas  :"+report.getGasWon().toString());
        holder.type.setText("Type :" +report.getType());
    }

    public void addReport(Report report) {
        reports.add(report);
        notifyItemInserted(reports.size() - 1);
    }

    public void addAllReports(ArrayList<Report> newReports) {
        for(Report report:newReports) {
            addReport(report);
        }
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView from;
        public TextView gasWon;
        public TextView type;

        public ViewHolder(View itemView) {
            super(itemView);
            from = (TextView) itemView.findViewById(R.id.reportFrom);
            gasWon = (TextView) itemView.findViewById(R.id.reportGasWon);
            type = (TextView) itemView.findViewById(R.id.reportType);
        }
    }


}

