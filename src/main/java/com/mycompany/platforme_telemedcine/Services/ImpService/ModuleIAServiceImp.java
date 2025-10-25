package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.ModuleIA;
import com.mycompany.platforme_telemedcine.Repository.ModuleIARepository;
import com.mycompany.platforme_telemedcine.Services.ModuleIAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleIAServiceImp implements ModuleIAService {
    @Autowired
    private ModuleIARepository moduleIARepository;

    @Override
    public ModuleIA createModuleIA(ModuleIA moduleIA) {
        return moduleIARepository.save(moduleIA);
    }

    @Override
    public ModuleIA getModuleIAById(Long id) {
        return moduleIARepository.findModuleIAById(id);
    }

    @Override
    public ModuleIA updateModuleIA(ModuleIA moduleIA) {
        return moduleIARepository.save(moduleIA);
    }

    @Override
    public void deleteModuleIAById(Long id) {
        this.moduleIARepository.deleteById(id);
    }
}
