package com.application.views;

import java.io.IOException;

import com.gluonhq.charm.glisten.mvc.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class NavigationView {
	 private final String name;

	    public NavigationView(String name) {
	        this.name = name;
	    }
	    
	    public ListView getView() {
	        try {
	            ListView view = FXMLLoader.load(getClass().getResource("navigation.fxml"));
	           
	            return view;
	        } catch (IOException e) {
	            System.out.println("IOException: " + e);
	            return new ListView();
	        }
	    }
}
