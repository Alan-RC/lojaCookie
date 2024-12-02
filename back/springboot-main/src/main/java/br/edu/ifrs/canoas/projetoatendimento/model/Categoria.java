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
public class Categoria {
    @Id
    private int id;
    private String descricao;

    public void create(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT INTO produto (id, valor, nome) VALUES (?,?,?)";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2, this.descricao);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(){  
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE produto SET id = ?, descricao = ? WHERE id = ?";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2,this.descricao);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete() {
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
    
        String sql = "DELETE FROM categoria WHERE id = ?";
    
        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static ArrayList<Categoria> getAll() {
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Categoria> categorias = new ArrayList<>();  // Changed variable name to 'categorias'
    
        String sql = "SELECT * FROM categoria";
        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria categoria = new Categoria();  // Keep this as 'categoria', representing a single object.
                categoria.setId(rs.getInt("Id"));
                categoria.setDescricao(rs.getString("Descricao"));
                
                categorias.add(categoria);  // Add the object to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;  // Return the list of categories
    }
    
    public void load(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.id = rs.getInt("Id");
                this.descricao = rs.getString("Descricao");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
