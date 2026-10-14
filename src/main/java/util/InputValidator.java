/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class InputValidator {

    public static String inputTidakKosong(Scanner input, String pesan) {
        String data;

        do {
            System.out.print(pesan);
            data = input.nextLine();

            if (data.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            }
        } while (data.trim().isEmpty());

        return data;
    }

    public static int inputAngkaPositif(Scanner input, String pesan) {
        int angka;

        do {
            System.out.print(pesan);

            while (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                input.nextLine();
                System.out.print(pesan);
            }

            angka = input.nextInt();
            input.nextLine();

            if (angka <= 0) {
                System.out.println("Angka harus lebih dari 0.");
            }
        } while (angka <= 0);

        return angka;
    }

    public static int inputPilihan(Scanner input, String pesan,
                                   int pilihanAwal, int pilihanAkhir) {
        int pilihan;

        do {
            System.out.print(pesan);

            while (!input.hasNextInt()) {
                System.out.println("Pilihan harus berupa angka.");
                input.nextLine();
                System.out.print(pesan);
            }

            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan < pilihanAwal || pilihan > pilihanAkhir) {
                System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan < pilihanAwal || pilihan > pilihanAkhir);

        return pilihan;
    }
}
