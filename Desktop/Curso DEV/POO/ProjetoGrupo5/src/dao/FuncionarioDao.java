package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDao {
    private Connection connection;


    public FuncionarioDao() {
        connection = new ConnectionFactory().getConnection();
    }


    public void inserir(Funcionario funcionario) {
        String sql = "insert into funcionario(cpf,nome,data_nascimento,salario_bruto) values(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.execute();
            stmt.close();
            connection.close();
            System.out.println("Conta criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao gravar registro de cliente"+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome=?, salario_bruto=? WHERE cpf=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(2, funcionario.getSalarioBruto());
            stmt.setString(3, funcionario.getCpf());
            stmt.execute();
            stmt.close();
            connection.close();
            System.out.println("Funcionario atualizado com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar!");
        }
    }

    public void remover(String cpf) {
        String sql = "delete from funcionario where cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionário com CPF : " + cpf + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum funcionário encontrado com o CPF : " + cpf + ".");
            }
            System.out.println("Funcionario removido com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover!"+ e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Funcionario> listar() {

        connection = new ConnectionFactory().getConnection();
        String sql = "select * from funcionario";
        List<Funcionario> listaFunc = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getDouble("salario_bruto"));
                listaFunc.add(funcionario);
            }
            stmt.close();
            rs.close();
            connection.close();
            System.out.println("\n ***Listagem de Funcionarios***");
        } catch (SQLException e) {
            System.out.println("Erro na listagem de contas!");
            e.printStackTrace();
        }
        return listaFunc;
    }

    public String cpfExisteBanco(Funcionario funcionario) throws SQLException {
        String nome = null;
        String sql = "SELECT nome FROM funcionario WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCpf());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nome = rs.getString("nome");
                    return nome;
                } else {
                    return "Esse funcionario nao existe";
                }
            }
        }
    }

}