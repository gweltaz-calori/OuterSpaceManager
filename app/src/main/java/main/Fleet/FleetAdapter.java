package main.Fleet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;


import main.OnShipClickListener;
import model.Ship;
import model.ShipAmount;

/**
 * Created by gcalori on 18/04/2018.
 */

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    interface OnFleetClickListener {
        void onClick(ShipAmount ship);
    }

    private Context context;
    private ArrayList<ShipAmount> ships = new ArrayList<>();

    private ArrayList<OnFleetClickListener> listeners = new ArrayList<>();

    public FleetAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public FleetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_fleet, parent, false);

        return new FleetAdapter.ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(FleetAdapter.ViewHolder holder, final int position) {


        ShipAmount ship = ships.get(position);

        TextView name = holder.name;
        name.setText(ship.getName());

        TextView amount = holder.amount;
        amount.setText("Amount : "+ship.getAmount().toString());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(OnFleetClickListener listener: listeners) {
                    listener.onClick(ships.get(position));
                }
            }
        });

    }

    public void setOnClickListener(OnFleetClickListener listener) {
        listeners.add(listener);
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    public void addFleet(ShipAmount fleet) {
        ships.add(fleet);
        notifyItemInserted(ships.size() - 1);
    }

    public void addAllFleets(ArrayList<ShipAmount> newFleets) {
        for(ShipAmount ship:newFleets) {
            addFleet(ship);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView amount;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.fleetName);
            amount = (TextView) itemView.findViewById(R.id.fleetAmount);
        }
    }


}
