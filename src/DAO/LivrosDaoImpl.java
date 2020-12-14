/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kamilla Faust
 */
public class LivrosDaoImpl {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Livros livro) throws SQLException {
        String sql = "INSERT INTO livros (cdLivro, titulo, resumo, dtPublicacao,  edicao, "
                + " nmEditora, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, livro.getCdLivro());
            preparando.setString(2, livro.getTitulo());
            preparando.setString(3, livro.getResumo());
            preparando.setString(4, livro.getDtPublicacao());
            preparando.setString(5, livro.getEdicao());
            preparando.setString(6, livro.getNmEditora());
            preparando.setString(7, livro.getCidade());
            preparando.setString(8, livro.getEstado());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Livros pesquisarPorId(int cdLivro) throws SQLException {
        Livros livro = null;
        String sql = "SELECT * FROM livros WHERE cdLivro = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, cdLivro);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                livro = new Livros();
                livro.setCdLivro(cdLivro);
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setResumo(resultSet.getString("resumo"));
                livro.setDtPublicacao(resultSet.getString("dtPublicacao"));
                livro.setEdicao(resultSet.getString("edicao"));
                livro.setNmEditora(resultSet.getString("nmEditora"));
                livro.setCidade(resultSet.getString("cidade"));
                livro.setEstado(resultSet.getString("estado"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return livro;
    }

    public void alterar(Livros livro) throws SQLException {
        String sql = "UPDATE livros SET cdLivro = ?, titulo = ?, resumo = ?, "
                + " dtPublicacao = ?,  edicao = ?, "
                + " nmEditora = ?, cidade = ?, estado = ? WHERE cdLivro = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, livro.getCdLivro());
            preparando.setString(2, livro.getTitulo());
            preparando.setString(3, livro.getResumo());
            preparando.setString(4, livro.getDtPublicacao());
            preparando.setString(5, livro.getEdicao());
            preparando.setString(6, livro.getNmEditora());
            preparando.setString(7, livro.getCidade());
            preparando.setString(8, livro.getEstado());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(int cdLivro) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM livros WHERE cdLivro = ?");
            preparando.setInt(1, cdLivro);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
