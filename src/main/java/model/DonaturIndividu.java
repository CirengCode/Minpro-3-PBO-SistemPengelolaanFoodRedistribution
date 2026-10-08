/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class DonaturIndividu extends Donatur {
    private String jenisKegiatan;

    public DonaturIndividu(String namaDonatur, String jenisKegiatan) {
        super(namaDonatur);
        this.jenisKegiatan = jenisKegiatan;
    }

    public String getJenisKegiatan() {
        return jenisKegiatan;
    }

    public void setJenisKegiatan(String jenisKegiatan) {
        this.jenisKegiatan = jenisKegiatan;
    }

    @Override
    public String getJenisDonatur() {
        return "Donatur Individu";
    }
}

