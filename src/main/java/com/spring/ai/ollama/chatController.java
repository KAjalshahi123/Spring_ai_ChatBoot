package com.spring.ai.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class chatController {

    private final ChatClient chatClient;

    public chatController(ChatClient.Builder builder){
        this.chatClient  = builder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("q") String q) {
        return chatClient
                .prompt(q)
                .call()
                .content();
    }
}