/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Emprestimo;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class EmprestimoTable {
    public static EmprestimoTable instancia;

    private EmprestimoTable() {}

    public static EmprestimoTable getInstancia() {
        if (instancia == null) {
            instancia = new EmprestimoTable();
        }
        return instancia;
    }

    public void saveEmprestimo(List<Emprestimo> colecao) {}

    public void saveEmprestimo() {}

    public List loadEmprestimo() throws InfraException, IOException {
        return null;
    }
}
