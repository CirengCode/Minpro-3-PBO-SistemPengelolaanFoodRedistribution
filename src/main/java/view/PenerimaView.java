/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ArrayList;
import model.Penerima;
import model.PenerimaIndividu;
import model.PenerimaLembaga;

public class PenerimaView {
    public void tableData(ArrayList<Penerima> dataPenerima) {
        System.out.println("------------------------------------");
        System.out.println("============= PENERIMA =============");
        System.out.println("------------------------------------");

        for (Penerima p : dataPenerima) {
            System.out.println("ID Penerima: " + p.getIdPenerima());
            System.out.println("Jenis Penerima: " + p.getJenisPenerima());

            if (p instanceof PenerimaIndividu individu) {
                System.out.println("Deskripsi Penerima: " + individu.getDeskripsiPenerima());
            } else if (p instanceof PenerimaLembaga lembaga) {
                System.out.println("Nama Lembaga: " + lembaga.getNamaLembaga());
                System.out.println("Jenis Lembaga: " + lembaga.getJenisLembaga());
                System.out.println("Nama Pengelola: " + lembaga.getNamaPengelola());
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
    
    public void tampilkanPilihanJenisPenerima() {
        System.out.println("------------------------------------");
        System.out.println("[1] Penerima Individu");
        System.out.println("[2] Penerima Lembaga");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataUpdate(Penerima penerima) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan di-update:");
        System.out.println("ID Penerima: " + penerima.getIdPenerima());
        System.out.println("Jenis Penerima: " + penerima.getJenisPenerima());

        if (penerima instanceof PenerimaIndividu individu) {
            System.out.println("Deskripsi Penerima: " + individu.getDeskripsiPenerima());

        } else if (penerima instanceof PenerimaLembaga lembaga) {
            System.out.println("Nama Lembaga: " + lembaga.getNamaLembaga());
            System.out.println("Jenis Lembaga: " + lembaga.getJenisLembaga());
            System.out.println("Nama Pengelola: " + lembaga.getNamaPengelola());
        }

        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataHapus(Penerima penerima) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan dihapus:");
        System.out.println("ID Penerima: " + penerima.getIdPenerima());
        System.out.println("Jenis Penerima: " + penerima.getJenisPenerima());

        if (penerima instanceof PenerimaIndividu individu) {
            System.out.println("Deskripsi Penerima: " + individu.getDeskripsiPenerima());

        } else if (penerima instanceof PenerimaLembaga lembaga) {
            System.out.println("Nama Lembaga: " + lembaga.getNamaLembaga());
            System.out.println("Jenis Lembaga: " + lembaga.getJenisLembaga());
            System.out.println("Nama Pengelola: " + lembaga.getNamaPengelola());
        }

        System.out.println("------------------------------------");
    }
    
    public void tampilkanJenisPenerimaTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("[Pilihan Penerima tidak valid -__- !]");
        System.out.println("------------------------------------");
    }

    public void tampilkanIdPenerimaTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("     ID Penerima tidak ada -__-!    ");
        System.out.println("   Silakan masukkan ID yang valid   ");
        System.out.println("------------------------------------");
    }
}
