package com.application.control;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.application.utils.ScheduleViewCell;
import com.application.utils.Schedules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
public class ScheduleViewController implements Initializable {

	
	@FXML ListView<Schedules> schedules;
	
	private ObservableList<Schedules> schedules_list;
	
	
	 public ScheduleViewController() {
		 schedules_list=FXCollections.observableArrayList();
			
			LocalTime start=LocalTime.now();
			LocalTime end=LocalTime.now();
			
		
			System.out.println(start);
			
			schedules_list.add(new Schedules(start,end,Schedules.State.ON));
			
			
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		System.out.println("INit");;
		schedules.setItems(schedules_list);
		schedules.setCellFactory((e)-> new ScheduleViewCell());
		
       // schedules.setCellFactory(value);
	}

}
