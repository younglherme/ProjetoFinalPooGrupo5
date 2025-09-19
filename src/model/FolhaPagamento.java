package Tributo;

import java.time.LocalDate;

public class FolhaPagamento {

	private String codigo;
	private Funcionario funcionario;
	private LocalDate dataPagamento;
	private double descontoInss;
	private double descontoIr;
	private double salarioLiquido;
	

	public FolhaPagamento(String codigo, Funcionario funcionario, LocalDate dataPagamento, CalculoInss descontoINSS, CalculoIr descontoIR,
			double salarioLiquido) {

		this.codigo = codigo;
		this.funcionario = funcionario;
		this.dataPagamento = dataPagamento;
		this.descontoInss = descontoInss;
		this.descontoIr = descontoIr;
		this.salarioLiquido = salarioLiquido;
	}

	public String getCodigo() {
		return codigo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public double getDescontoINSS() {
		return descontoInss;
	}

	public double getDescontoIR() {
		return descontoIr;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	@Override

	public String toString() {
		return String.format("FolhaPagamento[cod=%s, funcionario=%s, data=%s, INSS=%.2f, IR=%.2f, líquido=%.2f]",
				codigo, funcionario.getNome(), dataPagamento, descontoInss, descontoIr, salarioLiquido);
	}
	public double calculaSalarioLiquido() {
		if (funcionario.getSalarioBruto()>=2259.21) {
			return salarioLiquido = funcionario.getSalarioBruto() - funcionario.getDescontoInss() - funcionario.getDescontoIr();
		}
		else {
			return salarioLiquido = funcionario.getSalarioBruto() - funcionario.getDescontoInss();
		}
		
	}
	
}