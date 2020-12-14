/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Emprestimo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kamilla Faust
 */
public class EmprestimoDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (cdEmprestimo, cdUsuario, cdBibliotecario, cdLivro, "
                + "dtDevolucao, dtRetirada) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, emprestimo.getCdEmprestimo());
            preparando.setInt(2, emprestimo.getCdUsuario());
            preparando.setInt(3, emprestimo.getCdBibliotecario());
            preparando.setInt(4, emprestimo.getCdLivro());
            preparando.setString(5, emprestimo.getDtDevolucao());
            preparando.setString(6, emprestimo.getDtRetirada());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar academico " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Emprestimo pesquisarPorId(int cdEmprestimo) throws SQLException {
        Emprestimo emprestimo = null;
        String sql = "SELECT * FROM emprestimo WHERE cdEmprestimo = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, cdEmprestimo);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setCdEmprestimo(cdEmprestimo);
                emprestimo.setCdUsuario(resultSet.getInt("cdUsuario"));
                emprestimo.setCdBibliotecario(resultSet.getInt("cdBibliotecario"));
                emprestimo.setCdLivro(resultSet.getInt("cdLivro"));
                emprestimo.setDtDevolucao(resultSet.getString("dtDevolucao"));
                emprestimo.setDtRetirada(resultSet.getString("dtRetirada"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return emprestimo;
    }

    public void alterar(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET cdEmprestimo = ?, cdUsuario = ?, cdBibliotecario = ?,"
                + " cdLivro = ?, dtDevolucao = ?, dtRetirada = ? WHERE cdEmprestimo = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, emprestimo.getCdEmprestimo());
            preparando.setInt(2, emprestimo.getCdUsuario());
            preparando.setInt(3, emprestimo.getCdBibliotecario());
            preparando.setInt(4, emprestimo.getCdLivro());
            preparando.setString(5, emprestimo.getDtDevolucao());
            preparando.setString(6, emprestimo.getDtRetirada());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao alterar " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(int cdEmprestimo) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM emprestimo WHERE cdEmprestimo = ?");
            preparando.setInt(1, cdEmprestimo);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}
