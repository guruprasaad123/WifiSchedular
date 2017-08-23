package com.application.control;

import java.net.URL;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXToggleNode;
import com.application.Main;
import com.application.NativePlatform;
import com.application.Schedule;
import com.application.WifiInterface;
import com.application.WifiPermission;
import com.application.NotificationService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ScheduleController implements Initializable{

	@FXML JFXButton start;
	@FXML JFXTimePicker from,to;
	@FXML JFXToggleNode wifinode;
	@FXML Label indication;
	boolean prev;
	Logger logger=null;
	int count=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("init");	
		logger=Logger.getLogger(ScheduleController.class.getName());
		//wifinode.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->act() );
	}
	
	
	@FXML void act()
	{
		if(wifinode.isSelected())
		indication.setText("Scheduled to turn On  :");
		else
	    indication.setText("Scheduled to turn Off  :");
					
	}
	
	@FXML void start()
	{
	
		try{
			
		WifiPermission permission = (WifiPermission)	Class.forName(getPlatformPermission()).newInstance();
	
		permission.checkPermissions();
		
		Schedule schedule =(Schedule) Class.forName("com.application.Schedular").newInstance();
		
		schedule.Startschedule( 2000,"Message 1");
			
		schedule.Endschedule(10000, "Da vinci ");
		
		schedule.Endschedule(12000, "Alert 1");
		
		
		
		//Notify("Success ! ","passed","");
		
         
		
		
		 
	/*	LocalTime starting=	from.getValue();
	
		LocalTime ending=	to.getValue();

	
	
	boolean wifi=wifinode.isSelected();
		
	//NativePlatform platform=(NativePlatform)Class.forName(getPlatform()).newInstance();
	 
	//WifiInterface wifiInterface=platform.getWifiController();
	
	//wifiInterface.checkPermission();
	
	Calendar starting_time=Calendar.getInstance();
	starting_time.set(Calendar.HOUR_OF_DAY, starting.getHour());
	starting_time.set(Calendar.MINUTE,starting.getMinute());
	starting_time.set(Calendar.SECOND,1);
	starting_time.set(Calendar.MILLISECOND,1);
	
	Calendar end_time=Calendar.getInstance();
	end_time.set(Calendar.HOUR_OF_DAY, ending.getHour());
	end_time.set(Calendar.MINUTE,ending.getMinute());
	end_time.set(Calendar.SECOND,1);
	end_time.set(Calendar.MILLISECOND,1);
	
	//System.out.println(starting.toString());
	Notify("Wifi is Scheduled to turn "+((wifi)?"On":"Off"),"from "+starting+" to "+ending+" Successfully","");
	
	
	
	Timer timer =new Timer(true);
	timer.schedule(timer_start(wifi), starting_time.getTime());
	
	timer.schedule(timer_end(), end_time.getTime());
	
	*/
		}
		catch(Exception i)
		{
			Notify("Error Occured",i.toString(),i.toString());
			i.printStackTrace();
			logger.log(Level.SEVERE,"$ $ runtime Exception ",i);
		}
		
	}

    private static String getPlatform() {
        switch ( System.getProperty("javafx.platform", "desktop") ) {
            case "android": return "com.application.AndroidNative";
            case "ios": return "com.IosPlatform";
            default : return "";
        }
    }
	
	private static String getPlatformPermission()
	{
		   switch ( System.getProperty("javafx.platform", "desktop") ) 
		   {
           case "android": return "com.application.AndroidPlatform";
           case "ios": return "com.IosPlatform";
           default : return "";
           }
	}
   

	

	TimerTask timer_end()
	{
		return new TimerTask(){
		@Override
		 public void run()
		  {
		    try
		    {
		      NativePlatform platform = (NativePlatform)Class.forName(getPlatform()).newInstance();
		      WifiInterface wifiInterface = platform.getWifiController();
		      if (prev)
		      {
		        wifiInterface.turnOn();
		      Notify("Wifi turned " + (prev ? "ON" : "OFF") + " Successfully ", "Schedule completed Successfully!", "scheduled Successfully ! ");
		      }
		      else
		      {
		        wifiInterface.turnOff();
		       Notify("Wifi turned " + (prev ? "ON" : "OFF") + " Successfully ", "Schedule completed Successfully!", "scheduled Successfully ! ");
		      }
		    }
		    catch (ClassNotFoundException|InstantiationException|IllegalAccessException o)
		    {
		      o.printStackTrace();
		     Notify("Error Occured!", o.toString(), "");
		    }
		  
		}
		};
	}
	
	TimerTask timer_start(boolean action)
	{
		return new TimerTask() {
			
			private boolean prev;

			@Override

			  public void run()
			  {
			    try
			    {
			      NativePlatform platform = (NativePlatform)Class.forName(getPlatform()).newInstance();
			      WifiInterface wifiInterface = platform.getWifiController();
			      
			      this.prev = wifiInterface.isTurnedOn();
			      
			      
			      
			      if (this.prev == action)
			      {
			        Notify("Wifi already turned " + (action ? "ON" : "OFF"), "Previous State : " + (prev ? "ON" : "OFF"), "scheduled Successfully ! ");
			      }
			      else if (action)
			      {
			        wifiInterface.turnOn();
			        Notify("Wifi turned " + (action ? "ON" : "OFF") + " Successfully ", "Previous State : " + (prev ? "ON" : "OFF"), "scheduled Successfully ! ");
			      }
			      else if (!action)
			      {
			        wifiInterface.turnOff();
			       Notify("Wifi turned " + (action ? "ON" : "OFF") + " Successfully ", "Previous State : " + (prev ? "ON" : "OFF"), "scheduled Successfully ! ");
			      }
			    }
			    catch (ClassNotFoundException|InstantiationException|IllegalAccessException o)
			    {
			      o.printStackTrace();
			      Notify("Error Occured!", o.toString(), "");
			    }
			  }

		
		}; 
	
	}
	private void Notify(String string, String string2, String string3) {
		
		
		String notificationId = "abcd1234"+count++;
		  Services.get(LocalNotificationsService.class).ifPresent(service -> {
		      service.getNotifications().add(new Notification(notificationId, string,string2,
		              ZonedDateTime.now(), () -> {
		                      Alert alert = new Alert(AlertType.INFORMATION, string3);
		                      Platform.runLater(() -> alert.showAndWait());
		              }));
		  });
	
	}
}

