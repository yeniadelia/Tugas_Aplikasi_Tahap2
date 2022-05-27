/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kipasangin2.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author YENI
 */
public class kipasproperty {
    
    private StringProperty kd_kipas;
    private StringProperty nama_produk;
    private StringProperty tgl_produksi;
    private StringProperty merk;
    private StringProperty ukuran;
    private StringProperty harga;

    public kipasproperty(String kd_kipas, String nama_produk, String tgl_produksi, String merk, String ukuran, String harga) {
        this.kd_kipas = new SimpleStringProperty(kd_kipas);
        this.nama_produk = new SimpleStringProperty(nama_produk);
        this.tgl_produksi = new SimpleStringProperty(tgl_produksi);
        this.merk = new SimpleStringProperty(merk);
        this.ukuran = new SimpleStringProperty(ukuran);
        this.harga = new SimpleStringProperty(harga);
    }
    
    public kipasproperty(kipas k) {
        this.kd_kipas = new SimpleStringProperty(k.getKd_kipas());
        this.nama_produk = new SimpleStringProperty(k.getNama());
        this.tgl_produksi = new SimpleStringProperty(k.getTglProduksi());
        this.merk = new SimpleStringProperty(k.getMerk());
        this.ukuran = new SimpleStringProperty(k.getUkuran());
        this.harga = new SimpleStringProperty(k.getHarga());
    }
    
    public StringProperty getKd_kipasproperty() {
        return kd_kipas;
    }

    public void setKd_kipas(String kd_kipas) {
        this.kd_kipas = new SimpleStringProperty (kd_kipas);
    }

    public StringProperty getNama_produkProperty() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = new SimpleStringProperty (nama_produk);
    }

    public StringProperty getTgl_produksiProperty() {
        return tgl_produksi;
    }

    public void setTgl_produksi(String tgl_produksi) {
        this.tgl_produksi = new SimpleStringProperty (tgl_produksi);
    }

    public StringProperty getMerkProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty (merk);
    }

    public StringProperty getUkuranProperty() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = new SimpleStringProperty (ukuran);
    }

    public StringProperty getHargaProperty() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = new SimpleStringProperty (harga);
    }

    public String getKd_kipas() {
        return kd_kipas.get();
    }

    public String getNama_produk() {
        return nama_produk.get();
    }

    public String getTgl_produksi() {
        return tgl_produksi.get();
    }

    public String getMerk() {
        return merk.get();
    }

    public String getUkuran() {
        return ukuran.get();
    }

    public String getHarga() {
        return harga.get();
    }
}
    

