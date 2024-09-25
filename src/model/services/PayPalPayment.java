package model.services;

public class PayPalPayment implements OnlinePaymentService{

	public Double paymentFree(Double amount) {
		return amount * 0.02;
	}
	
	public Double interest(Double amount, Integer months) {
		return amount * 0.01 * months;
	}
	
}
