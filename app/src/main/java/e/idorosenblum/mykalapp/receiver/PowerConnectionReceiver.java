package e.idorosenblum.mykalapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    public static Boolean charger=false;
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context,"the device is charging",Toast.LENGTH_SHORT).show();
            charger=true;
        }if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context,"Device charging stopped",Toast.LENGTH_SHORT).show();
            charger=false;
        }
    }
}
