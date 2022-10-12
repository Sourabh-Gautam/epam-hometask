package com.epam.dip.activity.solution;

public class TicketBookingApp {
	private PaymentCard paymentCard;
	
	public TicketBookingApp(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}
	
	public void doPayment(int noOfTickets, int amount) {
		paymentCard.doTransaction(amount);
	}
	
	public static void main(String[] args) {
		PaymentCard paymentCard = new CreditCard();
		TicketBookingApp ticketApp = new TicketBookingApp(paymentCard);
		ticketApp.doPayment(4,5000);
	}

}
