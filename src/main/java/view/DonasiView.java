/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ArrayList;
import model.Donasi;

public class DonasiView {
    public void tableData(ArrayList<Donasi> dataDonasi) {
        System.out.println("------------------------------------");
        System.out.println("============= DONASI ===============");
        System.out.println("------------------------------------");

        for (Donasi d : dataDonasi) {
            System.out.println("ID Donasi: " + d.getIdDonasi());
            System.out.println("ID Donatur: " + d.getIdDonatur());
            System.out.println("Nama Makanan: " + d.getNamaMakanan());
            System.out.println("Jumlah Porsi: " + d.getJumlahPorsi());
            System.out.println("Status Kelayakan: " + d.getStatusKelayakan());
            if (d.getStatusKelayakan().equalsIgnoreCase("Tidak Layak")) {
                System.out.println("------------------------------------");
                System.out.println("    !!! TIDAK AKAN DISALURKAN !!!    ");
            }
            System.out.println("------------------------------------");
        }
    }
    
    public void tampilkanMenuPilihan() {
        System.out.println("[1] Tambah");
        System.out.println("[2] Update");
        System.out.println("[3] Hapus");
        System.out.println("[4] Keluar");
    }
    
    public void tampilkanPilihanStatusKelayakan() {
        System.out.println("------------------------------------");
        System.out.println("[1] Layak");
        System.out.println("[2] Tidak Layak");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataUpdate(Donasi donasi) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan di-update:");
        System.out.println("ID Donasi: " + donasi.getIdDonasi());
        System.out.println("ID Donatur: " + donasi.getIdDonatur());
        System.out.println("Nama Makanan: " + donasi.getNamaMakanan());
        System.out.println("Jumlah Porsi: " + donasi.getJumlahPorsi());
        System.out.println("Status Kelayakan: " + donasi.getStatusKelayakan());
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataHapus(Donasi donasi) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan dihapus:");
        System.out.println("ID Donasi: " + donasi.getIdDonasi());
        System.out.println("ID Donatur: " + donasi.getIdDonatur());
        System.out.println("Nama Makanan: " + donasi.getNamaMakanan());
        System.out.println("Jumlah Porsi: " + donasi.getJumlahPorsi());
        System.out.println("Status Kelayakan: " + donasi.getStatusKelayakan());
        System.out.println("------------------------------------");
    }
    
    public void tampilkanStatusTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("[Status Kelayakan Tidak Valid -__- !]");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanIdDonasiTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("      ID Donasi tidak ada -__-!     ");
        System.out.println("   Silakan masukkan ID yang valid   ");
        System.out.println("------------------------------------");
    }

}
