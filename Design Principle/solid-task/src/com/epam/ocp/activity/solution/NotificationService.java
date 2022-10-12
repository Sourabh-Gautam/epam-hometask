package com.epam.ocp.activity.solution;

public class NotificationService {

	public void sendOTP(String medium) {
		if(medium.equals("email")) {
			EmailNotification notification = new EmailNotification();
			notification.send();
		}
		else if(medium.equals("message")) {
			MessageNotification notification = new MessageNotification();
			notification.send();
		}
		else if(medium.equals("email")) {
			WhatsappNotification notification = new WhatsappNotification();
			notification.send();
		}
	}
	
}
