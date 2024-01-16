package com.zrahadiz.sparepart.backends.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kodeBarang;

    @Column(nullable = false)
    private String namaBarang;

    @Column(nullable = false)
    private double hargaJual;

    @Column(nullable = false)
    private double hargaBeli;

    @Column(nullable = false)
    private String satuan;

    @Column(nullable = false)
    private String kategori;

    @Column(nullable = false)
    private int stok;

    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }

    public void setHargaJual(double hargaJual){
        this.hargaJual = hargaJual;
    }
    public void setHargaBeli(double hargaBeli){
        this.hargaBeli = hargaBeli;
    }

    public void setSatuan(String satuan){
        this.satuan = satuan;
    }

    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    public Long getKodeBarang(){
        return this.kodeBarang;
    }

    public String getNamaBarang(){
        return this.namaBarang;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }
}
