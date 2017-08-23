package com.application;

import java.time.ZonedDateTime;
import java.util.Calendar;

import com.gluonhq.impl.charm.down.plugins.LocalNotificationsServiceBase;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafxports.android.FXActivity;
import javafxports.android.FXDalvikEntity;

public class Schedular  implements Schedule{

	AlarmManager manager=null;
	FXActivity activity=null;
	int count=0;
	WifiController wificontroller=null;
     
	public Schedular()
	{
    
    	  activity=FXActivity.getInstance();
	      manager=(AlarmManager) FXActivity.getInstance().getSystemService(Context.ALARM_SERVICE);
	      wificontroller=new WifiController();

	}
	
	public void Startschedule(int time,String message)
	{
		
	
		String id="12343"+count++;
		Intent indent = new Intent(FXActivity.getInstance(), StartAlarm.class);
		
		 indent.setData(getData(id));
	     indent.putExtra("Message", message);
	     indent.putExtra(StartAlarm.NOTIFICATION,getNotification(indent, message));
	
		PendingIntent pIntent = PendingIntent.getBroadcast(FXActivity.getInstance(), count, indent,  PendingIntent.FLAG_UPDATE_CURRENT);
		
	    manager.setExact(AlarmManager.RTC_WAKEUP,SystemClock.elapsedRealtime()+time,pIntent);
	
	 
	}
	
	
	public void Endschedule(int time,String message)
	{
		
		String id="56789"+count++;
		
		Intent intent= new Intent(FXActivity.getInstance(),EndAlarm.class);
		intent.setData(getData(id));
	    intent.putExtra("Message", message);
		
	    PendingIntent pIntent = PendingIntent.getBroadcast(FXActivity.getInstance(), count, intent,  PendingIntent.FLAG_UPDATE_CURRENT);
		
	    manager.setExact(AlarmManager.RTC_WAKEUP,SystemClock.elapsedRealtime()+time,pIntent);
	
	 
	}
	
	  private  Notification getNotification(Intent intent,String message)
	   {
		  
		  PendingIntent resultPendingIntent = PendingIntent.getActivity(FXActivity.getInstance(), StartAlarm.REQUEST_CODE, 
	                intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);
		  
		   Notification.Builder builder = new Notification.Builder(activity);
		   
		   builder.setSmallIcon(activity.getApplicationContext().getApplicationInfo().icon);
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
	 private Uri getData(String id) {
	       return Uri.withAppendedPath(Uri.parse("charm://down/Id/#"), id);
	    }
	 
}
