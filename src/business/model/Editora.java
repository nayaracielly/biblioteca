/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author anakin
 */
public class Editora {
    private int idEditora;
    private String nomeEditora;

    public Editora(int idEditora, String nomeEditora) {
        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    @Override
    public String toString() {
        return "Editora{" + "idEditora=" + idEditora + ", nomeEditora=" + nomeEditora + '}';
    }
}