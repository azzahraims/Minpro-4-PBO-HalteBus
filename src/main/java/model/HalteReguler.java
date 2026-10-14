/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class HalteReguler extends Halte {
    private String titikTujuan;

    public HalteReguler(String idHalte, String namaHalte, String lokasi,
                        int kapasitas, String ruteBus,
                        String titikTujuan) {
        super(idHalte, namaHalte, lokasi, kapasitas, ruteBus);
        setTitikTujuan(titikTujuan);
    }

    public String getTitikTujuan() {
        return titikTujuan;
    }

    public void setTitikTujuan(String titikTujuan) {
        if (titikTujuan != null && !titikTujuan.trim().isEmpty()) {
            this.titikTujuan = titikTujuan;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        tampilkanJenisHalte();
        System.out.println("Titik Tujuan: " + titikTujuan);
    }

    @Override
    public void tampilkanJenisHalte() {
        System.out.println("Jenis Halte : Reguler");
    }
}
