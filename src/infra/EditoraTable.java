/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Editora;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class EditoraTable {
    public static EditoraTable instancia;

    private EditoraTable() {}

    public static EditoraTable getInstancia() {
        if (instancia == null) {
            instancia = new EditoraTable();
        }
        return instancia;
    }

    public void saveEditora(List<Editora> colecao) {}

    public void saveEditora() {}

    public List loadEditora() throws InfraException, IOException {
        return null;
    }
}
