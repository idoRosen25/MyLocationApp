package e.idorosenblum.mykalapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.fragments.DetailFragment;
import e.idorosenblum.mykalapp.fragments.MapFragment;
import e.idorosenblum.mykalapp.interfaces.IMapChangeInterface;

public class MapActivity extends AppCompatActivity implements IMapChangeInterface{

    private DetailFragment newDetailFrag;
    private MapFragment newMapFrag;
    int x;
    private FragmentTransaction ftList;
    private Button detailMapBtn;
    private IMapChangeInterface changeInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details_fragment);
        newDetailFrag=new DetailFragment();
        newMapFrag=new MapFragment();

        detailMapBtn=findViewById(R.id.dm_btn);
        ftList= getSupportFragmentManager().beginTransaction();
        ftList.replace(R.id.fragment_3, newMapFrag);
        ftList.addToBackStack(null);
        ftList.commit();

        detailMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMapDetail();
            }
        });



    }

    public void changeMapDetail() {
        ftList=getSupportFragmentManager().beginTransaction();
        if(x==0){
            detailMapBtn.setText("Show On Map");
            ftList.replace(R.id.fragment_3, newDetailFrag);
            ftList.addToBackStack(null);
            ftList.commit();
        }else{
            detailMapBtn.setText("Show Details");
            ftList.replace(R.id.fragment_3, newMapFrag);
            ftList.addToBackStack(null);
            ftList.commit();
        }
    }

    @Override
    public void setMapDetail(int int_) {
        this.x=int_;
    }
}
