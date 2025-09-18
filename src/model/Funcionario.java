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

	    
	    public double getSalarioBruto() {
			return salarioBruto;
		}


		public double getDescontoInss() {
			return descontoInss;
		}

		public void setDescontoInss(double descontoInss) {
			this.descontoInss = descontoInss;
		}

		public double getDescontoIr() {
			return descontoIr;
		}

		public void setDescontoIr(double descontoIr) {
			this.descontoIr = descontoIr;
		}

		public void setSalarioBruto(double salarioBruto) {
			this.salarioBruto = salarioBruto;
		}

		public double calcularSalarioLiquido() {
	        return salarioBruto - descontoInss - descontoIr;
	    }

	    @Override
	    public String getDescricao() {
	        return "Funcionário: " + getNome() + " | Salário líquido: " + calcularSalarioLiquido();
	    }
	}


