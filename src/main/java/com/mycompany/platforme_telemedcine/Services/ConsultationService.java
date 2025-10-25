package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.Consultation;

import java.util.List;


public interface ConsultationService {
    Consultation createConsultation(Consultation consultation);
    Consultation getConsultationById(Long id);
    Consultation updateConsultation(Consultation consultation);
    void deleteConsultation(Long id);
    List<Consultation> getAllConsultations();
}
