package br.edu.ifrs.canoas.projetoatendimento.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Usuario {
    @Id
    private int id;
    private String nome;

    public void create(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT INTO categoria (id, nome) VALUES (?,?)";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.setString(2, this.nome);
       
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(){  
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE usuario SET id = ?, nome = ? WHERE id = ?";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2,this.nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete() {
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
    
        String sql = "DELETE FROM usuario WHERE id = ?";
    
        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Usuario> getAllUsuarios() {
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();  // List to hold the Usuario objects
    
        String sql = "SELECT * FROM usuario";
        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("Id"));
                usuario.setNome(rs.getString("Nome"));
    
                usuarios.add(usuario);  // Add the Usuario object to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;  // Return the list of Usuario objects
    }
    
    
    public void load(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.id = rs.getInt("Id");
                this.nome = rs.getString("Nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
