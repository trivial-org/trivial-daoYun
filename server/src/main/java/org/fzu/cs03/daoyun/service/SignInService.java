package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.exception.SignInException;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.utils.DeviceType;
import org.fzu.cs03.daoyun.utils.SessionMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class SignInService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private SessionMapUtils sessionMapUtils;

    @Autowired
    private VerificationCodeService verificationCodeService;

    private final Logger logger = LoggerFactory.getLogger(SignInService.class);

    boolean isPhoneNumber(String userName){
        return Character.isDigit(userName.charAt(0)) ;
    }
    public String signIn(User user, HttpServletRequest request) throws Exception{
        String userName = user.getUserName();
        String password = user.getPassword();
        String oldUserName ;
        Object obj = request.getSession().getAttribute("userName");

        if (userName == null || password == null) throw new SignInException("用户名或密码为空");
        if (! userMapper.userExist(userName)) throw new SignInException("用户不存在");
        if (! userMapper.getUserPassword(userName).equals(password)) throw new SignInException("密码不正确");
        //验证码认证
//        verificationCodeService.verify(new Date(),user.getVerificationCode(),request.getSession());

        if (obj == null)
            oldUserName = null;
        else
            oldUserName = obj.toString();

        // 若当前用户登录为手机号，则找到对应用户名，sessionMapper中存储的必须是userName，不能为手机号
        try{
            if (isPhoneNumber(userName))
                userName = userMapper.getUserNameByPhone(userName);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new SignInException("无法搜索到手机号对应的用户名");
        }

        // 若session已绑定用户，且与当前用户不一致，则删除当前绑定
        if (oldUserName != null && ! oldUserName.equals(userName) ) {
            sessionMapUtils.removeSession(oldUserName,request);
        }
        request.getSession().setAttribute("userName",userName);
        sessionMapUtils.updateSession(userName, request);

        long userId = userMapper.getUserIdByUserName(userName);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"登录成功",userId);
    }

}
