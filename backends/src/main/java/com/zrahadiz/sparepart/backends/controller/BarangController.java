package com.zrahadiz.sparepart.backends.controller;

import com.zrahadiz.sparepart.backends.entity.Barang;
import com.zrahadiz.sparepart.backends.repository.BarangRepository;
import com.zrahadiz.sparepart.backends.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/main")
public class BarangController {
    @Autowired
    private BarangRepository barangRepository;
    @Autowired
    private BarangService barangService;

    @PostMapping(path = "/add")
    public @ResponseBody Barang addNewBarang(@RequestParam String namaBarang, @RequestParam double hargaJual, @RequestParam double hargaBeli, @RequestParam String satuan, @RequestParam String kategori, @RequestParam int stok){
        System.out.println("test" + namaBarang);
        Barang springBarang = new Barang();
        springBarang.setNamaBarang(namaBarang);
        springBarang.setHargaJual(hargaJual);
        springBarang.setHargaBeli(hargaBeli);
        springBarang.setSatuan(satuan);
        springBarang.setKategori(kategori);
        springBarang.setStok(stok);
        barangRepository.save(springBarang);
        return springBarang;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Barang> getAllBarang(){
        Iterable<Barang> data = barangRepository.findAll();
        return barangRepository.findAll();
    }

    @GetMapping(path = "/barang/{id}")
    public ResponseEntity<Optional<Barang>> getBarangById(@PathVariable(value = "id")
            Long id){
        return barangService.fetchProductById(id);
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<Barang> updateBarang(@PathVariable(value = "id")
                                               Long id, @RequestBody Barang barang){
        return barangService.updateProduct(id, barang);
    }

    @DeleteMapping(path = "/barang/{id}")
    public String deleteBarang(@PathVariable(value = "id") Long id){
        barangService.deleteBarang(id);
        return "Barang dengan id " + id + " berhasil dihapus";
    }
}
