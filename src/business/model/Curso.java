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
public class Curso {
    private int idCurso;
    private String nomeCurso;

    public Curso(int idCurso, String nomeCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nomeCurso=" + nomeCurso + '}';
    }
}
