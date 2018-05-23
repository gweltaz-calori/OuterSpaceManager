package main.AttackChoice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import main.Leaderboard.LeaderboardListAdapter;
import model.LeaderboardUser;
import model.ShipAmount;

/**
 * Created by gcalori on 23/05/2018.
 */

public class AttackChoiceAdapter extends RecyclerView.Adapter<AttackChoiceAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<ShipAmount> fleet = new ArrayList<>();

    public AttackChoiceAdapter(Context context)  {
        this.context = context;
    }

    @NonNull
    @Override
    public AttackChoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_leaderboard, parent, false);

        return new AttackChoiceAdapter.ViewHolder(row);
    }


    @Override
    public void onBindViewHolder(@NonNull AttackChoiceAdapter.ViewHolder holder, int position) {
        ShipAmount ship = fleet.get(position);


    }

    @Override
    public int getItemCount() {
        return fleet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       /* public TextView name;
        public TextView points;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.leaderboardUsername);
            points = (TextView) itemView.findViewById(R.id.leaderboardPoints);
        }*/
    }
}

