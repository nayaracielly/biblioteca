/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import java.util.List;

/**
 *
 * @author anakin
 */
public class Autor {
    private int idAutor;
    private String nomeAutor;
    private List livrosAutor;

    public Autor(int idAutor, String nomeAutor, List livrosAutor) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
        this.livrosAutor = livrosAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public List getLivrosAutor() {
        return livrosAutor;
    }

    public void setLivrosAutor(List livrosAutor) {
        this.livrosAutor = livrosAutor;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nomeAutor=" + nomeAutor + ", livrosAutor=" + livrosAutor + '}';
    }
}
