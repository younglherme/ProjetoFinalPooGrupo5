package model;

public class CalculoInss implements CalculoTributos {

	@Override
	public double calcular(Funcionario funcionario) {
		double salario = funcionario.getSalarioBruto();

		if (salario > 0 && salario <= 1518.00) {
			return salario * 0.075;
		} else if (salario <= 2793.88) {
			return (salario * 0.09) - 22.77;
		} else if (salario <= 4190.83) {
			return (salario * 0.12) - 106.60;
		} else if (salario <= 8157.41) {
			return (salario * 0.14) - 190.42;
		} else {
			return 951.62;
		}
	}
}