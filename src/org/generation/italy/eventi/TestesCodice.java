package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestesCodice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		System.out.println("Quando inizia l'evento?\t - ");
//		System.out.print("Giorno(a numero):  ");
//		String giorno = scan.nextLine();
//		System.out.print("Mese(a numero):  ");
//		String mese = scan.nextLine();
//		System.out.print("Anno(a numero):  ");
//		String anno = scan.nextLine();
//		String text = giorno + "/" + mese + "/" + anno;
// 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
//		LocalDate dataInizio = LocalDate.parse(text, formatter );
//		System.out.println("Il concerto inizia il " + dataInizio);
		LocalDate oggi = LocalDate.now();
		LocalDate domani = LocalDate.now().plusDays(1);
		LocalDate traSette = LocalDate.now().plusDays(7);
		System.out.println(oggi);
		System.out.println(domani);
		System.out.println(traSette);
		System.out.println("it's " + oggi.isBefore(domani ) + " che oggi è prima di domani.");
		
		scan.close();
	}
	

}
