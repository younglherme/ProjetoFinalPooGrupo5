package model;

import java.time.LocalDate;

public class FolhaPagamento {
	private int codigo;
	private Funcionario funcionario;
	private LocalDate dataPagamento;
	private double descontoInss;
	private double descontoIr;
	private double salarioLiquido;

	public FolhaPagamento(int codigo, Funcionario funcionario) {
		this.codigo = codigo;
		this.funcionario = funcionario;
		this.dataPagamento = LocalDate.now();
		calcular(); 
	}

	private void calcular() {
		
		CalculoTributos calcInss = new CalculoInss();
		CalculoTributos calcIr = new CalculoIr();

		
		descontoInss = calcInss.calcular(funcionario);
		funcionario.setDescontoInss(descontoInss);

		descontoIr = calcIr.calcular(funcionario);
		funcionario.setDescontoIr(descontoIr);

		
		salarioLiquido = funcionario.getSalarioBruto() - descontoInss - descontoIr;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public double getDescontoIr() {
		return descontoIr;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	 @Override
	    public String toString() {
	        return funcionario.getNome() + ";" +
	               funcionario.getCpf() + ";" +
	               String.format("%.2f", descontoInss) + ";" +
	               String.format("%.2f", descontoIr) + ";" +
	               String.format("%.2f", salarioLiquido);
	    }
	}