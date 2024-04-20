package com.ffd.api.controller;

import com.ffd.api.service.MailService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    // 이메일 인증번호 발송 G-Mail
    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(@RequestBody Map<String, String> map, HttpSession session){

        int number = mailService.sendMail(map.get("mail"));
        session.setAttribute("number", number);
        String num = "" + number;

        return num;
    }

    @PostMapping("/mail/chk")
    public ResponseEntity<Boolean> verifyCode(@RequestParam("inputCode") String inputCode, HttpSession session) {
        String storedCode = (String) session.getAttribute("number");

        if (storedCode != null && storedCode.equals(inputCode)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}