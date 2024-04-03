package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract details");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Date (dd/mm/yyyy): ");
        LocalDate localDate = LocalDate.parse(sc.next(), dateTimeFormatter);

        System.out.print("Contract value: ");
        double value = sc.nextDouble();

        Contract contract = new Contract(number, localDate, value);

        System.out.print("number of installments: ");
        int numberInstallments = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, numberInstallments);

        System.out.println("Installments: ");
        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
    }
}
