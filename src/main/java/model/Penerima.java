/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import util.IdGenerator;

public abstract class Penerima {
    private final String idPenerima;

    public Penerima() {
        this.idPenerima = IdGenerator.generateId("PN0");
    }

    public String getIdPenerima() {
        return idPenerima;
    }

    public abstract String getJenisPenerima();
}
