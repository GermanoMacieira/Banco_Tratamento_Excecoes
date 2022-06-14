package appMain;

import java.util.Locale;
import java.util.Scanner;

import model.Conta;
import excecoes.BusinessException;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta:");
		System.out.print("Numero da Conta: ");
		int numero = sc.nextInt();
		System.out.print("Nome do Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limite = sc.nextDouble();

		Conta acc = new Conta(numero, titular, saldo, limite);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double valor = sc.nextDouble();
		
		try {
			acc.limite(valor);
			System.out.printf("Novo saldo: %.2f%n", acc.getSaldo());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
