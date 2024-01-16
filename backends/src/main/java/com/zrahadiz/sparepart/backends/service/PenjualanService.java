package com.zrahadiz.sparepart.backends.service;

import com.zrahadiz.sparepart.backends.repository.PenjualanRepository;
import org.springframework.stereotype.Service;

@Service
public class PenjualanService {
    private final PenjualanRepository penjualanRepository;

    public PenjualanService(
            PenjualanRepository penjualanRepository)
    {
        this.penjualanRepository = penjualanRepository;
    }
}
