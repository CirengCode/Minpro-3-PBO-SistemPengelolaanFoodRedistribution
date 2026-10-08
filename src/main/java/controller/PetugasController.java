/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.Scanner;
import service.DonasiService;
import service.DonaturService;
import service.PenerimaService;
import service.PenyaluranService;
import service.PetugasService;
import util.InputUtil;
import view.PetugasView;
import view.MessageView;

public class PetugasController {
    private DonasiService donasiService;
    private PenerimaService penerimaService;
    private PetugasService petugasService;
    private final PetugasView petugasView;
    private final MessageView messageView;
    
    public PetugasController(
            DonasiService donasiService,
            PenerimaService penerimaService,
            PenyaluranService penyaluranService) {

        this.donasiService = donasiService;
        this.penerimaService = penerimaService;
        this.petugasService = new PetugasService(penyaluranService);
        petugasView = new  PetugasView();
        messageView = new  MessageView();
    }
    
    public void mulai(Scanner scanner) {
        menuPetugas(scanner);
    }

    private void menuPetugas(Scanner scanner) {
        boolean berjalanPetugas = true;

        while (berjalanPetugas) {
            petugasView.tampilkanMenu();

            int pilihanPetugas = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanPetugas) {

                case 1 -> {
                    donasiService.tableData();
                    InputUtil.tekanEnter(scanner);
                }

                case 2 -> {
                    penerimaService.tableData();
                    InputUtil.tekanEnter(scanner);
                }

                case 3 -> {
                    petugasService.lihatDataPenyaluran(scanner);
                }

                case 4 -> berjalanPetugas = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

}
