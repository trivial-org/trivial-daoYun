package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.exception.MailVerificationException;
import org.fzu.cs03.daoyun.exception.SignUpException;
import org.fzu.cs03.daoyun.exception.VerificationCodeException;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Component
public class SignUpService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private MailVerificationService mailVerificationService;
    @Autowired
    private VerificationCodeService verificationCodeService;

    private final Logger logger = LoggerFactory.getLogger(SignUpService.class);

    boolean checkUserName(String userName){
//        ^[a-zA-Z][a-zA-Z0-9_]\\w{5,17}$
//        ^[a-zA-Z]\\w{5,17}$
        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{3,17}$";
        return Pattern.matches(pattern,userName);
    }

//    boolean checkPassword(String password){
//        String pattern = "^[a-zA-Z][a-zA-Z0-9_]\\w{5,17}$";
//        return Pattern.matches(pattern,password);
//    }
    public void createAccount(User user, HttpSession session) throws SignUpException, MailVerificationException, VerificationCodeException {

        Date date = new Date();

        if(user.getEmail() == null) { throw new SignUpException("邮箱为空"); }
        if (user.getUsername() == null) { throw new SignUpException("用户名为空"); }
        if(user.getPassword() == null) { throw new SignUpException("密码为空"); }
        if (! this.checkUserName(user.getUsername())) { throw new SignUpException("用户名必须以字母开头，且只能包含数字、字母以及下划线，长度在6-18位之间"); }
        if (userMapper.userExist(user.getUsername())) throw new SignUpException("用户名重复");

        mailVerificationService.verify(date,user.getEmail(),user.getMailVerificationCode(),session);
        verificationCodeService.verify(date,user.getVerificationCode(),session);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        try{
            userMapper.createAccount(Role.ORDINARY_USER,user.getUsername(),user.getPassword(),user.getEmail(),dateStr,true,false );
        } catch (Exception e) {
//            e.printStackTrace();
            throw new SignUpException(e.toString());
        }
    }

    public String signUp(User user, HttpSession session) throws Exception{
            this.createAccount(user, session);
            return responseService.responseFactory(StatusCode.RESPONSE_OK,"注册成功");
    }


    public String userExist(String userName) throws Exception {
        boolean exist = false;
        exist = userMapper.userExist(userName);
        if (exist) {
            return responseService.responseFactory(StatusCode.RESPONSE_OK,"","found");
        }
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"","not found");
    }



}
