/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ArrayList;
import model.Penyaluran;

public class PenyaluranView {
    public void tableData(ArrayList<Penyaluran> dataPenyaluran) {
        System.out.println("------------------------------------");
        System.out.println("=========== PENYALURAN =============");
        System.out.println("------------------------------------");

        for (Penyaluran p : dataPenyaluran) {
            System.out.println("ID Penyaluran: " + p.getIdPenyaluran());
            System.out.println("ID Donasi: " + p.getIdDonasi());
            System.out.println("ID Penerima: " + p.getIdPenerima());
            System.out.println("Nama Kegiatan: " + p.getNamaKegiatan());
            System.out.println("Tanggal Penyaluran: " + p.getTanggalPenyaluran());
            System.out.println("Status Penyaluran: " + p.getStatusPenyaluran());
            System.out.println("Jumlah Porsi: " + p.getJumlahPorsi());
            System.out.println("Petugas: " + p.getPetugas());
            System.out.println("------------------------------------");
        }
    }
    
    public void tampilkanMenuPilihan() {
        System.out.println("[1] Tambah");
        System.out.println("[2] Update");
        System.out.println("[3] Hapus");
        System.out.println("[4] Keluar");
    }
    
    public void tampilkanPilihanStatus() {
        System.out.println("------------------------------------");
        System.out.println("[1] Belum Disalurkan");
        System.out.println("[2] Dalam Proses Penyaluran");
        System.out.println("[3] Penyaluran Selesai");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataUpdate(Penyaluran penyaluran) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan di-update:");
        System.out.println("ID Donasi: " + penyaluran.getIdDonasi());
        System.out.println("ID Penerima: " + penyaluran.getIdPenerima());
        System.out.println("Nama Kegiatan: " + penyaluran.getNamaKegiatan());
        System.out.println("Tanggal Penyaluran: " + penyaluran.getTanggalPenyaluran());
        System.out.println("Status Penyaluran: " + penyaluran.getStatusPenyaluran());
        System.out.println("Jumlah Porsi: " + penyaluran.getJumlahPorsi());
        System.out.println("Petugas: " + penyaluran.getPetugas());
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataHapus(Penyaluran penyaluran) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan dihapus:");
        System.out.println("ID Donasi: " + penyaluran.getIdDonasi());
        System.out.println("ID Penerima: " + penyaluran.getIdPenerima());
        System.out.println("Nama Kegiatan: " + penyaluran.getNamaKegiatan());
        System.out.println("Tanggal Penyaluran: " + penyaluran.getTanggalPenyaluran());
        System.out.println("Status Penyaluran: " + penyaluran.getStatusPenyaluran());
        System.out.println("Jumlah Porsi: " + penyaluran.getJumlahPorsi());
        System.out.println("Petugas: " + penyaluran.getPetugas());
        System.out.println("------------------------------------");
    }
    
    public void tampilkanJumlahPorsiTidakValid() {
        System.out.println("-------------------------------------------");
        System.out.println("[               Jumlah Porsi               ]");
        System.out.println("[        Melebihi Ketersediaan -__- !      ]");
        System.out.println("-------------------------------------------");
    }
    
    public void tampilkanIdPenyaluranTidakValid() {
        System.out.println("----------------------------------------");
        System.out.println("     ID Penyaluran tidak ada -__- !     ");
        System.out.println("     Silakan masukkan ID yang valid     ");
        System.out.println("----------------------------------------");
    }
    
    public void tampilkanStatusTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("     Pilihan Status Penyaluran      ");
        System.out.println("         Tidak Valid -__- !         ");
        System.out.println("------------------------------------");
    }
}
