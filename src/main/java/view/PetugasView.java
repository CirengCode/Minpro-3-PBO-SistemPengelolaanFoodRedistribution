/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import model.Penyaluran;

public class PetugasView {
    public void tampilkanMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("              MENU PETUGAS              ");
        System.out.println("========================================");
        System.out.println("[1] Lihat Data Donasi");
        System.out.println("[2] Lihat Data Penerima");
        System.out.println("[3] Lihat Data Penyaluran");
        System.out.println("[4] Kembali");
    }
    
    public void tampilkanMenuPenyaluran() {
        System.out.println("[1] Update Status Penyaluran");
        System.out.println("[2] Kembali");
    }
    
    public void tampilkanDataPenyaluran(Penyaluran penyaluran) {
        System.out.println("------------------------------------");
        System.out.println("Data Penyaluran");
        System.out.println("------------------------------------");
        System.out.println("ID Penyaluran: " + penyaluran.getIdPenyaluran());
        System.out.println("Nama Kegiatan: " + penyaluran.getNamaKegiatan());
        System.out.println("Status Penyaluran: " + penyaluran.getStatusPenyaluran());
        System.out.println("------------------------------------");
    }
    
}
