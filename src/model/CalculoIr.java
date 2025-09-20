package Tributo;

public class CalculoIr implements CalculoTributos {
	
	public double descontoIr;
	
	CalculoInss inss = new CalculoInss();

	@Override
	public double calcular(Funcionario funcionario) {
		double salario = funcionario.getSalarioBruto();
		descontoIr = funcionario.getDescontoIr();
		
		if(salario <= 2259) {
			return 0;
		}
		else if(salario >= 2259.21 && salario <= 2826.65) {
			return descontoIr = ((salario - VALORPORDEPENDENTE - inss.descontoInss()) * 7.5) - 169.44;
		}
		else if(salario >= 2826.66 && salario <= 3751.05) {
			return descontoIr = ((salario - VALORPORDEPENDENTE - inss.descontoInss()) * 15) - 381.44;
		}
		else if(salario >= 3751.06 && salario <= 4664.68) {
			return descontoIr = ((salario - VALORPORDEPENDENTE - inss.descontoInss()) * 22.5) - 662.77;
		}
		else if(salario > 4664.68) {
			return descontoIr = ((salario - VALORPORDEPENDENTE - inss.descontoInss()) * 27.5) - 896.00;
		}
		return 0;
	}
	
}
