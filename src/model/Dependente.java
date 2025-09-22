package model;

import java.time.LocalDate;

public class Dependente extends Pessoa {

	private Parentesco parentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependenteException {
		super(nome, cpf, dataNascimento);

		if (getIdade() >= 18) {
			throw new DependenteException("Dependente deve ter menos de 18 anos!");
		}

		this.parentesco = parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	
}
