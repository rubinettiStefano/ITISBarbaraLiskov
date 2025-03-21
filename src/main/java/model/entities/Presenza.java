package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//Posso creare delle query direttamente nelle entità da usare nel resto del programma (vedi riga 28 del DAO)
//@NamedQuery(name = "findAll",query = "SELECT p FROM Presenza p")
public class Presenza extends BaseEntity
{

	private LocalDate giorno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_studente")
	private Studente studente;

	public Presenza()
	{
	}

	public Presenza(Long id, LocalDate giorno)
	{
		super(id);
		this.giorno = giorno;
	}

	public LocalDate getGiorno()
	{
		return giorno;
	}

	public void setGiorno(LocalDate giorno)
	{
		this.giorno = giorno;
	}

	public Studente getStudente()
	{
		return studente;
	}

	public void setStudente(Studente studente)
	{
		this.studente = studente;
	}
}
