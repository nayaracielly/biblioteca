/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.areaConhecimento;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author anakin
 */
public class areaConhecimentoTable {
    public static areaConhecimentoTable instancia;

    private areaConhecimentoTable() {}

    public static areaConhecimentoTable getInstancia() {
        if (instancia == null) {
            instancia = new areaConhecimentoTable();
        }
        return instancia;
    }

    public void saveareaConhecimento(List<areaConhecimento> colecao) {}

    public void saveareaConhecimento() {}

    public List loadareaConhecimento() throws InfraException, IOException {
        return null;
    }
}
