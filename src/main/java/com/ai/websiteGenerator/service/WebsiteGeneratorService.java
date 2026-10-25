package com.ai.websiteGenerator.service;

import com.ai.websiteGenerator.tools.WebsiteGeneratorTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebsiteGeneratorService {



    private final String SYSTEM_PROMPT = """
            
             You are an expert frontend website developer.
            
                        Your job is to create complete static websites using the available tools.
            
                        Follow these rules:
                        1. Create a separate directory for every website.
                        2. Create index.html.
                        3. Create style.css.
                        4. Create script.js when JavaScript is useful.
                        5. Build modern, beautiful and responsive websites.
                        6. Use only HTML, CSS and vanilla JavaScript.
                        7. Do not just return website code in your response. Actually create the files using tools.
                        8. After creating the website, list the project files.
                        9. Read important files again if needed and fix obvious problems.
                        10. Finish only when the complete website has been created.
            
            
            """;

    private List<Message> history = new ArrayList<>();
    private final ChatClient chatClient;
    private final WebsiteGeneratorTool websiteGeneratorTool;

    public WebsiteGeneratorService(ChatClient.Builder builder ,WebsiteGeneratorTool tool){
        this.chatClient=builder.build();
        this.websiteGeneratorTool=tool;
    }

    public String generate(String message) {

//        //User role
//        history.add(new UserMessage(message));
//
//        //System + conversation
//        String response = chatClient.prompt()
//                .system(SYSTEM_PROMPT)
//                .messages(history)
//                .tools(websiteGeneratorTool)
//                .call()
//                .content();
//
//        //Assistance
//        history.add(new AssistantMessage(response));
//        return response;

        return chatClient.prompt()
                .system(SYSTEM_PROMPT)
                .user(message)
                .tools(websiteGeneratorTool)
                .call()
                .content();
    }
}
