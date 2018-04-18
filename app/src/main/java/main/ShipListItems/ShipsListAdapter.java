package main.ShipListItems;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import main.OnBuildingClickListener;
import main.OnShipClickListener;
import model.Building;
import model.Ship;


/**
 * Created by gcalori on 26/03/2018.
 */

public class ShipsListAdapter extends RecyclerView.Adapter<ShipsListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Ship> ships = new ArrayList<>();

    private ArrayList<OnShipClickListener> listeners = new ArrayList<>();

    public ShipsListAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_ships, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        Ship ship = ships.get(position);

        TextView name = holder.name;
        name.setText(ship.getName());


        TextView life = holder.life;
        life.setText("life :"+ship.getLife().toString());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(OnShipClickListener listener: listeners) {
                    listener.onClick(ships.get(position));
                }
            }
        });

    }

    public void setOnBuildingClickListener(OnShipClickListener listener) {
        listeners.add(listener);
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    public void addShips(Ship ship) {
        ships.add(ship);
        notifyItemInserted(ships.size() - 1);
    }

    public void addAllShips(ArrayList<Ship> newShips) {
        for(Ship ship:newShips) {
                addShips(ship);
        }
    }

    public void clearShips() {
        final int size = ships.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                ships.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView life;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.buildingName);
            life = (TextView) itemView.findViewById(R.id.buildingLife);

        }
    }


}
