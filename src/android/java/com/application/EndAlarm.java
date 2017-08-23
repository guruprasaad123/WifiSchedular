package com.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EndAlarm  extends BroadcastReceiver{
	
	 static String message;
	
	int count=0;
	   @Override
	     public void onReceive(Context context, Intent intent)
	     {
		   
		    message=intent.getExtras().getString("Message");
		   	
		   	Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		   	
		   	Notifications.Notify("Android header2", message, "");
	
	     }
	
}