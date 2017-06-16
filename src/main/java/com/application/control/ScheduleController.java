package com.application.control;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXToggleNode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ScheduleController implements Initializable{

	@FXML JFXButton start;
	@FXML JFXTimePicker from,to;
	@FXML JFXToggleNode wifinode;
	@FXML Label indication;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println("init");	
		
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
	LocalTime starting=	from.getValue();
	LocalTime ending=	to.getValue();
	
		
		
		
		
	}
	
}
