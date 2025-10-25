package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Chatbot;
import com.mycompany.platforme_telemedcine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatbotRepository extends JpaRepository<Chatbot, Long> {
    Chatbot findChatbotById(long id);

    Chatbot findChatbotByPatient(Patient patient);
}
