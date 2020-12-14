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
public class Academico implements Serializable {
    
    private int cdMatricula;
    private String nmAcademico;
    private int cpf;
    private String dsEmail;
    private String dsEndereco;
    private int idSexo;
    private int idade;

    public Academico() {
    }

    public Academico(int cdMatricula, String nmAcademico, int cpf, String dsEmail, String dsEndereco, int idSexo, int idade) {
        this.cdMatricula = cdMatricula;
        this.nmAcademico = nmAcademico;
        this.cpf = cpf;
        this.dsEmail = dsEmail;
        this.dsEndereco = dsEndereco;
        this.idSexo = idSexo;
        this.idade = idade;
    }

    public int getCdMatricula() {
        return cdMatricula;
    }

    public void setCdMatricula(int cdMatricula) {
        this.cdMatricula = cdMatricula;
    }

    public String getNmAcademico() {
        return nmAcademico;
    }

    public void setNmAcademico(String nmAcademico) {
        this.nmAcademico = nmAcademico;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }    
}
