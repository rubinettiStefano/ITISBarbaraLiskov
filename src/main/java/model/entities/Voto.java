package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("voto")
public class Voto extends Inserimento{
	private double punteggio;
	private String tipologia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_materia")
	private Materia materia;

	public Voto() {}

	public Voto(Long id, LocalDate dataInserimento, double punteggio, String tipologia, Materia materia) {
		super(id, dataInserimento);
		this.punteggio = punteggio;
		this.tipologia = tipologia;
		this.materia = materia;
	}

	public double getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(double punteggio) {
		this.punteggio = punteggio;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}