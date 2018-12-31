package e.idorosenblum.mykalapp.fragments;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import e.idorosenblum.mykalapp.DataProvider;
import e.idorosenblum.mykalapp.activities.MapActivity;
import e.idorosenblum.mykalapp.adapters.LocationAdapter;
import e.idorosenblum.mykalapp.interfaces.IPlacesDataReceived;
import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.models.LocationModel;


public class ListFragment extends Fragment implements IPlacesDataReceived {

    public static final String TAG = "myList";
    public static SearchView mSearchView;
    public static Button mNearButton;
    public static RecyclerView mSearchList;
    private static LocationAdapter adapter;
    private ArrayList<LocationModel> mArrayList = new ArrayList<>();
    private DataProvider mProvider;
    public static int clicked = 0;
    private static ProgressDialog mProgressDialog;
    public static LocationModel myLocation;


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
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialog = ProgressDialog.show(getContext(), "LOADING...", "Loading Locations. Please Wait...", true);
        mProvider=new DataProvider();
        mProvider.getPlacesByLocation(34.225, 31.655844, this);
        mSearchView = view.findViewById(R.id.search_bar);
        mNearButton = view.findViewById(R.id.near_btn);
        mSearchList = view.findViewById(R.id.search_list);
        mSearchList.setLayoutManager(new LinearLayoutManager(getContext()));

        if(myLocation!=null){
            Intent int1=new Intent(getContext(),MapActivity.class);

            startActivity(int1);
        }


        mNearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(getActivity(),"No MyLocation Found",Toast.LENGTH_SHORT).show();
//                Intent mapInt=new Intent(getContext(), MapActivity.class);
//                startActivity(mapInt);

            }
        });


    }

    @Override
    public void onPlacesDataReceived() {
        mArrayList=mProvider.getLocationList();
        adapter = new LocationAdapter<>(getContext(), mArrayList);
        adapter.notifyDataSetChanged();
        mSearchList.setAdapter(adapter);
        stopProgressDialog();
    }

    public static void stopProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
