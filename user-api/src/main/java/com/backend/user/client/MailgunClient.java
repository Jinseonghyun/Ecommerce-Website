package com.backend.user.client;

import com.backend.user.client.mailgun.SendMailForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mailgun", url = "https://api.mailgun.net/v3/")
@Qualifier("mailgun")
public interface MailgunClient {
    @PostMapping("sandboxf52b5a538f344185a7a8fbdc20b37fd9.mailgun.org/messages")
    String sendEmail(@SpringQueryMap SendMailForm form);
}


