package com.application.views;

import java.io.IOException;

import com.gluonhq.charm.glisten.mvc.View;

import javafx.fxml.FXMLLoader;

public class AboutView {
	private final String name;

    public AboutView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
        	FXMLLoader loader=new FXMLLoader(getClass().getResource("About.fxml"));
            View view = loader.load();
         
            view.setName(name);
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View(name);
        }
    }
}