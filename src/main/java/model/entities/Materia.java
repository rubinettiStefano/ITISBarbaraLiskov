package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Materia extends BaseEntity {
	private String nome, disciplina;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "materia")
	List<Docente> docenti = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "materia")
	List<Voto> voti = new ArrayList<>();

	public Materia() {}

	public Materia(Long id, String nome, String disciplina) {
		super(id);
		this.nome = nome;
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}