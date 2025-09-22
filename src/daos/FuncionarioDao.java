package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao(Connection connection) {
		this.connection = connection;
	}

	//Insert
	public void inserir(Funcionario funcionario) {
		String sql = "insert into funcionario (nome, cpf, data_nascimento, salario_bruto) values (?, ?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
			stmt.setDouble(4, funcionario.getSalarioBruto());
			stmt.executeUpdate();
			
			System.out.println("Funcionário inserido com sucesso!");
			
		} catch (SQLException e) {
			
			if (e.getMessage().contains("duplicate key")) {
				
				System.err.println("Já existe funcionário com CPF: " + funcionario.getCpf());
				
			} else {
				System.err.println("Erro ao inserir funcionário: " + e.getMessage());
			}
		}
	}
	
	
	//Update
	public void atualizar(Funcionario funcionario) {
		String sql = "update funcionario set nome = ?, salario_bruto = ? where cpf = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, funcionario.getNome());
			stmt.setDouble(2, funcionario.getSalarioBruto());
			stmt.setString(3, funcionario.getCpf());
			stmt.execute();
			
			System.out.println("Funcionário atualizado com sucesso!");
			
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar funcionário: " + e.getMessage());
		}
	}
	
	
	// Delete
	public void remover(String cpf) {
		String sql = "delete from funcionario where cpf = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			stmt.execute();

			System.out.println("Funcionário removido com sucesso!");

		} catch (SQLException e) {
			System.err.println("Erro ao remover funcionário: " + e.getMessage());
		}
	}
}

