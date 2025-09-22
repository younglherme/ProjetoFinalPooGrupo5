package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {

	private int id;
	private double salarioBruto;
    private double descontoInss;
    private double descontoIr;
    private List<Dependente> dependentes;
    
    
    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }
    public Funcionario(int id, String nome, String cpf,LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.id = id;
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<>();
    }
    
    public List<Dependente> getDependentes() { 
    	return dependentes; }
    
    public void adicionarDependente(Dependente d) { 
    	dependentes.add(d);
    	}
    public int getQtdDependentes() { 
    	return dependentes.size(); }

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public double getDescontoIr() {
		return descontoIr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id){ 
		this.id = id; 
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public void setDescontoIr(double descontoIr) {
		this.descontoIr = descontoIr;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
    
    
    
}

