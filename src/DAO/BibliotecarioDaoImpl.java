/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Bibliotecario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kamilla Faust
 */
public class BibliotecarioDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "INSERT INTO bibliotecario (cdBibliotecario, login, senha,"
                + " nome, logradouro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, bibliotecario.getCdBibliotecario());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getNome());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCep());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
    
    public Bibliotecario pesquisarPorId(int cdBibliotecario) throws SQLException {
        Bibliotecario bibliotecario = null;
        String sql = "SELECT * FROM bibliotecario WHERE cdBibliotecario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, cdBibliotecario);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                bibliotecario = new Bibliotecario();
                bibliotecario.setCdBibliotecario(cdBibliotecario);
                bibliotecario.setLogin(resultSet.getString("login"));
                bibliotecario.setSenha(resultSet.getString("senha"));
                bibliotecario.setNome(resultSet.getString("nome"));
                bibliotecario.setLogradouro(resultSet.getString("logradouro"));
                bibliotecario.setCidade(resultSet.getString("cidade"));
                bibliotecario.setEstado(resultSet.getString("estado"));
                bibliotecario.setCep(resultSet.getString("cep"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return bibliotecario;
    }

    public void alterar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "UPDATE bibliotecario SET cdBibliotecario = ?, login = ?, senha = ?,"
                + " nome = ?, logradouro = ?, cidade = ?, estado = ?, cep = ? WHERE cdBibliotecario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, bibliotecario.getCdBibliotecario());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getNome());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCep());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        }  finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(int cdBibliotecario) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM bibliotecario WHERE cdBibliotecario = ?");
            preparando.setInt(1, cdBibliotecario);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
