package com.zrahadiz.sparepart.backends.controller;

import com.zrahadiz.sparepart.backends.entity.Barang;
import com.zrahadiz.sparepart.backends.entity.Penjualan;
import com.zrahadiz.sparepart.backends.repository.BarangRepository;
import com.zrahadiz.sparepart.backends.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "transactions")
public class PenjualanController {
    @Autowired
    private PenjualanRepository penjualanRepository;
    @Autowired
    private BarangRepository barangRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Penjualan> getAllPenjualan(){
        Iterable<Penjualan> data = penjualanRepository.findAll();
        return penjualanRepository.findAll();
    }

    @PostMapping(path = "/buy")
    public ResponseEntity<Penjualan> addTransaction(@RequestBody Penjualan penjualan){
        Barang springBarang = new Barang();
        Optional<Barang> barangById = barangRepository.findById(penjualan.getKodeBarang());
        barangById.get().setStok(barangById.get().getStok() - penjualan.getJumlahBeli());
        Barang updateStok = barangRepository.save(barangById.get());
        Penjualan newTransaction = penjualanRepository.save(penjualan);
        return ResponseEntity.ok(newTransaction);
    }
}
