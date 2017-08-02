package com.application;

import java.time.ZonedDateTime;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notifications  {
	static int count=0;

		public static  void Notify(String string, String string2, String string3) {
			
		
		String notificationId = "abcd1234"+count++;
		  Services.get(LocalNotificationsService.class).ifPresent(service -> {
		      service.getNotifications().add(new Notification(notificationId, string,string2,
		              ZonedDateTime.now(), () -> {
		                      Alert alert = new Alert(AlertType.INFORMATION, string3);
		                      Platform.runLater(() -> alert.showAndWait());
		              }));
		  });
		
		}
}
