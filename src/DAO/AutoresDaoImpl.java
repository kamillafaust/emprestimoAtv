/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Autores;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kamilla Faust
 */
public class AutoresDaoImpl implements Serializable {
    
    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Autores autores) throws SQLException {
        String sql = "INSERT INTO autores (cdAutores, nmAutor) VALUES (?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar autor " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
    public Autores pesquisarPorId(int cdAutores) throws SQLException {
        Autores autores = null;
        String sql = "SELECT * FROM autores WHERE cdAutores = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, cdAutores);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                autores = new Autores();
                autores.setCdAutores(cdAutores);
                autores.setNmAutor(resultSet.getString("nmAutor"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return autores;
    }
    
      public void alterar(Autores autores) throws SQLException {
        String sql = "UPDATE autores SET cdAutores = ?, nmAutor = ? WHERE cdAutores = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        }  finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
      public void excluir(int cdAutores) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM autores WHERE cdAutores = ?");
            preparando.setInt(1, cdAutores);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }  
}
