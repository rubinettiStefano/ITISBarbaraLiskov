package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.STRING)
public class Inserimento extends BaseEntity {
	private LocalDate dataInserimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_studente")
	private Studente studente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	private Docente docente;


	public Inserimento() {}

	public Inserimento(Long id, LocalDate dataInserimento) {
		super(id);
		this.dataInserimento = dataInserimento;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
}