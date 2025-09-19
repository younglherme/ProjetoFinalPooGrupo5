package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String url ="jdbc:postgresql://localhost:5432/ProjetoFinal5";
    String usuario ="postgres";
    String senha="12345";

    public Connection connection;

    public Connection getConnection(){
        System.out.println("Conectando no banco de dados...");

        try{
            connection = DriverManager.getConnection(url, usuario,senha);
            if(connection != null){
                System.out.println("Conectado com sucesso!");
            }
            else{
                System.out.println("Erro nos dados da conexão!");
            }
        }catch (SQLException E){
            System.out.println("Não foi possivel conectar...");
        }
        return connection;
    }

}