package main.Building;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gcalori.outerspacemanager.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import main.OnBuildingClickListener;
import model.Building;


/**
 * Created by gcalori on 26/03/2018.
 */

public class BuildingListAdapter extends RecyclerView.Adapter<BuildingListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Building> buildings = new ArrayList<>();

    private ArrayList<OnBuildingClickListener> listeners = new ArrayList<>();

    public BuildingListAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(R.layout.row_buildings, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        Building building = buildings.get(position);

        TextView name = holder.name;
        name.setText(building.getName());

        TextView level = holder.level;
        level.setText("Level "+building.getLevel().toString());

        if(building.isBuilding()) {
            TextView isProcessing = holder.processing;
            isProcessing.setText("En cours de construction ");
        }


        ImageView imageView = holder.image;
        Glide.with(context).load(building.getImageUrl()).into(imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(OnBuildingClickListener listener: listeners) {
                    listener.onClick(buildings.get(position));
                }
            }
        });

    }

    public void setOnBuildingClickListener(OnBuildingClickListener listener) {
        listeners.add(listener);
    }

    @Override
    public int getItemCount() {
        return buildings.size();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
        notifyItemInserted(buildings.size() - 1);
    }

    public void addAllBuildings(ArrayList<Building> newBuildings) {
        for(Building building:newBuildings) {
            addBuilding(building);
        }
    }

    public void clearBuildings() {
        final int size = buildings.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                buildings.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView level;
        public TextView processing;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.buildingName);
            processing = (TextView) itemView.findViewById(R.id.buildingProcessing);
            level = (TextView) itemView.findViewById(R.id.buildingLevel);
            image = (ImageView) itemView.findViewById(R.id.buildingImage);
        }
    }


}
