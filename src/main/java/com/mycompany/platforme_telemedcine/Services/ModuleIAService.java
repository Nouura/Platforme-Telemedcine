package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.ModuleIA;

public interface ModuleIAService {
    ModuleIA createModuleIA(ModuleIA moduleIA);
    ModuleIA getModuleIAById(Long id);
    ModuleIA updateModuleIA(ModuleIA moduleIA);
    void deleteModuleIAById(Long id);
}
