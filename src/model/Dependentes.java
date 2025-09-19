package Teste2;

import java.time.LocalDate;
import java.time.Period;

public class Dependentes extends Pessoa {
    private Parentesco parentesco;

    public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependentesException {
        super(nome, cpf, dataNascimento);
        
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        
        if (idade >= 18) {
            throw new DependentesException("O dependente '" + nome + "' deve ser menor de 18 anos.");
        }

        this.parentesco = parentesco;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", parentesco=" + parentesco +
                '}';
    }
}