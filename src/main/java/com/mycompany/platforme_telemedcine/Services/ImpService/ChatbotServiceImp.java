package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.Chatbot;
import com.mycompany.platforme_telemedcine.Repository.ChatbotRepository;
import com.mycompany.platforme_telemedcine.Services.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotServiceImp implements ChatbotService {
    @Autowired
    private ChatbotRepository chatbotRepository;

    @Override
    public Chatbot createChatbot(Chatbot chatbot) {
        return chatbotRepository.save(chatbot);
    }

    @Override
    public void deleteChatbotById(Long id) {
        this.chatbotRepository.deleteById(id);
    }

    @Override
    public Chatbot getChatbotById(Long id) {
        return chatbotRepository.findById(id).get();
    }
}
