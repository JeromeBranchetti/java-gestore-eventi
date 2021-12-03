package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	private static int nextInt(Scanner scanner) {
		int n = scanner.nextInt();
		scanner.nextLine();
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		/**
		 * prendo i dati dall'utente per generare il mio evento
		 * nome evento
		 * capacità evento
		 * data evento 
		 */
		
		System.out.print("Che tipo di evento abbiamo? ");
		String titolo = scan.nextLine();
		System.out.print("Quanto è la capacità totale? ");
		Evento ev;
		try {
			int maxCap = nextInt(scan);
			/**
			 * parte di codice dedicata alla data e formattazione
			 * prende 
			 * 		- giorno
			 * 		- mese
			 * 		- anno
			 */		
			 
			System.out.println("Quando inizia l'evento? ");
			System.out.print("Giorno(a numero):  ");
			String giorno = scan.nextLine();
			System.out.print("Mese(a numero):  ");
			String mese = scan.nextLine();
			System.out.print("Anno(a numero):  ");
			String anno = scan.nextLine();
			String text = giorno + "/" + mese + "/" + anno;
	 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
			LocalDate dataInizio = LocalDate.parse(text, formatter );
			
			// provo a creare un oggetti di tipo evento
			ev = new Evento(titolo, dataInizio, maxCap);
			System.out.print("Oggi abbiamo un " + ev.getTitolo());
			System.out.println(" con " + ev.getPostiTotali() + " posti Totali.");
			String risposta = "";
			int numPrenotatiRichiesti;
			int numDisdettiRichiesti;
			int numPrenotazioni = 0;
			
			
			System.out.print("Vuoi prenotare (s/n) ");
			int numPrenotatiPossibili = 0;
			risposta = scan.nextLine();
			if(risposta.equals("s")) {
				
				System.out.print("Quanti posti? ");
				numPrenotatiRichiesti = Integer.parseInt(scan.nextLine());
				
				try {
					for (int i = 0; i < numPrenotatiRichiesti; i++) {
						ev.prenota();
						numPrenotatiPossibili++;
					} 
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ci è stato solo possibile prenotare " + numPrenotatiPossibili + " posti.");
					System.out.println("Le altre " + (numPrenotatiRichiesti - numPrenotatiPossibili) + " sono state declinate.");
				}
				numPrenotazioni = numPrenotatiPossibili;
				
			}
			else if (risposta.equals("n")){
				System.out.println("Ok. lo annoto.");
				
			}
			else {
				throw new Exception("Scusi non è tra le opzioni");
				}
			System.out.println("Numero di posti prenotati: " + numPrenotazioni);
			System.out.println("Numero di posti disponibili " + (maxCap - numPrenotazioni));
			
			System.out.print("Vuoi disdire (s/n) -");
			risposta = scan.nextLine();
			int numDisdettiPossibili = 0;
			if(risposta.equals("s")) {
				
				System.out.print("Quanti posti? ");
				numDisdettiRichiesti = Integer.parseInt(scan.nextLine());
				try {
					for (int i = 0; i < numDisdettiRichiesti; i++) {
						ev.disdici();
						numDisdettiPossibili++;
					} 
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ci è stato solo possibile disdire " + numDisdettiPossibili + " posti.");
					System.out.println("Le altre" + (numDisdettiRichiesti - numDisdettiPossibili) + "sono state declinate.");
				}
			}
				else if (risposta.equals("n")){
					System.out.println("Ok. lo annoto.");
				}
				else {
					throw new Exception("Scusi non è tra le opzioni");
					}
				numPrenotazioni -= numDisdettiPossibili;
				System.out.println("Numero di posti prenotati: " + numPrenotazioni);
				System.out.println("Numero di posti disponibili " + (maxCap - numPrenotazioni));
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Evento ev2;
		try {
			ev2 = new Evento("casa", LocalDate.now(), 1000);
			System.out.println(ev2.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();		
	}

}
