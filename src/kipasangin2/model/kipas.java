/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kipasangin2.model;

/**
 *
 * @author YENI
 */
public class kipas {
    
    private String kd_kipas;
    private String nama;
    private String tglProduksi;
    private String merk;
    private String ukuran;
    private String harga;

    public kipas (String kd_tv, String nama, String tglProduksi, String merk, String ukuran, String harga) {
        this.kd_kipas = kd_kipas;
        this.nama = nama;
        this.tglProduksi = tglProduksi;
        this.merk = merk;
        this.ukuran = ukuran;
        this.harga = harga;
    }

    public void setKd_kipas(String kd_kipas) {
        this.kd_kipas = kd_kipas;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTglProduksi(String tglProduksi) {
        this.tglProduksi = tglProduksi;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKd_kipas() {
        return kd_kipas;
    }

    public String getNama() {
        return nama;
    }

    public String getTglProduksi() {
        return tglProduksi;
    }

    public String getMerk() {
        return merk;
    }

    public String getUkuran() {
        return ukuran;
    }

    public String getHarga() {
        return harga;
    }

   

    
    
}
    

