package dao;

import model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private Connection connection;


    public FuncionarioDao() {
        connection = new ConnectionFactory().getConnection();
    }

    //INSERIR FUNCIONANDO
    public void inserir(Funcionario funcionario) {
        String sql = "insert into funcionarios(cpf_funcionario,nome_funcionario,data_nascimento_funcionario,salario_bruto_funcionario) values(?,?,?,?)";
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
    //ATUALIZAR FUNCIONANDO
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome_funcionario=?, salario_bruto_funcionario=? WHERE cpf_funcionario=?";
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

   /*REMOVER  FUNCIONANDO
    public void remover(Funcionario funcionario) {
        String sql = "delete from funcionarios where cpf_funcionario = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(3, funcionario.getCpf());
            stmt.execute();
            stmt.close();
            connection.close();
            System.out.println("Funcionario removido com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover!");
        }
    }
  */
   public void remover(String cpf) {
       String sql = "delete from funcionarios where cpf_funcionario = ?";

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
        String sql = "select * from funcionarios";
        List<Funcionario> listaFunc = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome_funcionario"),
                        rs.getString("cpf_funcionario"),
                        rs.getDate("data_nascimento_funcionario").toLocalDate(),
                        rs.getDouble("salario_bruto_funcionario"));
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
}