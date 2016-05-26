/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Curso;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class CursoTable {
    public static CursoTable instancia;

    private CursoTable() {}

    public static CursoTable getInstancia() {
        if (instancia == null) {
            instancia = new CursoTable();
        }
        return instancia;
    }

    public void saveCurso(List<Curso> colecao) {}

    public void saveCurso() {}

    public List loadCurso() throws InfraException, IOException {
        return null;
    }
}
