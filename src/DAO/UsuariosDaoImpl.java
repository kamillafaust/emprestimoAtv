/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Usuarios;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kamilla Faust
 */
public class UsuariosDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (cdUsuario, nome, login, senha,"
                + " logradouro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        {

            try {
                conexao = FabricaConexao.abrirConexao();
                preparando = conexao.prepareStatement(sql);
                preparando.setInt(1, usuario.getCdUsuario());
                preparando.setString(2, usuario.getNome());
                preparando.setString(3, usuario.getLogin());
                preparando.setString(4, usuario.getSenha());
                preparando.setString(5, usuario.getLogradouro());
                preparando.setString(6, usuario.getCidade());
                preparando.setString(7, usuario.getEstado());
                preparando.setString(8, usuario.getCep());
                preparando.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Erro ao salvar no banco" + e.getMessage());
            } finally {
                FabricaConexao.fecharConexao(conexao, preparando);
            }
        }
    }

    public Usuarios pesquisarPorId(int cdUsuario) throws SQLException {
        Usuarios usuario = null;
        String sql = "SELECT * FROM usuarios WHERE cdUsuario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, cdUsuario);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuarios();
                usuario.setCdUsuario(cdUsuario);
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setLogradouro(resultSet.getString("logradouro"));
                usuario.setCidade(resultSet.getString("cidade"));
                usuario.setEstado(resultSet.getString("estado"));
                usuario.setCep(resultSet.getString("cep"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return usuario;
    }

    public void alterar(Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET cdUsuario = ?, nome = ?, login = ?, senha = ?,"
                + " logradouro = ?, cidade = ?, estado = ?, cep = ? WHERE cdBibliotecario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, usuario.getCdUsuario());
            preparando.setString(2, usuario.getNome());
            preparando.setString(3, usuario.getLogin());
            preparando.setString(4, usuario.getSenha());
            preparando.setString(5, usuario.getLogradouro());
            preparando.setString(6, usuario.getCidade());
            preparando.setString(7, usuario.getEstado());
            preparando.setString(8, usuario.getCep());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(int cdUsuario) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM usuarios WHERE cdUsuario = ?");
            preparando.setInt(1, cdUsuario);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
