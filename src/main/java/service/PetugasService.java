/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Scanner;
import model.Penyaluran;
import util.InputUtil;
import view.MessageView;
import view.PetugasView;
import view.PenyaluranView;

public class PetugasService {

    private final PenyaluranService penyaluranService;
    private final PetugasView petugasView;
    private final PenyaluranView penyaluranView;
    private final MessageView messageView;

    public PetugasService(PenyaluranService penyaluranService) {
        this.penyaluranService = penyaluranService;
        
        petugasView = new PetugasView();
        penyaluranView = new PenyaluranView();
        messageView = new MessageView();
    }

    public void lihatDataPenyaluran(Scanner scanner) {
        boolean berjalan = true;

        while (berjalan) {
            penyaluranService.tableData();
            
            petugasView.tampilkanMenuPenyaluran();
            int pilihan =
                    InputUtil.bacaInt(scanner, ">> ");

            switch (pilihan) {

                case 1 -> updateStatusPenyaluran(scanner);

                case 2 -> berjalan = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

    private void updateStatusPenyaluran(Scanner scanner) {

        String idPenyaluran =
                InputUtil.bacaString(scanner, "ID Penyaluran: ");

        Penyaluran penyaluran =
                penyaluranService.cariPenyaluran(idPenyaluran);

        if (penyaluran == null) {
            penyaluranView.tampilkanIdPenyaluranTidakValid();
            InputUtil.tekanEnter(scanner);
            return;
        }
        
        petugasView.tampilkanDataPenyaluran(penyaluran);
        System.out.print("Yakin ingin meng-update status? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
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

            penyaluran.setStatusPenyaluran(statusPenyaluran);
            
            messageView.tampilkanBerhasilUpdate();
        } else {
            messageView.tampilkanUpdateDibatalkan();
        }

        InputUtil.tekanEnter(scanner);
    }
}
