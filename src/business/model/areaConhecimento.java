/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author anakin
 */
public class areaConhecimento {
    private int idAreaConhecimento;
    private String nomeArea;

    public areaConhecimento(int idAreaConhecimento, String nomeArea) {
        this.idAreaConhecimento = idAreaConhecimento;
        this.nomeArea = nomeArea;
    }

    public int getIdAreaConhecimento() {
        return idAreaConhecimento;
    }

    public void setIdAreaConhecimento(int idAreaConhecimento) {
        this.idAreaConhecimento = idAreaConhecimento;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    @Override
    public String toString() {
        return "areaConhecimento{" + "idAreaConhecimento=" + idAreaConhecimento + ", nomeArea=" + nomeArea + '}';
    }
}
