package model.entities;

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




	@ManyToMany(fetch = FetchType.EAGER)
	//crea una tabella nel db. chiamata docente_to_sezione
	//con una f.k verso docente chiamata id_docente
	//e una verso sezione chiamata id_sezione
	//la usa in automatico per creare i collegamenti
	@JoinTable
	(
			name = "docente_to_sezione",
			joinColumns = @JoinColumn(name = "id_docente"),
			inverseJoinColumns = @JoinColumn(name = "id_sezione")
	)
	private List<Sezione> sezioni = new ArrayList<>();


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

	public List<Sezione> getSezioni()
	{
		return sezioni;
	}

	public void setSezioni(List<Sezione> sezioni)
	{
		this.sezioni = sezioni;
	}
}
