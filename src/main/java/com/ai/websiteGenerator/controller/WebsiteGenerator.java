package com.ai.websiteGenerator.controller;

import com.ai.websiteGenerator.service.WebsiteGeneratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/website")
public class WebsiteGenerator {


    private final WebsiteGeneratorService websiteGeneratorService;

    public WebsiteGenerator(WebsiteGeneratorService websiteGeneratorService) {
        this.websiteGeneratorService = websiteGeneratorService;
    }

    @PostMapping("/generate")
    public String generateWebsite(@RequestBody String message) {
        return websiteGeneratorService.generate(message);
    }

}
