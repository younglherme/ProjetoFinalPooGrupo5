public class FolhaPagamento {

	private String codigo;
	private Funcionario funcionario;
	private LocalDate dataPagamento;
	private CalculoInss descontoInss;
	private CalculoIr descontoIr;
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

	public BigDecimal getDescontoINSS() {
		return descontoINSS;
	}

	public BigDecimal getDescontoIR() {
		return descontoIR;
	}

	public BigDecimal getSalarioLiquido() {
		return salarioLiquido;
	}

	@Override

	public String toString() {
		return String.format("FolhaPagamento[cod=%s, funcionario=%s, data=%s, INSS=%.2f, IR=%.2f, líquido=%.2f]",
				codigo, funcionario.getNome(), dataPagamento, descontoINSS, descontoIR, salarioLiquido);
	}
	public double calculasalario() {
		if (funcionario.getSalarioBruto()>=2259.21 && funcionario.getSalarioBruto() <= ) {
			return salarioLiquido = funcionario.getSalarioBruto() - descontoInss - descontoIr;
		}
		else
		
	}
	
}