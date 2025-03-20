package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("studente")
public class Studente extends Persona
{
	private int isee;
	private boolean esonero;


	@OneToMany(fetch = FetchType.EAGER,mappedBy = "studente")
	private List<Presenza> presenze = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "studente")
	private List<Inserimento> inserimenti = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sezione")
	private Sezione sezione;



	public Studente()
	{
	}

	public Studente(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, int isee, boolean esonero)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.isee = isee;
		this.esonero = esonero;
	}

	public Studente(String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, int isee, boolean esonero)
	{
		super(nome, cognome, dob, cf, luogoDiNascita, genere);
		this.isee = isee;
		this.esonero = esonero;
	}

	public int getIsee()
	{
		return isee;
	}

	public void setIsee(int isee)
	{
		this.isee = isee;
	}

	public boolean isEsonero()
	{
		return esonero;
	}

	public void setEsonero(boolean esonero)
	{
		this.esonero = esonero;
	}

	public List<Presenza> getPresenze()
	{
		return presenze;
	}

	public void setPresenze(List<Presenza> presenze)
	{
		this.presenze = presenze;
	}

	public List<Inserimento> getInserimenti()
	{
		return inserimenti;
	}

	public void setInserimenti(List<Inserimento> inserimenti)
	{
		this.inserimenti = inserimenti;
	}

	public Sezione getSezione()
	{
		return sezione;
	}

	public void setSezione(Sezione sezione)
	{
		this.sezione = sezione;
	}
}
