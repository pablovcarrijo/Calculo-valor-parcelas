package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private LocalDate start;
	private Double totalValue;
	private Integer number;
	
	private List<Installment> installments = new ArrayList<>();
	
	public Contract(LocalDate start, Double totalValue, Integer number) {
		this.totalValue = totalValue;
		this.start = start;
		this.number = number;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public List<Installment> getInstallments(){
		return this.installments;
	}
	
}
