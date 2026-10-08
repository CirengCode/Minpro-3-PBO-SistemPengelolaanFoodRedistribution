/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import util.IdGenerator;

public class Penyaluran {
    private final String idPenyaluran;
    private String idDonasi;
    private String idPenerima;
    private String namaKegiatan;
    private String tanggalPenyaluran;
    private String statusPenyaluran;
    private int jumlahPorsi;
    private String petugas;

    public Penyaluran(
            String idDonasi,
            String idPenerima,
            String namaKegiatan,
            String tanggalPenyaluran,
            String statusPenyaluran,
            int jumlahPorsi,
            String petugas) {

        this.idPenyaluran = IdGenerator.generateId("PY0");
        this.idDonasi = idDonasi;
        this.idPenerima = idPenerima;
        this.namaKegiatan = namaKegiatan;
        this.tanggalPenyaluran = tanggalPenyaluran;
        setStatusPenyaluran(statusPenyaluran);
        this.jumlahPorsi = jumlahPorsi;
        this.petugas = petugas;
    }

    public String getIdPenyaluran() {
        return idPenyaluran;
    }

    public String getIdDonasi() {
        return idDonasi;
    }

    public void setIdDonasi(String idDonasi) {
        this.idDonasi = idDonasi;
    }

    public String getIdPenerima() {
        return idPenerima;
    }

    public void setIdPenerima(String idPenerima) {
        this.idPenerima = idPenerima;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getTanggalPenyaluran() {
        return tanggalPenyaluran;
    }

    public void setTanggalPenyaluran(String tanggalPenyaluran) {
        this.tanggalPenyaluran = tanggalPenyaluran;
    }
    
    public String getStatusPenyaluran() {
        return statusPenyaluran;
    }

    public void setStatusPenyaluran(String statusPenyaluran) {
        this.statusPenyaluran = statusPenyaluran;
    }

    public int getJumlahPorsi() {
        return jumlahPorsi;
    }

    public void setJumlahPorsi(int jumlahPorsi) {
        this.jumlahPorsi = jumlahPorsi;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }
}
