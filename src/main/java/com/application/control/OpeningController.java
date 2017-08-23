package com.application.control;

import java.net.URL;
import java.util.ResourceBundle;

import com.application.WifiPermission;
import com.gluonhq.charm.glisten.mvc.View;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class OpeningController implements Initializable {

	
	@FXML JFXButton schedule;
	@FXML View view;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	System.out.println("init");	

	}

	public void setAction(EventHandler<ActionEvent> action)
	{
		schedule.setOnAction(action);
		
	}

	 private static String getPlatform() {
	     switch ( System.getProperty("javafx.platform", "desktop") ) {
	         case "android": return "com.application.AndroidPlatform";
	         case "ios": return "com.IosPlatform";
	         default : return "";
	     }
	 }
	 
}
