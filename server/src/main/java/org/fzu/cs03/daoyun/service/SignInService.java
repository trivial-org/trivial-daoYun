package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSONObject;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.exception.SignInException;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.utils.TokenMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SignInService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private TokenMapUtils tokenMapUtils;

    @Autowired
    private VerificationCodeService verificationCodeService;

    private final Logger logger = LoggerFactory.getLogger(SignInService.class);

    boolean isPhoneNumber(String userName){
        return Character.isDigit(userName.charAt(0)) ;
    }
    public String signIn(User user, HttpServletRequest request) throws Exception{
        String username = user.getUsername();
        String password = user.getPassword();
        Long userId;


        // 若当前用户登录为手机号，则找到对应用户名
        if (username!= null && isPhoneNumber(username)) {
            username = userMapper.getUserNameByPhone(username);
            if (username == null){
                throw new SignInException("无法搜索到手机号对应的用户名");
            }
        }

        if (username == null || password == null) throw new SignInException("用户名或密码为空");
        if (! userMapper.userExist(username)) throw new SignInException("用户不存在");
        if (! userMapper.getUserPassword(username).equals(password)) throw new SignInException("密码不正确");
        //验证码认证
//        verificationCodeService.verify(new Date(),user.getVerificationCode(),request.getSession());

        userId = userMapper.getUserIdByUserName(username);

//        String oldUserName ;
//        Object obj = request.getSession().getAttribute("userName");
//
//        if (obj == null)
//            oldUserName = null;
//        else
//            oldUserName = obj.toString();
//
//
//
//        // 若session已绑定用户，且与当前用户不一致，则删除当前绑定
//        if (oldUserName != null && ! oldUserName.equals(userName) ) {
//            tokenMapUtils.removeSession(oldUserName,request);
//        }
//        Long userId = userMapper.getUserIdByUserName(userName);

//        request.getSession().setAttribute("userName",userName);
//        request.getSession().setAttribute("userId",userId);

        String token = request.getSession().getId();

        JSONObject loginResult = new JSONObject();
        loginResult.put("id", userId);
        loginResult.put("token", token);

        tokenMapUtils.updateToken(userId,token, request);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"登录成功",loginResult);
    }

}
