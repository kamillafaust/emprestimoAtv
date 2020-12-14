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
public class Autores implements Serializable {
    
    private int cdAutores;
    private String nmAutor;

    public Autores() {
    }

    public Autores(int cdAutores, String nmAutor) {
        this.cdAutores = cdAutores;
        this.nmAutor = nmAutor;
    }

    public int getCdAutores() {
        return cdAutores;
    }

    public void setCdAutores(int cdAutores) {
        this.cdAutores = cdAutores;
    }

    public String getNmAutor() {
        return nmAutor;
    }

    public void setNmAutor(String nmAutor) {
        this.nmAutor = nmAutor;
    }
}
