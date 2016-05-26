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
public class Emprestimo {

    private String matriculaUsuario;
    private List livosEmprestados;

    public Emprestimo(String matriculaUsuario, List livosEmprestados) {
        this.matriculaUsuario = matriculaUsuario;
        this.livosEmprestados = livosEmprestados;
    }

    public String getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public List getLivosEmprestados() {
        return livosEmprestados;
    }

    public void setLivosEmprestados(List livosEmprestados) {
        this.livosEmprestados = livosEmprestados;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "matriculaUsuario=" + matriculaUsuario + ", livosEmprestados=" + livosEmprestados + '}';
    }



}
