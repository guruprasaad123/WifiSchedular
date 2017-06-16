package com.application.views;

import java.io.IOException;

import com.application.control.OpeningController;
import com.gluonhq.charm.glisten.mvc.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

public class OpeningView {
    private final String name;

    public OpeningView(String name) {
        this.name = name;
    }
    
    public View getView(EventHandler<ActionEvent> action) {
        try {
        	FXMLLoader loader=new FXMLLoader(getClass().getResource("opening.fxml"));
            View view = loader.load();
         OpeningController opening=(OpeningController)   loader.getController();
         opening.setAction(action);
            view.setName(name);
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View(name);
        }
    }
}
