package com.application;
import java.io.IOException;

import com.application.control.MainController;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.glisten.mvc.View;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class Main extends javafx.application.Application 

{
	
	public static void main(String args[])
	{
		
		launch(args);
	}
	
	public void init()
{
	
}
	public void start( Stage PrimaryStage)
	{
	
		
	try {
		Rectangle2D visual=Screen.getPrimary().getVisualBounds();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Home.fxml"));
		View view=(View)loader.load();
		MainController controller=(MainController)loader.getController();
			
		
		JFXSnackbar snackbar=new JFXSnackbar(view);
		//snackbar.enqueue(new SnackbarEvent("Notification Msg"));
		snackbar.setPrefHeight(50);
		snackbar.setPrefWidth(350);
		snackbar.enqueue(new SnackbarEvent("Welcome", "view", 10000, false, null));
	
		
		Scene scene=null;
		if(Platform.isAndroid())
			scene=new Scene(view,visual.getWidth(),visual.getHeight());
			
		else
		scene=new Scene(view,350,575);
		scene.setOnSwipeLeft(action -> {
			controller.showPopUp();
		}
		);
		
		PrimaryStage.setResizable(false);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
		
		
		
	}
	
	
	
}
