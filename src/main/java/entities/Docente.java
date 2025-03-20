package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("docente")
public class Docente extends Persona
{
	private String iban;
	private double stipendioMensile;

	//Padre di Inserimento
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "docente")
	private List<Inserimento> inserimenti = new ArrayList<>();

	//Figlio di Materia
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_materia")
	private Materia materia;

	//TODO
	//RELAZIONE N-N con SEZIONE che vediamo alla fine

	public Docente()
	{
	}

	public Docente(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, String iban, double stipendioMensile)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.iban = iban;
		this.stipendioMensile = stipendioMensile;
	}

	public Docente(String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, String iban, double stipendioMensile)
	{
		super(nome, cognome, dob, cf, luogoDiNascita, genere);
		this.iban = iban;
		this.stipendioMensile = stipendioMensile;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public double getStipendioMensile()
	{
		return stipendioMensile;
	}

	public void setStipendioMensile(double stipendioMensile)
	{
		this.stipendioMensile = stipendioMensile;
	}

	public List<Inserimento> getInserimenti()
	{
		return inserimenti;
	}

	public void setInserimenti(List<Inserimento> inserimenti)
	{
		this.inserimenti = inserimenti;
	}

	public Materia getMateria()
	{
		return materia;
	}

	public void setMateria(Materia materia)
	{
		this.materia = materia;
	}
}
