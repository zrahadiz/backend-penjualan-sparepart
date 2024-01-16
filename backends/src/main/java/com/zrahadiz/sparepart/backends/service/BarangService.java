package com.zrahadiz.sparepart.backends.service;

import com.zrahadiz.sparepart.backends.entity.Barang;
import com.zrahadiz.sparepart.backends.repository.BarangRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class BarangService {
    private final BarangRepository barangRepository;

    public BarangService(BarangRepository barangRepository){
        this.barangRepository = barangRepository;
    }


    public ResponseEntity<Optional<Barang> > fetchProductById(Long Id){
        Optional<Barang> barang = barangRepository.findById(Id);
        if(barang.isPresent()){
            return ResponseEntity.ok(barang);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Barang> updateProduct(Long Id, Barang updatedBarang){
        if(Id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        Barang Existingbarang = barangRepository.findById(Id).orElseThrow(
                ()
                        -> new EntityNotFoundException(
                        String.valueOf(Id)));
        Existingbarang.setNamaBarang(updatedBarang.getNamaBarang());
        Existingbarang.setHargaBeli(updatedBarang.getHargaBeli());
        Existingbarang.setHargaJual(updatedBarang.getHargaJual());
        Existingbarang.setSatuan(updatedBarang.getSatuan());
        Existingbarang.setKategori(updatedBarang.getKategori());
        Existingbarang.setStok(updatedBarang.getStok());
        Barang savedEntity = barangRepository.save(Existingbarang);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<String> deleteBarang(Long id){
        barangRepository.deleteById(id);
        return ResponseEntity.ok("Barang berhasil dihapus");
    }
}



