package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.exception.VerificationCodeException;
import org.fzu.cs03.daoyun.service.MailVerificationService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/verification/code")
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response){

        try{
            byte[] imgBytes = verificationCodeService.generateCode(request.getSession());

            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(imgBytes);
            response.getOutputStream().flush();

        } catch (Exception e){
//            e.printStackTrace();
            responseService.responseGET(StatusCode.RESPONSE_ERR,e.toString(),"");
        }



    }
}
