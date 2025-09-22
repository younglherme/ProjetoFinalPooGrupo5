package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Dependente;

public class DependenteDao {

	private Connection connection;

	public DependenteDao(Connection connection) {
		this.connection = connection;
	}

	//Insert
	public void inserir(Dependente dependente, int idFuncionario) {
		String sql = "insert into dependente (nome, cpf, data_nascimento, parentesco, id_funcionario) values (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, dependente.getNome());
			stmt.setString(2, dependente.getCpf());
			stmt.setDate(3, Date.valueOf(dependente.getDataNascimento()));
			stmt.setString(4, dependente.getParentesco().name());
			stmt.setInt(5, idFuncionario);

			stmt.executeUpdate();
			
			System.out.println("Dependente inserido com sucesso!");
			
		} catch (SQLException e) {
			if (e.getMessage().contains("duplicate key")) {
				System.err.println("Já existe dependente com CPF: " + dependente.getCpf());
			} else {
				System.err.println("Erro ao inserir dependente: " + e.getMessage());
			}
		}
	}

	// UPDATE
    public void atualizar(Dependente dependente, int idFuncionario) {
        String sql = "update dependente set nome = ?, parentesco = ?, id_funcionario = ? where cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getParentesco().name());
            stmt.setInt(3, idFuncionario);
            stmt.setString(4, dependente.getCpf());

            stmt.execute();
            System.out.println("Dependente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dependente: " + e.getMessage());
        }
    }
	
	// Delete
	public void remover(String cpf) {
		String sql = "delete from dependente where cpf = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			stmt.execute();

			System.out.println("Funcionário removido com sucesso!");

		} catch (SQLException e) {
			System.err.println("Erro ao remover funcionário: " + e.getMessage());
		}
	}
}

