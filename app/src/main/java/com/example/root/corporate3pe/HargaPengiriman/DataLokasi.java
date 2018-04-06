package com.example.root.corporate3pe.HargaPengiriman;

public class DataLokasi {

    int id_kecamatan;
    String lokasi;
    private String full;

    public DataLokasi(int id_kecamatan) {
    }

    public int getId_kecamatan() {
        return id_kecamatan;
    }

    public void setId_kecamatan(int id_kecamatan) {
        this.id_kecamatan = id_kecamatan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public DataLokasi (int id_kecamatan, String lokasi){
        this.setId_kecamatan(id_kecamatan);
        this.setLokasi(lokasi);
    }
}
