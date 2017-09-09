package com.application.control;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.application.utils.ScheduleViewCell;
import com.application.utils.Schedules;
import com.application.utils.Schedules.State;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
public class ScheduleViewController implements Initializable {

	
	@FXML ListView<Schedules> schedulelist;
	
	private ObservableList<Schedules> schedules_list;
	
	
	 public ScheduleViewController() {
		 schedules_list=FXCollections.observableArrayList();
			
			LocalTime start=LocalTime.now();
			LocalTime end=LocalTime.now();
			
		
			System.out.println(start);
		
			
	
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		System.out.println("INit");;
		schedulelist.setItems(schedules_list);
		
		schedules_list.add(new Schedules(LocalTime.now(), LocalTime.now(), State.ON));
		
		schedulelist.setCellFactory((e)-> new ScheduleViewCell());
		
		schedulelist.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
			
			System.out.println(schedulelist.getSelectionModel().getSelectedIndex());
		}
		);
		
       // schedules.setCellFactory(value);
	}

}
