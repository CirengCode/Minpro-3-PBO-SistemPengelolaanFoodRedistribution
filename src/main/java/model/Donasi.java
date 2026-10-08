/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import util.IdGenerator;

public class Donasi {
    private final String idDonasi;
    private String idDonatur;
    private String namaMakanan;
    private int jumlahPorsi;
    private String statusKelayakan;

    public Donasi(
            String idDonatur,
            String namaMakanan,
            int jumlahPorsi,
            String statusKelayakan) {

            this.idDonasi = IdGenerator.generateId("DN0");
            this.idDonatur = idDonatur;
            this.namaMakanan = namaMakanan;
            this.jumlahPorsi = jumlahPorsi;
            this.statusKelayakan = statusKelayakan;
    }

    public String getIdDonasi() {
        return idDonasi;
    }

    public String getIdDonatur() {
        return idDonatur;
    }

    public void setIdDonatur(String idDonatur) {
        this.idDonatur = idDonatur;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public int getJumlahPorsi() {
        return jumlahPorsi;
    }

    public void setJumlahPorsi(int jumlahPorsi) {
        this.jumlahPorsi = jumlahPorsi;
    }

    public String getStatusKelayakan() {
        return statusKelayakan;
    }

    public void setStatusKelayakan(String statusKelayakan) {
        this.statusKelayakan = statusKelayakan;
    }
}


