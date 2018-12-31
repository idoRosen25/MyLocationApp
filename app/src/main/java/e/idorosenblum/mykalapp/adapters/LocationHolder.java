package e.idorosenblum.mykalapp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.fragments.ListFragment;
import e.idorosenblum.mykalapp.models.Geometry;
import e.idorosenblum.mykalapp.models.MyLocation;
import e.idorosenblum.mykalapp.models.LocationModel;
import e.idorosenblum.mykalapp.models.Photo;

import static e.idorosenblum.mykalapp.R.drawable.ic_launcher_background;

public class LocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context mContext;
    private ImageView imgPoster;
    private TextView textName;
    private TextView textAddress;
    private TextView textDistance;
    private LocationModel local;

    public LocationHolder(Context context_,@NonNull View itemView) {
        super(itemView);
        mContext=context_;
        imgPoster=itemView.findViewById(R.id.img_location);
        textName=itemView.findViewById(R.id.name_txt);
        textAddress=itemView.findViewById(R.id.address_txt);
        textDistance=itemView.findViewById(R.id.distance_txt);
    }

    public void bindLocation(LocationModel location_)
    {
        imgPoster.setImageDrawable(null);
        textName.setText(location_.getName());

        textAddress.setText(location_.getVicinity());

        Geometry newGeometry=location_.getGeometry();
        MyLocation local=newGeometry.getPlaceLocation();
        MyLocation local2=new MyLocation("Here",34.225,31.655844);
        double distance=local2.distanceTo(local);
        textDistance.setText(String.valueOf(distance));
    }


    @Override
    public void onClick(View v) {
        local=new LocationModel();
        local.setName(String.valueOf(textName.getText()));
        local.setVicinity(String.valueOf(textAddress.getText()));
        local.setDistance(String.valueOf(textDistance.getText()));

        ListFragment.myLocation=local;
    }
}
