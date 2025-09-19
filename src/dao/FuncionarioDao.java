package dao;

import model.Funcionario;
import dao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private Connection connection;


    public FuncionarioDao() {
        connection = new ConnectionFactory().getConnection();
    }

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

    public void atualizar(Funcionario funcionario) {
        String sql = "update funcionarios set nome_funcionario=?,salario_bruto_funcionario=? where cpf_funcionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.execute();
            stmt.close();
            connection.close();
            System.out.println("Funcionario atualizado com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar!");
        }
    }
    //REMOVER ESTA FUNCIONANDO
    public void remover( int codigo) {
        String sql = "delete from funcionarios where id_funcionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();
            connection.close();
            System.out.println("Funcionario removido com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover!");
        }
    }
}