package com.application;

import com.gluonhq.impl.charm.down.plugins.LocalNotificationsServiceBase;
import javafxports.android.DalvikLauncher;
import javafxports.android.FXActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import java.util.logging.Level;
import java.util.logging.Logger;
import android.widget.Toast;
import javafxports.android.FXDalvikEntity;
/*
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

*/
public class StartAlarm extends BroadcastReceiver
{
	
	 static String message;
final static int REQUEST_CODE=567890;
final static  String NOTIFICATION="notification";
final static String WIFI="wificontroller";

	Logger log=Logger.getLogger(StartAlarm.class.getName());

	int count=0;
	   @Override
	     public void onReceive(Context context, Intent intent)
	     {
		   try {
           message=intent.getExtras().getString("Message");
		   	
		   	Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		   	
		   	NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

	        android.app.Notification notification = (Notification)intent.getParcelableExtra(NOTIFICATION);
	        String tag = intent.getDataString();
	        
	        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
	          wifiManager.setWifiEnabled(true);
	        
	        notificationManager.notify(tag, REQUEST_CODE, notification);
		   log.log(Level.SEVERE," $ $ Notification Issued successfully ",tag);
		 
		   }
	
		   catch(NullPointerException i)
		   {
			 Notifications.Notify("Null pointer Exception ", i.toString(),"");
			  log.log(Level.SEVERE," $ $ Null pointer Exception  ",i);
		   }
		   
		   catch(Exception i)
		   {
			   Notifications.Notify("Error", i.toString(),"");	  
			   log.log(Level.SEVERE," $ $ Notification not Issued successfully ",i);
		   }
		   	
	     }
	   
	  private Notification getNotification(Intent intent,Context context,String message)
	   {
		  
		  PendingIntent resultPendingIntent = PendingIntent.getActivity(FXActivity.getInstance(), StartAlarm.REQUEST_CODE, 
	                intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);
		  
		   Notification.Builder builder = new Notification.Builder(context);
		   
		   builder.setSmallIcon(context.getApplicationContext().getApplicationInfo().icon);
		   builder.setContentTitle("In Android header");
		   builder.setContentText(message);
		   builder.setPriority(Notification.PRIORITY_MAX);
		   builder.setContentIntent(resultPendingIntent);
		   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
	            builder.setCategory(android.app.Notification.CATEGORY_EVENT);
	            builder.setVisibility(android.app.Notification.VISIBILITY_PUBLIC);
	        }
		   builder.setDefaults(android.app.Notification.DEFAULT_VIBRATE);
		   builder.setAutoCancel(true);
		   
		   return builder.build();
	   
	   }
	
}