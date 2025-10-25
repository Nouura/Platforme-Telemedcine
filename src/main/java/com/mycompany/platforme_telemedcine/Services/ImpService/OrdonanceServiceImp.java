package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.Ordonance;
import com.mycompany.platforme_telemedcine.Repository.OrdonanceRepository;
import com.mycompany.platforme_telemedcine.Services.OrdonanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdonanceServiceImp implements OrdonanceService {
    @Autowired
    OrdonanceRepository ordonanceRepository;

    @Override
    public Ordonance createOrdonance(Ordonance ord) {
        return ordonanceRepository.save(ord);
    }

    @Override
    public Ordonance findOrdonanceById(Long id) {
        return ordonanceRepository.findOrdonanceById(id);
    }

    @Override
    public Ordonance updateOrdonance(Ordonance ord) {
        return ordonanceRepository.save(ord);
    }

    @Override
    public void deleteOrdonance(Long id) {
        this.ordonanceRepository.findOrdonanceById(id);
    }

    @Override
    public List<Ordonance> getAllOrdonance() {
        return ordonanceRepository.findAll();
    }
}
