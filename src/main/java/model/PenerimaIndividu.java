/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class PenerimaIndividu extends Penerima {
    private String deskripsiPenerima;

    public PenerimaIndividu(String deskripsiPenerima) {
        super();
        this.deskripsiPenerima = deskripsiPenerima;
    }

    public String getDeskripsiPenerima() {
        return deskripsiPenerima;
    }

    public void setDeskripsiPenerima(String deskripsiPenerima) {
        this.deskripsiPenerima = deskripsiPenerima;
    }

    @Override
    public String getJenisPenerima() {
        return "Individu";
    }
}