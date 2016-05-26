/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author anakin
 */
public class FabricaLivroTableAdapter implements FabricaDeAdapter {

    @Override
    public Persistencia criar() {
        return new LivroTableAdapter(); //To change body of generated methods, choose Tools | Templates.
    }
}
