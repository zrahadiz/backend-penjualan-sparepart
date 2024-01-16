package com.zrahadiz.sparepart.backends.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Penjualan")
public class Penjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noFaktur;

    @Column(nullable = false)
    private Date tanggalFaktur;

    @Column(nullable = false)
    private String namaKonsumen;

    @Column(nullable = false)
    private Long kodeBarang;

    @Column(nullable = false)
    private int jumlahBeli;

    @Column(nullable = false)
    private double hargaSatuan;

    @Column(nullable = false)
    private double hargaTotal;

    public Long getNoFaktur() {
        return noFaktur;
    }

    public Date getTanggalFaktur() {
        return tanggalFaktur;
    }

    public void setTanggalFaktur(Date tanggalFaktur) {
        this.tanggalFaktur = tanggalFaktur;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public void setNamaKonsumen(String namaKonsumen) {
        this.namaKonsumen = namaKonsumen;
    }

    public Long getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(Long kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public double getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(double hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
}
