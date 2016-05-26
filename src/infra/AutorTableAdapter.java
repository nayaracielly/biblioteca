/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class AutorTableAdapter implements Persistencia {

    @Override
    public void save() throws InfraException, IOException {
        AutorTable.getInstancia().saveAutor();
    }

    @Override
    public List load() throws InfraException, IOException {
        return AutorTable.getInstancia().loadAutor();
    }

}
