package main.AttackChoice;

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
import model.Ship;
import model.ShipAmount;

/**
 * Created by gcalori on 11/06/2018.
 */

public class AttackChoiceAdapter extends RecyclerView.Adapter<main.AttackChoice.AttackChoiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ShipAmount> ships = new ArrayList<>();

    public ArrayList<ShipAmount> getShips() {
        return ships;
    }

    public AttackChoiceAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public main.AttackChoice.AttackChoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_attack_user, parent, false);

        return new main.AttackChoice.AttackChoiceAdapter.ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(main.AttackChoice.AttackChoiceAdapter.ViewHolder holder, final int position) {
        final ShipAmount ship = ships.get(position);

        SeekBar progress = holder.progress;
        TextView name = holder.name;
        final TextView amount = holder.amount;
        name.setText(ship.getName());

        progress.setMax(ship.getAmount().intValue());

        progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amount.setText((String.valueOf(progress)));
                ship.setAmount((long) progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void addShips(ShipAmount ship) {
        ships.add(ship);
        notifyItemInserted(ships.size() - 1);
    }

    public void addAllShips(ArrayList<ShipAmount> newShips) {
        for(ShipAmount ship:newShips) {
            addShips(ship);
        }
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView amount;
        SeekBar progress;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.shipAttackNameTextView);
            amount = (TextView) itemView.findViewById(R.id.shipAttackAmount);
            progress = (SeekBar) itemView.findViewById(R.id.shipAttackProgressBar);
        }
    }


}

