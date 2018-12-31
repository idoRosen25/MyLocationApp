package e.idorosenblum.mykalapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.activities.MapActivity;
import e.idorosenblum.mykalapp.interfaces.IMapChangeInterface;

public class MapFragment extends Fragment {

    private Button detailButton;
    private TextView mapText;
    private IMapChangeInterface mapChangeInterface;
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
        return inflater.inflate(R.layout.map_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapText = view.findViewById(R.id.map_text);

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapChangeInterface.setMapDetail(0);
                mapActivity.changeMapDetail();
            }
        });
    }


}
