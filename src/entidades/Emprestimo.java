/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Kamilla Faust
 */
public class Emprestimo implements Serializable {
    
    private int cdEmprestimo; 
    private int cdUsuario; 
    private int cdBibliotecario; 
    private int cdLivro; 
    private String dtDevolucao; 
    private String dtRetirada; 

    public Emprestimo() {
    }

    public Emprestimo(int cdEmprestimo, int cdUsuario, int cdBibliotecario, int cdLivro, String dtDevolucao, String dtRetirada) {
        this.cdEmprestimo = cdEmprestimo;
        this.cdUsuario = cdUsuario;
        this.cdBibliotecario = cdBibliotecario;
        this.cdLivro = cdLivro;
        this.dtDevolucao = dtDevolucao;
        this.dtRetirada = dtRetirada;
    }

    public int getCdEmprestimo() {
        return cdEmprestimo;
    }

    public void setCdEmprestimo(int cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public int getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(int cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }

    public String getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(String dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public String getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(String dtRetirada) {
        this.dtRetirada = dtRetirada;
    }
}
