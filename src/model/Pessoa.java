package model;

import java.time.LocalDate;

public class Pessoa {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
		
	public int getIdade() {
		LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataNascimento.getYear();
    }

}
