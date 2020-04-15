package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.exception.SignOutException;
import org.fzu.cs03.daoyun.utils.SessionMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SignOutService {
    @Autowired
    private ResponseService responseService;

    @Autowired
    private SessionMapUtils sessionMapUtils;

    private final Logger logger = LoggerFactory.getLogger(SignOutService.class);

    public String signOut(String submitUser , HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userName");
        if (submitUser == null) throw new SignOutException("异常注销，注销验证失败");
        if (obj == null) throw new SignOutException("异常注销，未发现登录用户,请联系管理员修复");
        String userName = obj.toString();
        if ( ! submitUser.equals(userName) ) throw new SignOutException("异常注销，提交用户信息错误");
        session.removeAttribute("userName");
        sessionMapUtils.removeSession(userName,request);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"注销成功");
    }
}
