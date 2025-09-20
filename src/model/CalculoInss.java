package Tributo;

public class CalculoInss implements CalculoTributos {
	
		public double descontoInss;
		public Funcionario funcionario;
		

		public double descontoInss() {
			return descontoInss;
		}
		
		@Override
		public double calcular(Funcionario funcionario) {
			double salario = funcionario.getSalarioBruto();
			descontoInss = funcionario.getDescontoInss();
			
		if(salario > 0 && salario <= 1518) {
			return descontoInss = salario * 0.075;
	}
		else if(salario >= 1518.01 && salario <= 2793.88) {
			return descontoInss = (salario * 0.09) - 22.77;
		}
		else if(salario >= 2793.89 && salario <= 4190.83) {
			return descontoInss = (salario * 0.12) - 106.60;
		}
		else if(salario >= 4190.84) {
			return descontoInss = (salario * 0.14) - 190.42;
		} else {
			return 0;
		}
			
	}
}