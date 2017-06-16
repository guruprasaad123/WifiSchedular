package com.application.control;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class OpeningController implements Initializable {

	
	@FXML JFXButton schedule;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	System.out.println("init");	
	}

	public void setAction(EventHandler<ActionEvent> action)
	{
		schedule.setOnAction(action);
	}
}
