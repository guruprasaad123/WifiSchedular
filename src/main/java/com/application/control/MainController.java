package com.application.control;


import com.application.WifiPermission;
import com.application.animation.BounceInLeftTransition;
import com.application.animation.BounceInRightTransition;
import com.application.utils.SliderPane;
import com.application.views.AboutView;
import com.application.views.NavigationView;
import com.application.views.OpeningView;
import com.application.views.SchedularView;
import com.application.views.ScheduleView;
import com.gluonhq.charm.glisten.mvc.View;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {

@FXML Label header;
@FXML JFXHamburger nav;
@FXML View view;

View Home_View;
View Schedule_View;
View About_View;
View Schedular_View;

SliderPane slider;
Stage PrimaryStage;
JFXListView listview;

final String HOME_VIEW="HOME_VIEW";
final String SCHEDULE_VIEW="SCHEDULE_VIEW";
final String ABOUT_VIEW="ABOUT_VIEW";
final String SCHEDULAR_VIEW ="SCHEDULAR_VIEW";

@FXML public void initialize()
{
	
	try{
	System.out.println("init");
	
	slider=new SliderPane();
	
	OpeningView opening=new OpeningView("OPENING_VIEW");
	NavigationView navigation=new NavigationView("NAVIGATION_VIEW");
	ScheduleView schedule=new ScheduleView("SCHEDULE_VIEW");
	AboutView about=new AboutView("ABOUT_VIEW");
	SchedularView schedular = new SchedularView("SCHEDULAR_VIEW");
	
	listview=navigation.getView();
	System.out.println(listview);
	
	Home_View=opening.getView((e)->setScene(SCHEDULE_VIEW ));
	Schedule_View=schedule.getView();
	About_View=about.getView();
	Schedular_View=schedular.getView();
	
	
	slider.setPinned(false);
	slider.setContent(Home_View);
	slider.setPopover(listview);
	
	view.setCenter(slider);
	
	listview.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
		int index=listview.getSelectionModel().getSelectedIndex();
		
		if(index==0)
		{
			setScene(HOME_VIEW );
		}
		else if(index==1)
		{
			setScene(SCHEDULE_VIEW );
		}
		else if(index==2)
		{
			setScene(SCHEDULAR_VIEW);
		
		}
		else if(index==3)
		{
			setScene(ABOUT_VIEW);
		}
		else if(index==4)
		{
			PrimaryStage.close();
		}
	}
	);
	
	listview.selectionModelProperty().addListener((e)->
	{
		System.out.println("list view changed ");
	});

	nav.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
		//System.out.println("popover");
		if(slider.isPopoverVisible())
		{
			slider.hidePopover();
			System.out.println("visible");
		}else
		slider.showPopover();
	}
		);
	}
	catch(Exception i)
	{
		i.printStackTrace();
	}
	
	
}
 public  void showPopUp()
   {
	   slider.showPopover();
   }
 
 public void setStage(Stage stage)
 {
	 PrimaryStage=stage;
 }
  
 void setScene(String scene)
   {
	   switch(scene)
	   {
	   
	   case HOME_VIEW :
	   {
		   header.setText("HOME");
		   BounceInLeftTransition bounce=new BounceInLeftTransition(Home_View);
		   bounce.play();
		   slider.setContent(Home_View);
		   //slider.hidePopover();
		   break;
	   }
	   
	   case SCHEDULE_VIEW:
	   {
		   header.setText("SCHEDULE");
		   BounceInLeftTransition bounce=new BounceInLeftTransition(Schedule_View);
		   bounce.play();
		   slider.setContent(Schedule_View);
		   //slider.hidePopover();
		   break;
	   }
	   case ABOUT_VIEW:{
		   header.setText("ABOUT");
		   BounceInLeftTransition bounce=new BounceInLeftTransition(About_View);
		   bounce.play();
		   slider.setContent(About_View);
		   break;
	   }

	   case SCHEDULAR_VIEW:{
		   header.setText("SCHEDULAR LIST");
		   BounceInLeftTransition bounce=new BounceInLeftTransition(Schedular_View);
		   bounce.play();
		   slider.setContent(Schedular_View);
		   break;
	   }
	   
	   
   }
   }
 
 private static String getPlatform() {
     switch ( System.getProperty("javafx.platform", "desktop") ) 
     {
         case "android": return "com.application.AndroidPlatform";
         case "ios": return "com.IosPlatform";
         default : return "";
     }
 }
}


