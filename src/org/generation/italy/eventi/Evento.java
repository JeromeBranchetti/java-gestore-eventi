package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	//attributi
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;
	
	//costruttore
	
	public Evento(String titolo,LocalDate data , int postiTotali) throws Exception {
		
		this.titolo = titolo;
		//controllo che valore sia maggiore di zero
		if (postiTotali > 0) {
			this.postiTotali = postiTotali;
		}
		else {
			throw new Exception("Errore...Non è un valore numerico o maggiore di zero");
		}
		//controllo sulla data
		if (data.isAfter(LocalDate.now()) || data.isEqual(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Errore...la data è passata");
		}
	}

	//getters e setters 
	
	public int getPostiTotali() {
		
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		//controllo che il valore sia a lettere
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		//controllo che la data non sia già passata.
		this.data = data;
	}
	
	//metodi
	public void prenota() throws Exception {
		if(postiPrenotati < postiTotali) {
			postiPrenotati++;
		}
		else {
			throw new Exception("Errore... non ci sono più posti disponibili");
		}
	}
	
	public void disdici() throws Exception {
		if(postiPrenotati > 0 ) {
			postiPrenotati--;
		}
		else {
			throw new Exception("Errore... non ci sono prenotazioni da disdire");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return data + " - " + titolo;
	}

}
