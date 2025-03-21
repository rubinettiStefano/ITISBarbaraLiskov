package model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("nota")

public class Nota extends Inserimento {
	private String descrizione;
	private boolean disciplinare;



	public Nota() {}

	public Nota(Long id, LocalDate dataInserimento, String descrizione, boolean disciplinare) {
		super(id, dataInserimento);
		this.descrizione = descrizione;
		this.disciplinare = disciplinare;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isDisciplinare() {
		return disciplinare;
	}

	public void setDisciplinare(boolean disciplinare) {
		this.disciplinare = disciplinare;
	}
}