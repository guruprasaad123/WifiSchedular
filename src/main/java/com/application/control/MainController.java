package com.application.control;

import com.application.animation.BounceInLeftTransition;
import com.application.utils.SliderPane;
import com.application.views.NavigationView;
import com.application.views.OpeningView;
import com.application.views.ScheduleView;
import com.gluonhq.charm.glisten.mvc.View;
import com.jfoenix.controls.JFXHamburger;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class MainController {

@FXML Label header;
@FXML JFXHamburger nav;
@FXML View view;

View Home_View;
View Schedule_View;

SliderPane slider;

ListView listview;

final String HOME_VIEW="HOME_VIEW";
final String SCHEDULE_VIEW="SCHEDULE_VIEW";

@FXML public void initialize()
{
	
	System.out.println("init");
	
	slider=new SliderPane();
	
	OpeningView opening=new OpeningView("OPENING_VIEW");
	NavigationView navigation=new NavigationView("NAVIGATION_VIEW");
	ScheduleView schedule=new ScheduleView("SCHEDULE_VIEW");
	
	
	listview=navigation.getView();
	Home_View=opening.getView((e)->setScene(SCHEDULE_VIEW ));
	Schedule_View=schedule.getView();
	
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
 public  void showPopUp()
   {
	   slider.showPopover();
   }
   void setScene(String scene)
   {
	   switch(scene)
	   {
	   
	   case HOME_VIEW :
	   {
		   BounceInLeftTransition bounce=new BounceInLeftTransition(Home_View);
		   bounce.play();
		   slider.setContent(Home_View);
		   //slider.hidePopover();
		   break;
	   }
	   
	   case SCHEDULE_VIEW:
	   {
		   BounceInLeftTransition bounce=new BounceInLeftTransition(Schedule_View);
		   bounce.play();
		   slider.setContent(Schedule_View);
		   //slider.hidePopover();
		   break;
	   }
	   
	   }
   }

}


