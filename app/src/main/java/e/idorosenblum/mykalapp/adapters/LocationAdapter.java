package e.idorosenblum.mykalapp.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.models.LocationModel;

public class LocationAdapter<E> extends RecyclerView.Adapter<LocationHolder>{

    private Context mContext;
    private ArrayList<LocationModel> locationModels;
    private LayoutInflater layoutInflater;
    public LocationAdapter(Context context, ArrayList<LocationModel> locationModels_){
        mContext=context;
        locationModels=locationModels_;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout=(LinearLayout)layoutInflater.inflate(R.layout.location_item_row,viewGroup,false);
        return new LocationHolder(mContext,linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, int position) {
        LocationModel location_=locationModels.get(position);
        holder.bindLocation(location_);
    }

    @Override
    public int getItemCount() {
        return locationModels.size();
    }
}
