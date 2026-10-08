/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ArrayList;
import model.Donatur;
import model.DonaturIndividu;
import model.DonaturInstansi;

public class DonaturView {
    public void tableData(ArrayList<Donatur> dataDonatur) {
        System.out.println("------------------------------------");
        System.out.println("============= DONATUR ==============");
        System.out.println("------------------------------------");

        for (Donatur d : dataDonatur) {
            System.out.println("ID Donatur: " + d.getIdDonatur());
            System.out.println("Nama Donatur: " + d.getNamaDonatur());
            System.out.println("Jenis Donatur: " + d.getJenisDonatur());

            if (d instanceof DonaturIndividu individu) {
                System.out.println("Jenis Kegiatan: " + individu.getJenisKegiatan());
            } else if (d instanceof DonaturInstansi instansi) {
                System.out.println("Nama Instansi: " + instansi.getNamaInstansi());
                System.out.println("Jenis Instansi: " + instansi.getJenisInstansi());
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
    
    public void tampilkanPilihanJenisDonatur() {
        System.out.println("------------------------------------");
        System.out.println("[1] Donatur Individu");
        System.out.println("[2] Donatur Instansi");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataUpdate(Donatur donatur) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan di-update:");
        System.out.println("Nama Donatur: " + donatur.getNamaDonatur());
        System.out.println("Jenis Donatur: " + donatur.getJenisDonatur());

        if (donatur instanceof DonaturIndividu individu) {
            System.out.println("Jenis Kegiatan: " + individu.getJenisKegiatan());

        } else if (donatur instanceof DonaturInstansi instansi) {
            System.out.println("Nama Instansi: " + instansi.getNamaInstansi());
            System.out.println("Jenis Instansi: " + instansi.getJenisInstansi());
        }

        System.out.println("------------------------------------");
    }
    
    public void tampilkanDataHapus(Donatur donatur) {
        System.out.println("------------------------------------");
        System.out.println("Data yang akan dihapus:");
        System.out.println("ID Donatur: " + donatur.getIdDonatur());
        System.out.println("Nama Donatur: " + donatur.getNamaDonatur());
        System.out.println("Jenis Donatur: " + donatur.getJenisDonatur());

        if (donatur instanceof DonaturIndividu individu) {
            System.out.println("Jenis Kegiatan: " + individu.getJenisKegiatan());

        } else if (donatur instanceof DonaturInstansi instansi) {
            System.out.println("Nama Instansi: " + instansi.getNamaInstansi());
            System.out.println("Jenis Instansi: " + instansi.getJenisInstansi());
        }

        System.out.println("------------------------------------");
    }
    
    public void tampilkanJenisDonaturTidakValid() {
        System.out.println("------------------------------------");
        System.out.println("[Pilihan Donatur tidak valid! -__- !]");
        System.out.println("------------------------------------");
    }
    
    public void tampilkanIdDonaturTidakValid() {
        System.out.println("----------------------------------------");
        System.out.println("       ID Donatur tidak ada -__-!       ");
        System.out.println("     Silakan masukkan ID yang valid     ");
        System.out.println("----------------------------------------");
    }
}
