package br.edu.ifrs.canoas.projetoatendimento.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String usuario = "root";
    private String senha =  "";
    
    public Connection getConexao(){
        String stringConexao = "jdbc:mysql://localhost:3306/test";
        Connection conexao = null;
        
        try {
            conexao = DriverManager.getConnection(stringConexao, 
                        this.usuario, 
                        this.senha);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
        return conexao;
    }
}
