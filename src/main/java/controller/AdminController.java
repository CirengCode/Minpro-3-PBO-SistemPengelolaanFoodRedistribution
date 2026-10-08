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
import view.AdminView;
import view.MessageView;

public class AdminController {
    private DonaturService donaturService;
    private DonasiService donasiService;
    private PenerimaService penerimaService;
    private PenyaluranService penyaluranService;
    private final AdminView adminView;
    private final MessageView messageView;
    
    public AdminController(
            DonaturService donaturService,
            DonasiService donasiService,
            PenerimaService penerimaService,
            PenyaluranService penyaluranService) {

        this.donaturService = donaturService;
        this.donasiService = donasiService;
        this.penerimaService = penerimaService;
        this.penyaluranService = penyaluranService;
        adminView = new AdminView();
        messageView = new MessageView();
    }
    
    public void mulai(Scanner scanner) {
        menuAdmin(scanner);
    }

    private void menuAdmin(Scanner scanner) {
        boolean berjalanAdmin = true;

        while (berjalanAdmin) {
            adminView.tampilkanMenu();
            
            int pilihanAdmin = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanAdmin) {

                case 1 -> donaturService.dataDonatur(scanner);

                case 2 -> donasiService.dataDonasi(scanner);

                case 3 -> penerimaService.dataPenerima(scanner);

                case 4 -> penyaluranService.dataPenyaluran(scanner);

                case 5 -> berjalanAdmin = false;

                default -> {
                    messageView.tampilkanPilihanTidakValid();
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }
    
}

