/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Livro;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class LivroTable {

    public static LivroTable instancia;

    private LivroTable() {}

    public static LivroTable getInstancia() {
        if (instancia == null) {
            instancia = new LivroTable();
        }
        return instancia;
    }

    public void saveLivros(List<Livro> colecao) {}

    public void saveLivros() {}

    public List loadLivros() throws InfraException, IOException {
        return null;
    }
}
