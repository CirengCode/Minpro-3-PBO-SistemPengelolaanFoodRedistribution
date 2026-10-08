/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.util.Scanner;
import model.Penerima;
import model.PenerimaIndividu;
import model.PenerimaLembaga;
import util.InputUtil;
import view.MessageView;
import view.PenerimaView;

public class PenerimaService {
    private final ArrayList<Penerima> dataPenerima = new ArrayList<>();
    private final PenerimaView penerimaView;
    private final MessageView messageView;

    public PenerimaService() {
        dataPenerima.add(new PenerimaLembaga("Rumah Singgah Harapan", "Rumah Singgah", "Putri Ayu"));
        dataPenerima.add(new PenerimaLembaga("Panti Asuhan Kasih Ibu", "Panti Asuhan", "Siti Rahma"));
        dataPenerima.add(new PenerimaLembaga("Panti Asuhan Cinta Harapan", "Rumah Singgah", "Budi Santoso"));
        dataPenerima.add(new PenerimaIndividu("Orang yang membutuhkan"));
        
        penerimaView = new PenerimaView();
        messageView = new MessageView();
    }

    public void tableData() {
        penerimaView.tableData(dataPenerima);
    }

    public void dataPenerima(Scanner scanner) {
        boolean berjalanPenerima = true;

        while (berjalanPenerima) {

            tableData();
            
            penerimaView.tampilkanMenuPilihan();
            int pilihanPenerima = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanPenerima) {

                case 1 -> tambahPenerima(scanner);

                case 2 -> updatePenerima(scanner);

                case 3 -> hapusPenerima(scanner);

                case 4 -> berjalanPenerima = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

    private void tambahPenerima(Scanner scanner) {
        penerimaView.tampilkanPilihanJenisPenerima();
        
        int pilihanJenis;
        while (true) {
            pilihanJenis = InputUtil.bacaInt(scanner, "Jenis Penerima: ");

            if (pilihanJenis == 1 || pilihanJenis == 2) {
                break;
            }             
            
            penerimaView.tampilkanJenisPenerimaTidakValid();
        }

        if (pilihanJenis == 1) {

            String deskripsiPenerima = InputUtil.bacaString(scanner, "Deskripsi Penerima: ");

            dataPenerima.add(new PenerimaIndividu(
                    deskripsiPenerima
            ));
        } else {

            String namaLembaga = InputUtil.bacaString(scanner, "Nama Lembaga: ");
            String jenisLembaga = InputUtil.bacaString(scanner, "Jenis Lembaga: ");
            String namaPengelola = InputUtil.bacaNama(scanner, "Nama Pengelola: ");

            dataPenerima.add(new PenerimaLembaga(
                    namaLembaga,
                    jenisLembaga,
                    namaPengelola
            ));
        }
        
        messageView.tampilkanBerhasilTambah();
        InputUtil.tekanEnter(scanner);
    }

    private void updatePenerima(Scanner scanner) {
        String idPenerima = InputUtil.bacaString(scanner, "ID Penerima: ");

        Penerima penerima = cariPenerima(idPenerima);

        if (penerima == null) {
            penerimaView.tampilkanIdPenerimaTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }

        penerimaView.tampilkanDataUpdate(penerima);
        System.out.print("Yakin ingin meng-update data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {

            if (penerima instanceof PenerimaIndividu individu) {

                String deskripsiPenerima = InputUtil.bacaString(scanner, "Deskripsi Penerima: ");
               
                individu.setDeskripsiPenerima(deskripsiPenerima);

            } else if (penerima instanceof PenerimaLembaga lembaga) {

                String namaLembaga = InputUtil.bacaString(scanner, "Nama Lembaga: ");
                String jenisLembaga = InputUtil.bacaString(scanner, "Jenis Lembaga: ");
                String namaPengelola = InputUtil.bacaNama(scanner, "Nama Pengelola: ");

                lembaga.setNamaLembaga(namaLembaga);
                lembaga.setJenisLembaga(jenisLembaga);
                lembaga.setNamaPengelola(namaPengelola);
            }
            
            messageView.tampilkanBerhasilUpdate();
        } else {
            messageView.tampilkanUpdateDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    private void hapusPenerima(Scanner scanner) {
        String idPenerima = InputUtil.bacaString(scanner, "ID Penerima: ");

        Penerima penerima = cariPenerima(idPenerima);

        if (penerima == null) {
            penerimaView.tampilkanIdPenerimaTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }
        
        penerimaView.tampilkanDataHapus(penerima);
        System.out.print("Yakin ingin menghapus data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            dataPenerima.remove(penerima);
            
            messageView.tampilkanBerhasilHapus();
        } else {
            messageView.tampilkanHapusDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    public Penerima cariPenerima(String idPenerima) {
        for (Penerima p : dataPenerima) {
            if (p.getIdPenerima().equalsIgnoreCase(idPenerima)) {
                return p;
            }
        }

        return null;
    }
}
