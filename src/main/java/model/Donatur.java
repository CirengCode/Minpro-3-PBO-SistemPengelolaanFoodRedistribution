/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import util.IdGenerator;

public abstract class Donatur {
    private final String idDonatur;
    private String namaDonatur;

    public Donatur(String namaDonatur) {
        this.idDonatur = IdGenerator.generateId("DT0");
        this.namaDonatur = namaDonatur;
    }

    public String getIdDonatur() {
        return idDonatur;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public abstract String getJenisDonatur();
}