package boot.combroadcast.broadcastonboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        // adb shell am broadcast -a "sathya"  -n "boot.combroadcast.broadcastonboot/boot.combroadcast.broadcastonboot.MainActivity"
        // adb shell am broadcast -a "Sathya" --ei "value" 980
        // adb shell am broadcast -a "sathya" -n boot.combroadcast.broadcastonboot/.MyReceiver
        if(intent.getAction().equals("Sathya")) {

            Log.d("tag","My Action notification received...");

            Toast.makeText(context, "Broadcast received : ", Toast.LENGTH_SHORT).show();

                    Bundle extras = intent.getExtras();


            if( extras != null){

                if(extras.containsKey("value")) {

                    Log.d("tag","Value received ...: "+extras.get("value"));
                    Toast.makeText(context, "Value received : "+extras.get("value"), Toast.LENGTH_SHORT).show();

                }
            }
        }




        if( intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {


            Toast.makeText(context, "Device Booted", Toast.LENGTH_SHORT).show();

            Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));

            // java.lang.RuntimeException: Unable to start receiver edu.broadcast.com.broadcast2.MyReceiver:
            // android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires
            // the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?

            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);

        }


            //throw new UnsupportedOperationException("Not yet implemented");
    }

}
