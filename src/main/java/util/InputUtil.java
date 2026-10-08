/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputUtil {
    
    public static int bacaInt(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("------------------------------------");
                System.out.println("[Data Tidak Boleh Kosong -__-!]");
                System.out.println("------------------------------------");
                continue;
            }

            try {
                int nilai = Integer.parseInt(input);

                if (nilai <= 0) {
                    System.out.println("------------------------------------");
                    System.out.println("[Input Harus Lebih Dari 0 -__-!]");
                    System.out.println("------------------------------------");
                    continue;
                }

                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("------------------------------------");
                System.out.println("[Input Harus Berupa Angka -__-!]");
                System.out.println("------------------------------------");
            }
        }
    }

    public static String bacaString(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = scanner.nextLine();

            if (!nilai.trim().isEmpty()) {
                return nilai;
            }

            System.out.println("------------------------------------");
            System.out.println("[Data tidak boleh kosong -__-!]");
            System.out.println("------------------------------------");
        }
    }

    public static void tekanEnter(Scanner scanner) {
        System.out.println();
        System.out.print("Tekan Enter untuk kembali ke menu...");
        scanner.nextLine();
    }
    
    public static String bacaTanggal(Scanner scanner, String pesan) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        while (true) {
            System.out.print(pesan);
            String nilai = scanner.nextLine();

            if (nilai.trim().isEmpty()) {
                System.out.println("------------------------------------");
                System.out.println("[Data Tidak Boleh Kosong -__-!]");
                System.out.println("------------------------------------");
                continue;
            }
            try {
                LocalDate.parse(nilai, formatter);
                return nilai;
            } catch (DateTimeParseException e) {
                System.out.println("------------------------------------");
                System.out.println("[Format Tanggal Harus dd-MM-yyyy -__-!]");
                System.out.println("------------------------------------");
            }
        }
    }
    
    public static String bacaNama(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = scanner.nextLine();

            if (nilai.trim().isEmpty()) {
                System.out.println("------------------------------------");
                System.out.println("[Data Tidak Boleh Kosong -__-!]");
                System.out.println("------------------------------------");
                continue;
            }

            if (!nilai.matches("[a-zA-Z ]+")) {
                System.out.println("------------------------------------");
                System.out.println("[Nama Harus Berupa Huruf -__- !]");
                System.out.println("------------------------------------");
                continue;
            }

            return nilai;
        }
    }
    
    
}