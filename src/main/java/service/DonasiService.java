/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.util.Scanner;
import model.Donasi;
import model.Donatur;
import util.InputUtil;
import view.DonaturView;
import view.DonasiView;
import view.MessageView;

public class DonasiService {
    private final ArrayList<Donasi> dataDonasi = new ArrayList<>();
    private final DonaturService donaturService;
    private final DonaturView donaturView;
    private final DonasiView donasiView;
    private final MessageView messageView;

    public DonasiService(DonaturService donaturService) {
        this.donaturService = donaturService;
        
        dataDonasi.add(new Donasi("DT01", "Muffin", 20, "Layak"));
        dataDonasi.add(new Donasi("DT02", "Sapi Lada Hitam", 15, "Layak"));
        dataDonasi.add(new Donasi("DT03", "Ayam Bistik", 10, "Layak"));
        dataDonasi.add(new Donasi("DT04", "Nasi Ayam", 15, "Layak"));
        
        donaturView = new DonaturView();
        donasiView = new DonasiView();
        messageView = new MessageView();
    }

    public void tableData() {
        donasiView.tableData(dataDonasi);
    }
    
    public void dataDonasi(Scanner scanner) {
        boolean berjalanDonasi = true;

        while (berjalanDonasi) {

            tableData();

            donasiView.tampilkanMenuPilihan();
            int pilihanDonasi = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanDonasi) {

                case 1 -> tambahDonasi(scanner);

                case 2 -> updateDonasi(scanner);

                case 3 -> hapusDonasi(scanner);

                case 4 -> berjalanDonasi = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

    private void tambahDonasi(Scanner scanner) {
        String idDonatur;
        while (true) {
            idDonatur = InputUtil.bacaString(scanner, "ID Donatur: ");

            if (donaturService.cariDonatur(idDonatur) != null) {
                break;
            }
            donaturView.tampilkanIdDonaturTidakValid();
        }
        
        String namaMakanan = InputUtil.bacaString(scanner, "Nama Makanan: ");
        
        int jumlahPorsi = InputUtil.bacaInt(scanner, "Jumlah Porsi: ");
        
        donasiView.tampilkanPilihanStatusKelayakan();
        int pilihanStatus;
        while (true) {
            pilihanStatus = InputUtil.bacaInt(scanner, "Status Kelayakan: ");

            if (pilihanStatus == 1 || pilihanStatus == 2) {
                break;
            }
            donasiView.tampilkanStatusTidakValid();
        }

        String statusKelayakan;
        if (pilihanStatus == 1) {
            statusKelayakan = "Layak";
        } else{
            statusKelayakan = "Tidak Layak";
        }

        dataDonasi.add(new Donasi(
                idDonatur,
                namaMakanan,
                jumlahPorsi,
                statusKelayakan
        ));

        messageView.tampilkanBerhasilTambah();
        InputUtil.tekanEnter(scanner);
    }

    private void updateDonasi(Scanner scanner) {
        String idDonasi = InputUtil.bacaString(scanner, "ID Donasi: ");

        Donasi donasi = cariDonasi(idDonasi);

        if (donasi == null) {
            donasiView.tampilkanIdDonasiTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }
        
        donasiView.tampilkanDataUpdate(donasi);
        System.out.print("Yakin ingin meng-update data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            
            String idDonatur;
            while (true) {
                idDonatur = InputUtil.bacaString(scanner, "ID Donatur: ");

                if (donaturService.cariDonatur(idDonatur) != null) {
                    break;
                }
                
                donaturView.tampilkanIdDonaturTidakValid();
            }
            
            String namaMakanan = InputUtil.bacaString(scanner, "Nama Makanan: ");
            
            int jumlahPorsi = InputUtil.bacaInt(scanner, "Jumlah Porsi: ");

            donasiView.tampilkanPilihanStatusKelayakan();
            int pilihanStatus;
            while (true) {
                pilihanStatus = InputUtil.bacaInt(scanner, "Status Kelayakan: ");

                if (pilihanStatus == 1 || pilihanStatus == 2) {
                    break;
                }
                donasiView.tampilkanStatusTidakValid();
            }

            String statusKelayakan;
            if (pilihanStatus == 1) {
                statusKelayakan = "Layak";
            } else{
                statusKelayakan = "Tidak Layak";
            }
            
            donasi.setIdDonatur(idDonatur);
            donasi.setNamaMakanan(namaMakanan);
            donasi.setJumlahPorsi(jumlahPorsi);
            donasi.setStatusKelayakan(statusKelayakan);

            messageView.tampilkanBerhasilUpdate();
        } else {
            messageView.tampilkanUpdateDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    private void hapusDonasi(Scanner scanner) {
        String idDonasi = InputUtil.bacaString(scanner, "ID Donasi: ");

        Donasi donasi = cariDonasi(idDonasi);

        if (donasi == null) {
            donasiView.tampilkanIdDonasiTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }
        
        donasiView.tampilkanDataHapus(donasi);
        System.out.print("Yakin ingin menghapus data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            dataDonasi.remove(donasi);
            
            messageView.tampilkanBerhasilHapus();
        } else {
            messageView.tampilkanHapusDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    public Donasi cariDonasi(String idDonasi) {
        for (Donasi d : dataDonasi) {
            if (d.getIdDonasi().equalsIgnoreCase(idDonasi)) {
                return d;
            }
        }

        return null;
    }
}

