/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public abstract class Halte implements InformasiHalte {
    private final String idHalte;
    private String namaHalte;
    private String lokasi;
    private int kapasitas;
    private String ruteBus;

    public Halte(String idHalte, String namaHalte, String lokasi,
                 int kapasitas, String ruteBus) {
        this.idHalte = idHalte;
        setNamaHalte(namaHalte);
        setLokasi(lokasi);
        setKapasitas(kapasitas);
        setRuteBus(ruteBus);
    }

    public String getIdHalte() {
        return idHalte;
    }

    public String getNamaHalte() {
        return namaHalte;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getRuteBus() {
        return ruteBus;
    }

    public void setNamaHalte(String namaHalte) {
        if (namaHalte != null && !namaHalte.trim().isEmpty()) {
            this.namaHalte = namaHalte;
        }
    }

    public void setLokasi(String lokasi) {
        if (lokasi != null && !lokasi.trim().isEmpty()) {
            this.lokasi = lokasi;
        }
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        }
    }

    public void setRuteBus(String ruteBus) {
        if (ruteBus != null && !ruteBus.trim().isEmpty()) {
            this.ruteBus = ruteBus;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Halte    : " + idHalte);
        System.out.println("Nama Halte  : " + namaHalte);
        System.out.println("Lokasi      : " + lokasi);
        System.out.println("Kapasitas   : " + kapasitas);
        System.out.println("Rute Bus    : " + ruteBus);
    }

    public abstract void tampilkanJenisHalte();
}