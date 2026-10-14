/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Halte;
import model.HalteReguler;
import model.HalteTransit;

/**
 *
 * @author user
 */
public class HalteDAO {

    public void tambahHalte(Halte halte) throws SQLException {
        String sql = "INSERT INTO halte (id_halte, nama_halte, lokasi, kapasitas, rute_bus, jenis_halte, detail_halte) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, halte.getIdHalte());
            pstmt.setString(2, halte.getNamaHalte());
            pstmt.setString(3, halte.getLokasi());
            pstmt.setInt(4, halte.getKapasitas());
            pstmt.setString(5, halte.getRuteBus());

            if (halte instanceof HalteReguler) {
                pstmt.setString(6, "Reguler");
                pstmt.setString(7,
                        ((HalteReguler) halte).getTitikTujuan());
            } else if (halte instanceof HalteTransit) {
                pstmt.setString(6, "Transit");
                pstmt.setString(7,
                        ((HalteTransit) halte).getRutePenghubung());
            }

            pstmt.executeUpdate();
        }
    }

    public ArrayList<Halte> ambilSemuaHalte() throws SQLException {
        ArrayList<Halte> daftarHalte = new ArrayList<>();

        String sql = "SELECT * FROM halte";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                daftarHalte.add(buatObjekHalte(rs));
            }
        }

        return daftarHalte;
    }

    public Halte cariHalte(String idHalte) throws SQLException {
        String sql = "SELECT * FROM halte WHERE id_halte = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idHalte);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return buatObjekHalte(rs);
                }
            }
        }

        return null;
    }

    public Halte cariHalte(String namaHalte, String lokasi)
            throws SQLException {

        String sql = "SELECT * FROM halte WHERE nama_halte = ? AND lokasi = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, namaHalte);
            pstmt.setString(2, lokasi);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return buatObjekHalte(rs);
                }
            }
        }

        return null;
    }

    public void ubahHalte(Halte halte) throws SQLException {
        String sql = "UPDATE halte SET nama_halte = ?, lokasi = ?, kapasitas = ?, rute_bus = ? WHERE id_halte = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, halte.getNamaHalte());
            pstmt.setString(2, halte.getLokasi());
            pstmt.setInt(3, halte.getKapasitas());
            pstmt.setString(4, halte.getRuteBus());
            pstmt.setString(5, halte.getIdHalte());

            pstmt.executeUpdate();
        }
    }

    public void hapusHalte(String idHalte) throws SQLException {
        String sql = "DELETE FROM halte WHERE id_halte = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idHalte);
            pstmt.executeUpdate();
        }
    }

    public int nomorIdBerikutnya() throws SQLException {
        int nomorTerbesar = 0;

        String sql = "SELECT id_halte FROM halte";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id_halte");

                if (id.matches("H[0-9]+")) {
                    int nomor = Integer.parseInt(id.substring(1));

                    if (nomor > nomorTerbesar) {
                        nomorTerbesar = nomor;
                    }
                }
            }
        }

        return nomorTerbesar + 1;
    }

    private Halte buatObjekHalte(ResultSet rs) throws SQLException {
        String id = rs.getString("id_halte");
        String nama = rs.getString("nama_halte");
        String lokasi = rs.getString("lokasi");
        int kapasitas = rs.getInt("kapasitas");
        String rute = rs.getString("rute_bus");
        String jenis = rs.getString("jenis_halte");
        String detail = rs.getString("detail_halte");

        if (jenis.equals("Reguler")) {
            return new HalteReguler(
                    id, nama, lokasi, kapasitas, rute, detail
            );
        } else {
            return new HalteTransit(
                    id, nama, lokasi, kapasitas, rute, detail
            );
        }
    }
}
