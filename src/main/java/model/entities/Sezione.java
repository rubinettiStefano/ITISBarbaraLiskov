package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sezione extends BaseEntity {
	private int anno;
	private char lettera;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "sezione")
	List<Studente> studenti = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "sezioni")
	private List<Docente> docenti = new ArrayList<>();



	public Sezione() {}

	public Sezione(Long id, int anno, char lettera, List<Studente> studenti) {
		super(id);
		this.anno = anno;
		this.lettera = lettera;
		this.studenti = studenti;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public char getLettera() {
		return lettera;
	}

	public void setLettera(char lettera) {
		this.lettera = lettera;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	public List<Docente> getDocenti()
	{
		return docenti;
	}

	public void setDocenti(List<Docente> docenti)
	{
		this.docenti = docenti;
	}
}