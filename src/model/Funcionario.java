package Mercado;

import java.time.LocalDate;

class Funcionario extends Pessoa {
	   
		private double salarioBruto;
	    private double descontoInss;
	    private double descontoIr;

	    public Funcionario(String nome, String cpf, LocalDate dataNascimento,double salarioBruto, double descontoInss, double descontoIr)
	                      
	    {
	        super(nome, cpf, dataNascimento);
	        this.salarioBruto = salarioBruto;
	        this.descontoInss = descontoInss;
	        this.descontoIr = descontoIr;
	    }

	    public double calcularSalarioLiquido() {
	        return salarioBruto - descontoInss - descontoIr;
	    }

	    @Override
	    public String getDescricao() {
	        return "Funcionário: " + getNome() + " | Salário líquido: " + calcularSalarioLiquido();
	    }
	}


