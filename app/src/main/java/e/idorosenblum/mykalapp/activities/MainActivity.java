package e.idorosenblum.mykalapp.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import e.idorosenblum.mykalapp.fragments.MapFragment;
import e.idorosenblum.mykalapp.interfaces.MyFragmentInterface;
import e.idorosenblum.mykalapp.R;
import e.idorosenblum.mykalapp.fragments.DetailFragment;
import e.idorosenblum.mykalapp.fragments.ListFragment;
import e.idorosenblum.mykalapp.models.LocationModel;
import e.idorosenblum.mykalapp.receiver.PowerConnectionReceiver;

public class MainActivity extends AppCompatActivity implements MyFragmentInterface {

    public LocationModel clickedLocation;
    public static ListFragment myListFragment;
    public static DetailFragment myDetailFragment;
    private static MapFragment myMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListFragment = new ListFragment();
        myDetailFragment = new DetailFragment();
        myMapFragment=new MapFragment();

        FragmentTransaction ftList = getSupportFragmentManager().beginTransaction();
        ftList.replace(R.id.fragment_1, myListFragment);
        ftList.addToBackStack(null);
        ftList.commit();
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_2) != null) {
            if (myListFragment.clicked == 1) {
                myDetailFragment.setClickedLocation(clickedLocation);
            }
            FragmentTransaction ftDetail = getSupportFragmentManager().beginTransaction();
            ftDetail.replace(R.id.fragment_2, myMapFragment);
            ftDetail.addToBackStack(null);
            ftDetail.commit();
        }

        registerForContextMenu(getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null, true));
        Intent intent = getApplication().registerReceiver(null, new IntentFilter( Intent.ACTION_BATTERY_CHANGED ) );
        PowerConnectionReceiver powerConnectionReceiver=new PowerConnectionReceiver();
        powerConnectionReceiver.onReceive(getApplication(),intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.type_km:
                break;
            case R.id.type_miles:
                break;
            case R.id.delete_fav:
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_item:
                break;

            case R.id.save_to_fav:
                break;

        }
        return true;
    }

    @Override
    public void onFragmentItemClicked() {
        myDetailFragment.setClickedLocation(clickedLocation);

        if (getSupportFragmentManager().findFragmentById(R.id.fragment_2) != null) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_2, myMapFragment);
            ft.commit();
        } else {
            Intent intent=new Intent(this,MapActivity.class);
            startActivity(intent);
        }
    }
}
