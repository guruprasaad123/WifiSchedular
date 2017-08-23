package com.application.utils;

import java.io.IOException;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class ScheduleViewCell extends ListCell<Schedules>
{
	
	
	@FXML Label start,end,state;
	
	@FXML HBox box;
	@FXML MaterialIconView delete;
	
	@Override
	    protected void updateItem(Schedules student, boolean empty) 
	{
		  super.updateItem(student, empty);
		try
		{
			
			if(student==null)
			{
				setGraphic(null);
				setText(null);
			}
			else
			{
		FXMLLoader loader =new FXMLLoader(getClass().getResource("cell.fxml"));
		loader.setController(this);
		loader.load();
		
		start.setText(student.getStartTime());
        end.setText(student.getEndTime());
        state.setText(student.getState().toString());
		
        
        setGraphic(box);
        setText(null);
			}
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	
	@FXML protected void delete()
	{
    
		
		
	}
	
}
