/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Autor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class AutorTable {
    public static AutorTable instancia;

    private AutorTable() {}

    public static AutorTable getInstancia() {
        if (instancia == null) {
            instancia = new AutorTable();
        }
        return instancia;
    }

    public void saveAutor(List<Autor> colecao) {}

    public void saveAutor() {}

    public List loadAutor() throws InfraException, IOException {
        return null;
    }
}
