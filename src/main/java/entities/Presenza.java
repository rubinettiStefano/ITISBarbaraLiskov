package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
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
