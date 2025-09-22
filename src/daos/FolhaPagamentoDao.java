package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.CalculoInss;
import model.CalculoIr;
import model.Funcionario;

public class FolhaPagamentoDao {

	private Connection connection;

	public FolhaPagamentoDao(Connection connection) {
		this.connection = connection;
	}

	//Insert usando CPF do funcionario
	 public void inserirPorCpf(String cpf) {
	        String sqlFuncionario = "SELECT id_funcionario, nome, cpf, data_nascimento, salario_bruto FROM funcionario WHERE cpf = ?";

	        try (PreparedStatement stmtFunc = connection.prepareStatement(sqlFuncionario)) {
	            stmtFunc.setString(1, cpf);

	            try (ResultSet rs = stmtFunc.executeQuery()) {
	                if (rs.next()) {
	                    
	                    Funcionario funcionario = new Funcionario(
	                        rs.getInt("id_funcionario"),
	                        rs.getString("nome"),
	                        rs.getString("cpf"),
	                        rs.getDate("data_nascimento").toLocalDate(),
	                        rs.getDouble("salario_bruto")
	                    );

	                    
	                    CalculoInss calcInss = new CalculoInss();
	                    CalculoIr calcIr = new CalculoIr();

	                    double descontoInss = calcInss.calcular(funcionario);
	                    double descontoIr = calcIr.calcular(funcionario);
	                    double salarioLiquido = funcionario.getSalarioBruto() - descontoInss - descontoIr;

	                   
	                    String sqlFolha = "insert into folha_pagamento (id_funcionario, data_pagamento, "
	                    		+ "desconto_inss, desconto_ir, salario_liquido) values (?, ?, ?, ?, ?)";
	                    
	                    try (PreparedStatement stmtFolha = connection.prepareStatement(sqlFolha)) {
	                        stmtFolha.setInt(1, funcionario.getId());
	                        stmtFolha.setDate(2, Date.valueOf(LocalDate.now()));
	                        stmtFolha.setDouble(3, descontoInss);
	                        stmtFolha.setDouble(4, descontoIr);
	                        stmtFolha.setDouble(5, salarioLiquido);

	                        stmtFolha.executeUpdate();
	                        System.out.println("Folha de pagamento gerada para " + funcionario.getNome());
	                    }

	                } else {
	                    System.out.println("Nenhum funcionário encontrado com CPF: " + cpf);
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao gerar folha: " + e.getMessage());
	        }
	    }
	 
	// Delete
	    public void remover(int idFolha) {
	        String sql = "delete from folha_pagamento where id_folha = ?";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idFolha);
	            stmt.execute();
	            System.out.println("Folha removida com sucesso!");
	            
	        } catch (SQLException e) {
	            System.err.println("Erro ao remover folha: " + e.getMessage());
	        }
	    }
	}