/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class HalteTransit extends Halte {
    private String rutePenghubung;

    public HalteTransit(String idHalte, String namaHalte, String lokasi,
                        int kapasitas, String ruteBus,
                        String rutePenghubung) {
        super(idHalte, namaHalte, lokasi, kapasitas, ruteBus);
        setRutePenghubung(rutePenghubung);
    }

    public String getRutePenghubung() {
        return rutePenghubung;
    }

    public void setRutePenghubung(String rutePenghubung) {
        if (rutePenghubung != null && !rutePenghubung.trim().isEmpty()) {
            this.rutePenghubung = rutePenghubung;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        tampilkanJenisHalte();
        System.out.println("Rute Penghubung: " + rutePenghubung);
    }

    @Override
    public void tampilkanJenisHalte() {
        System.out.println("Jenis Halte     : Transit");
    }
}
