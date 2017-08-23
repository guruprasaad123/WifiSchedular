package com.application.views;

import java.io.IOException;

import com.application.control.ScheduleController;
import com.gluonhq.charm.glisten.mvc.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

public class ScheduleView {
	 private final String name;

	    public ScheduleView(String name) {
	        this.name = name;
	    }
	    
	    public View getView() {
	        try {
	        	FXMLLoader loader=new FXMLLoader(getClass().getResource("schedule.fxml"));
	            View view = loader.load();
	         
	            view.setName(name);
	            return view;
	        } catch (IOException e) {
	            System.out.println("IOException: " + e);
	            return new View(name);
	        }
	    }
}
