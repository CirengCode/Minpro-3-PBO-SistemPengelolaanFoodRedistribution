/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class PenerimaLembaga extends Penerima {
    private String namaLembaga;
    private String jenisLembaga;
    private String namaPengelola;

    public PenerimaLembaga(
            String namaLembaga,
            String jenisLembaga,
            String namaPengelola) {

        super();
        this.namaLembaga = namaLembaga;
        this.jenisLembaga = jenisLembaga;
        this.namaPengelola = namaPengelola;
    }

    public String getNamaLembaga() {
        return namaLembaga;
    }

    public void setNamaLembaga(String namaLembaga) {
        this.namaLembaga = namaLembaga;
    }

    public String getJenisLembaga() {
        return jenisLembaga;
    }

    public void setJenisLembaga(String jenisLembaga) {
        this.jenisLembaga = jenisLembaga;
    }

    public String getNamaPengelola() {
        return namaPengelola;
    }

    public void setNamaPengelola(String namaPengelola) {
        this.namaPengelola = namaPengelola;
    }

    @Override
    public String getJenisPenerima() {
        return "Lembaga";
    }
}

