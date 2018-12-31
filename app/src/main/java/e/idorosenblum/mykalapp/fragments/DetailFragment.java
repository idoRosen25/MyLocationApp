package e.idorosenblum.mykalapp.fragments;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import e.idorosenblum.mykalapp.activities.MapActivity;
import e.idorosenblum.mykalapp.interfaces.IMapChangeInterface;
import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.models.LocationModel;
import e.idorosenblum.mykalapp.models.Photo;

public class DetailFragment extends Fragment {

    public static final String TAG="myDetail";
    private static ImageView mImageView;
    private static TextView mTitle;
    private static TextView mAddress;
    private static TextView mDistance;
    private static ArrayAdapter adapter;
    private static LocationModel mLocations;
    private IMapChangeInterface iMapChangeInterface;
    private List<Photo> mLocationPhoto;
    private Photo mPhoto;
    private Button mapBtn;
    private MapActivity mapActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapBtn=view.findViewById(R.id.dm_btn);

        if(mLocations!=null){
            mImageView = view.findViewById(R.id.item_image);
            mTitle = view.findViewById(R.id.title_);
            mTitle.setText(mLocations.getName());
            mAddress = view.findViewById(R.id.address_);
            mAddress.setText(mLocations.getVicinity());
            mDistance = view.findViewById(R.id.distance_);
            mLocationPhoto=mLocations.getPhotos();
            mPhoto=mLocationPhoto.get(0);
            mDistance.setText(mPhoto.getPhoto_reference());
        }else {
            mImageView = view.findViewById(R.id.item_image);
            mImageView.setVisibility(View.INVISIBLE);
            mTitle = view.findViewById(R.id.title_);
            mTitle.setText("TITLE");
            mAddress = view.findViewById(R.id.address_);
            mAddress.setText("ADDRESS");
            mDistance = view.findViewById(R.id.distance_);
            mDistance.setText("DISTANCE");
        }
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iMapChangeInterface.setMapDetail(1);
                mapActivity.changeMapDetail();
            }
        });
    }

    public static void setClickedLocation(LocationModel locations){
        mLocations=locations;
    }

}
