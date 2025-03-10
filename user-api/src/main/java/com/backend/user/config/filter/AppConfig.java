package com.backend.user.config.filter;

import com.siot.IamportRestClient.IamportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    String apiKey = "6808364708163846";
    String secretKey = "c5pB4Xza7QQyzOl5MiBss3TtsZomnTwhBNrJmusADaQ7cTGgDOEIf15y0Tyiq8Ly49BEoAIE0QgVAPjl";

    @Bean
    public IamportClient iamportClient() {
        return new IamportClient(apiKey, secretKey);
    }
}

