/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.Usuario;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class UsuarioTable {
    public static UsuarioTable instancia;

    private UsuarioTable() {}

    public static UsuarioTable getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioTable();
        }
        return instancia;
    }

    public void saveUsuarios(List<Usuario> colecao) {}

    public void saveUsuarios() {}

    public List loadUsuarios() throws InfraException, IOException {
        return null;
    }
}
