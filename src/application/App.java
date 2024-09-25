package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalPayment;

public class App {

	public static void main(String[] args) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
	
		Contract contract = new Contract(date, totalValue, number);
		
		System.out.print("Entre com o número de parcelas: ");
		Integer parcelas = sc.nextInt();
		sc.nextLine();
	
		ContractService service = new ContractService(new PayPalPayment());
		service.processContract(contract, parcelas);
		
		for(Installment ct : contract.getInstallments()) {
			System.out.println(ct);
		}
		
	}

}
