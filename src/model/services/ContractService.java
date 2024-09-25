package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService paymentService;
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public OnlinePaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		
		double basicQuota = contract.getTotalValue()/months;
		
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getStart().plusMonths(i);
			double interest = paymentService.interest(basicQuota, i);
			double paymentFree = paymentService.paymentFree(basicQuota + interest);
			double quota = interest + basicQuota + paymentFree;
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}
	
}
