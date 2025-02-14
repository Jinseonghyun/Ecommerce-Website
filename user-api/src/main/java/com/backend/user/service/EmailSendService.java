package com.backend.user.service;

import com.backend.user.client.MailgunClient;
import com.backend.user.client.mailgun.SendMailForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final MailgunClient mailgunClient;

    public String sendEmail() {
        SendMailForm form = SendMailForm.builder()
                .from("USER@sandboxf52b5a538f344185a7a8fbdc20b37fd9.mailgun.org")
                .to("jinsunghyun9@naver.com")
                .subject("Test email")
                .text("my text")
                .build();
         return mailgunClient.sendEmail(form);
    }
}
