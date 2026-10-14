/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class TesKoneksi {

    public static void main(String[] args) {
        System.out.println("Mengecek koneksi ke database...");

        try {
            Connection conn = KoneksiDatabase.getConnection();

            if (conn != null) {
                System.out.println("STATUS: BERHASIL! Database siap digunakan.");
                conn.close();
            } else {
                System.out.println("STATUS: GAGAL! Koneksi tidak tersedia.");
            }

        } catch (SQLException e) {
            System.out.println("STATUS: GAGAL! " + e.getMessage());
        }
    }
}