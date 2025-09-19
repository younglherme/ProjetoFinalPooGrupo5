package Teste2;

import java.time.LocalDate;

public class Dependentes extends Pessoa {

    private Parentesco parentesco;

    public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependentesException {
        super(nome, cpf, dataNascimento);

        LocalDate hoje = LocalDate.now();
        
        int idade = hoje.getYear() - dataNascimento.getYear();

        if (hoje.getMonthValue() < dataNascimento.getMonthValue() ||
           (hoje.getMonthValue() == dataNascimento.getMonthValue() && hoje.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }

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

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
}