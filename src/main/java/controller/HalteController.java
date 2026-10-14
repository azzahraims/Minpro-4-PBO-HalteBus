/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.HalteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Halte;

/**
 *
 * @author user
 */
public class HalteController {

    private HalteDAO halteDAO;

    public HalteController() {
        halteDAO = new HalteDAO();
    }

    public String buatIdHalte() {
        try {
            int nomorId = halteDAO.nomorIdBerikutnya();
            String idHalte;

            if (nomorId < 10) {
                idHalte = "H00" + nomorId;
            } else if (nomorId < 100) {
                idHalte = "H0" + nomorId;
            } else {
                idHalte = "H" + nomorId;
            }

            return idHalte;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void tambahHalte(Halte halte) {
        try {
            halteDAO.tambahHalte(halte);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ArrayList<Halte> getDaftarHalte() {
        try {
            return halteDAO.ambilSemuaHalte();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void tampilkanSemuaHalte() {
        ArrayList<Halte> daftarHalte = getDaftarHalte();

        for (Halte halte : daftarHalte) {
            halte.tampilkanInfo();
            System.out.println("---------------------------");
        }
    }

    public Halte cariHalte(String idHalte) {
        try {
            return halteDAO.cariHalte(idHalte);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Halte cariHalte(String namaHalte, String lokasi) {
        try {
            return halteDAO.cariHalte(namaHalte, lokasi);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void ubahHalte(Halte halte, String namaBaru,
                          String lokasiBaru, int kapasitasBaru,
                          String ruteBaru) {

        halte.setNamaHalte(namaBaru);
        halte.setLokasi(lokasiBaru);
        halte.setKapasitas(kapasitasBaru);
        halte.setRuteBus(ruteBaru);

        try {
            halteDAO.ubahHalte(halte);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void hapusHalte(Halte halte) {
        try {
            halteDAO.hapusHalte(halte.getIdHalte());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public boolean dataKosong() {
        return getDaftarHalte().isEmpty();
    }
}
