package main.Leaderboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gcalori.outerspacemanager.R;

import java.util.ArrayList;

import main.OnBuildingClickListener;
import model.Building;
import model.LeaderboardUser;
import model.ShipAmount;


/**
 * Created by gcalori on 26/03/2018.
 */

public class LeaderboardListAdapter extends RecyclerView.Adapter<LeaderboardListAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<LeaderboardUser> users = new ArrayList<>();

    public LeaderboardListAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_leaderboard, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        LeaderboardUser user = users.get(position);

        TextView name = holder.name;
        name.setText(user.getUsername());

        TextView points = holder.points;
        points.setText(user.getPoints().toString()+ "pts");

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

    }

    public LeaderboardUser getUserAtPosition(int position) {
        return this.users.get(position);
    }

    public void addUser(LeaderboardUser user) {
        users.add(user);
        notifyItemInserted(users.size() - 1);
    }

    public void addAllUsers(ArrayList<LeaderboardUser> newUsers) {
        for(LeaderboardUser user:newUsers) {
            addUser(user);
        }
    }


    @Override
    public int getItemCount() {
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView points;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.leaderboardUsername);
            points = (TextView) itemView.findViewById(R.id.leaderboardPoints);
        }
    }


}
