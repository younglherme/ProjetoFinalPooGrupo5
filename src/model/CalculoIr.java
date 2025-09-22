package model;

public class CalculoIr implements CalculoTributos {

	@Override
	public double calcular(Funcionario funcionario) {
		double salario = funcionario.getSalarioBruto();
		double descontoInss = new CalculoInss().calcular(funcionario);

		double baseCalculo = salario - descontoInss - (funcionario.getQtdDependentes() * VALORPORDEPENDENTE);

		if (baseCalculo <= 2259.00) {
			return 0.0;
		} else if (baseCalculo <= 2826.65) {
			return (baseCalculo * 0.075) - 169.44;
			
		} else if (baseCalculo <= 3751.05) {
			return (baseCalculo * 0.15) - 381.44;
			
		} else if (baseCalculo <= 4664.68) {
			return (baseCalculo * 0.225) - 662.77;
			
		} else {
			return (baseCalculo * 0.275) - 896.00;
			
		}
	}
}
