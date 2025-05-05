package Pillerofandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastRecevier :BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
when(intent?.action){
    Intent.ACTION_BOOT_COMPLETED->{
        Toast.makeText(context,"BOOT COMPLETED",Toast.LENGTH_LONG).show()
    }
}
    }

}