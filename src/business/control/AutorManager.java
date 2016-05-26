/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Autor;
import infra.FabricaDeAdapter;
import infra.Persistencia;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anakin
 */
public class AutorManager {
    private static List<Autor> listaAutores;
    private static Scanner entrada;
    private static AutorManager instancia;
    private FabricaDeAdapter fabrica;
    private Persistencia adapter;
    
}
