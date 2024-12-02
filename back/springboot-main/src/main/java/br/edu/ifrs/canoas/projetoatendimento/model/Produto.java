package br.edu.ifrs.canoas.projetoatendimento.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
    @Id
    private int id;
    private double valor;
    private String nome;
    private String descricao;
    private double peso;

    @ManyToOne
    private Marca marca;

    public void create(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT INTO produto (id, valor, nome) VALUES (?,?,?)";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.setDouble(2, this.valor);
            ps.setString(3, this.nome);
            ps.setString(4, this.descricao);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(){  
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE produto SET id =?, valor = ?, nome = ? WHERE id = ?";

        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setDouble(2, this.valor);
            ps.setString(3, this.nome);
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
    public static ArrayList<Produto> getAll(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";
        try {
            Statement  st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPeso(rs.getDouble("peso"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    public void load(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        String sql = "SELECT * FROM produto WHERE id = ?";
        try {
            PreparedStatement  ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.nome = rs.getString("nome");
                this.valor = rs.getDouble("preco");
                this.descricao = rs.getString("descricao");
                this.peso = rs.getDouble("peso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
