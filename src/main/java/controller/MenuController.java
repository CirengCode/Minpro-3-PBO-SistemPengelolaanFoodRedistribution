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
import util.InputUtil;
import view.MenuView;
import view.MessageView;

public class MenuController {
    
    private AdminController admin;
    private PetugasController petugas;
    private final MenuView menuView;
    private final MessageView messageView;

    public MenuController() {

        DonaturService donaturService = new DonaturService();
        DonasiService donasiService = new DonasiService(donaturService);
        PenerimaService penerimaService = new PenerimaService();
        PenyaluranService penyaluranService = new PenyaluranService(donasiService, penerimaService);

        admin = new AdminController(donaturService, donasiService, penerimaService, penyaluranService);
        petugas = new PetugasController(donasiService, penerimaService,penyaluranService);
        menuView = new MenuView();
        messageView = new MessageView();
    }


    public void mulai(Scanner scanner) {
        boolean berjalan = true;

        while (berjalan) {

            menuView.tampilkanMenu();

            int pilihan = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihan) {

                case 1 -> admin.mulai(scanner);

                case 2 -> petugas.mulai(scanner);

                case 3 -> {
                    menuView.tampilkanPesanKeluar();
                    berjalan = false;
                }

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }
    
}
