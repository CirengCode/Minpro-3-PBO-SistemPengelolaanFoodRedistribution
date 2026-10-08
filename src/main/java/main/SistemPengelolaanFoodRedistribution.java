/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import controller.MenuController;
import java.util.Scanner;

public class SistemPengelolaanFoodRedistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuController controller =
                new MenuController();

        controller.mulai(scanner);

        scanner.close();
    }
    
}

