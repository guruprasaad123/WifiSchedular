package com.application.views;

import java.io.IOException;

import com.gluonhq.charm.glisten.mvc.View;

import javafx.fxml.FXMLLoader;

public class SchedularView {

	 private final String name;

	    public SchedularView(String name) {
	        this.name = name;
	    }
	    
	    public View getView() {
	        try {
	        	FXMLLoader loader=new FXMLLoader(getClass().getResource("ScheduleList.fxml"));
	            View view = (View)loader.load();
	         
	            view.setName(name);
	            return view;
	        } catch (IOException e) {
	            System.out.println("IOException: " + e);
	          e.printStackTrace();
	            return new View(name);
	        }
	    }
}
