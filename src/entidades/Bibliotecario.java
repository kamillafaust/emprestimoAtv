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
public class Bibliotecario implements Serializable {
    
    private int cdBibliotecario;
    private String login;
    private String senha;
    private String nome; 
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Bibliotecario() {
    }

    public Bibliotecario(int cdBibliotecario, String login, String senha, String nome, String logradouro, String cidade, String estado, String cep) {
        this.cdBibliotecario = cdBibliotecario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(int cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
