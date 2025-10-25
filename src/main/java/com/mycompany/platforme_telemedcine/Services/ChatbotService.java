package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.Chatbot;

public interface ChatbotService {
    Chatbot createChatbot(Chatbot chatbot);
    void deleteChatbotById(Long id);
    Chatbot getChatbotById(Long id);
}
