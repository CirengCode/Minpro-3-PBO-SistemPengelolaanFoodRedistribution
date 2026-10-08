/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.util.Scanner;
import model.Penyaluran;
import model.Donasi;
import util.InputUtil;
import view.MessageView;
import view.PenyaluranView;
import view.DonasiView;
import view.PenerimaView;

public class PenyaluranService {
    private final ArrayList<Penyaluran> dataPenyaluran = new ArrayList<>();
    private final DonasiService donasiService;
    private final PenerimaService penerimaService;
    private final PenyaluranView penyaluranView;
    private final DonasiView donasiView;
    private final PenerimaView penerimaView;
    private final MessageView messageView;

    public PenyaluranService(DonasiService donasiService, PenerimaService penerimaService) {
        this.donasiService = donasiService;
        this.penerimaService = penerimaService;
        
        dataPenyaluran.add(new Penyaluran("DN01", "PN01", "Penyaluran ke Rumah Singgah", "10-09-2026","Dalam Proses Penyaluran", 20, "Petugas Komunitas"));
        dataPenyaluran.add(new Penyaluran("DN02", "PN02", "Penyaluran ke Panti Asuhan", "01-09-2026", "Penyaluran Selesai", 15, "Petugas Komunitas"));
        dataPenyaluran.add(new Penyaluran("DN03", "PN02", "Penyaluran ke Panti Asuhan", "10-07-2026", "Dalam Proses Penyaluran", 10, "Petugas Komunitas"));
        dataPenyaluran.add(new Penyaluran("DN04", "PN02", "Pembagian Makanan untuk Warga", "11-11-2026", "Penyaluran Selesai", 10, "Relawan"));
        
        penyaluranView = new PenyaluranView();
        donasiView = new DonasiView();
        penerimaView = new PenerimaView();
        messageView = new MessageView();
    }

    public void tableData() {
        penyaluranView.tableData(dataPenyaluran);
    }
    
    private int totalPorsiPenyaluran(String idDonasi) {
        int total = 0;

        for (Penyaluran p : dataPenyaluran) {
            if (p.getIdDonasi().equalsIgnoreCase(idDonasi)) {
                total += p.getJumlahPorsi();
            }
        }

        return total;
    }
    
    private int totalPorsiPenyaluran(String idDonasi, Penyaluran penyaluran) {
        int total = 0;

        for (Penyaluran p : dataPenyaluran) {
            if (p.getIdDonasi().equalsIgnoreCase(idDonasi) && p != penyaluran) {
                total += p.getJumlahPorsi();
            }
        }
        return total;
    }
    
    private int sisaPorsiDonasi(String idDonasi) {
        Donasi donasi = donasiService.cariDonasi(idDonasi);
        int totalSudahDisalurkan = totalPorsiPenyaluran(idDonasi);
        
        return donasi.getJumlahPorsi() - totalSudahDisalurkan;
    }

    public void dataPenyaluran(Scanner scanner) {
        boolean berjalanPenyaluran = true;

        while (berjalanPenyaluran) {

            tableData();

            penyaluranView.tampilkanMenuPilihan();
            int pilihanPenyaluran = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanPenyaluran) {

                case 1 -> tambahPenyaluran(scanner);

                case 2 -> updatePenyaluran(scanner);

                case 3 -> hapusPenyaluran(scanner);

                case 4 -> berjalanPenyaluran = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

    private void tambahPenyaluran(Scanner scanner) {
        String idDonasi;
        while (true) {
            idDonasi = InputUtil.bacaString(scanner, "ID Donasi: ");

            if (donasiService.cariDonasi(idDonasi) != null) {
                break;
            }
            donasiView.tampilkanIdDonasiTidakValid();
        }

        
        String idPenerima;
        while (true) {
            idPenerima = InputUtil.bacaString(scanner, "ID Penerima: ");

            if (penerimaService.cariPenerima(idPenerima) != null) {
                break;
            }
            penerimaView.tampilkanIdPenerimaTidakValid();
        }
        
        String namaKegiatan = InputUtil.bacaString(scanner, "Nama Kegiatan: ");
        String tanggalPenyaluran = InputUtil.bacaTanggal(scanner, "Tanggal Penyaluran: ");
        String statusPenyaluran = "Belum Disalurkan";
        
        int jumlahPorsi;
        while (true) {
            int sisaPorsi = sisaPorsiDonasi(idDonasi);
            
            jumlahPorsi = InputUtil.bacaInt(scanner, "Jumlah Porsi (tersedia " + sisaPorsi + "): ");
            
            if (jumlahPorsi <= sisaPorsi){
                break;
            }
            penyaluranView.tampilkanJumlahPorsiTidakValid();
        }
        
        String petugas = InputUtil.bacaString(scanner, "Petugas: ");
        
        dataPenyaluran.add(new Penyaluran(
                idDonasi,
                idPenerima,
                namaKegiatan,
                tanggalPenyaluran,
                statusPenyaluran,
                jumlahPorsi,
                petugas
        ));
        
        messageView.tampilkanBerhasilTambah();
        InputUtil.tekanEnter(scanner);
    }

    private void updatePenyaluran(Scanner scanner) {
        String idPenyaluran = InputUtil.bacaString(scanner,"ID Penyaluran: ");

        Penyaluran penyaluran = cariPenyaluran(idPenyaluran);

        if (penyaluran == null) {
            penyaluranView.tampilkanIdPenyaluranTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }

        penyaluranView.tampilkanDataUpdate(penyaluran);
        System.out.print("Yakin ingin meng-update data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {

            String idDonasi;
            while (true) {
                idDonasi = InputUtil.bacaString(scanner, "ID Donasi: ");

                if (donasiService.cariDonasi(idDonasi) != null) {
                    break;
                }
                
                donasiView.tampilkanIdDonasiTidakValid();
            }
            
            
            String idPenerima;
            while (true) {
                idPenerima = InputUtil.bacaString(scanner, "ID Penerima: ");

                if (penerimaService.cariPenerima(idPenerima) != null) {
                    break;
                }
                
                penerimaView.tampilkanIdPenerimaTidakValid();
            }
            
            String namaKegiatan = InputUtil.bacaString(scanner, "Nama Kegiatan: ");
            String tanggalPenyaluran = InputUtil.bacaTanggal(scanner, "Tanggal Penyaluran: ");
            
            penyaluranView.tampilkanPilihanStatus();
            int pilihanStatus;
            while (true) {
                pilihanStatus = InputUtil.bacaInt(scanner, "Status Penyaluran: ");

                if (pilihanStatus == 1 || pilihanStatus == 2 || pilihanStatus == 3) {
                    break;
                }
                
                penyaluranView.tampilkanStatusTidakValid();
            }
            
            String statusPenyaluran;
            if(pilihanStatus == 1){
                statusPenyaluran = "Belum Disalurkan";
            }else if(pilihanStatus == 2){
                statusPenyaluran = "Dalam Proses Penyaluran";
            }else{
                statusPenyaluran = "Penyaluran Selesai";
            }
            
            int jumlahPorsi;
            while (true) {
                int totalPorsiLain = totalPorsiPenyaluran(idDonasi, penyaluran);
                Donasi donasi = donasiService.cariDonasi(idDonasi);

                int sisaPorsi = donasi.getJumlahPorsi() - totalPorsiLain;
                jumlahPorsi = InputUtil.bacaInt(scanner, "Jumlah Porsi (tersedia " + sisaPorsi + "): ");

                if (jumlahPorsi <= sisaPorsi){
                    break;
                }

                penyaluranView.tampilkanJumlahPorsiTidakValid();
            }

            String petugas = InputUtil.bacaString(scanner, "Petugas: ");

            penyaluran.setIdDonasi(idDonasi);
            penyaluran.setIdPenerima(idPenerima);
            penyaluran.setNamaKegiatan(namaKegiatan);
            penyaluran.setTanggalPenyaluran(tanggalPenyaluran);
            penyaluran.setStatusPenyaluran(statusPenyaluran);
            penyaluran.setJumlahPorsi(jumlahPorsi);
            penyaluran.setPetugas(petugas);

            messageView.tampilkanBerhasilUpdate();
        } else {
            messageView.tampilkanUpdateDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    private void hapusPenyaluran(Scanner scanner) {
        String idPenyaluran = InputUtil.bacaString(scanner, "ID Penyaluran: ");

        Penyaluran penyaluran = cariPenyaluran(idPenyaluran);

        if (penyaluran == null) {
            penyaluranView.tampilkanIdPenyaluranTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }

        penyaluranView.tampilkanDataHapus(penyaluran);
        System.out.print("Yakin ingin menghapus data? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            dataPenyaluran.remove(penyaluran);
            
            messageView.tampilkanBerhasilHapus();
        } else {
            messageView.tampilkanHapusDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }

    public Penyaluran cariPenyaluran(String idPenyaluran) {
        for (Penyaluran p : dataPenyaluran) {
            if (p.getIdPenyaluran().equalsIgnoreCase(idPenyaluran)) {
                return p;
            }
        }

        return null;
    }
}

