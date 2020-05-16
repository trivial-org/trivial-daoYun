package org.fzu.cs03.daoyun.share;

import org.fzu.cs03.daoyun.utils.SessionMapUtils;
import org.fzu.cs03.daoyun.utils.SystemParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class UserSecurityInterceptor implements HandlerInterceptor {

    @Autowired
    SessionMapUtils sessionMapUtils;

    private final Logger logger = LoggerFactory.getLogger(UserSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("userName");
        String userName ;

        if (obj == null) userName = null;
        else userName = obj.toString();

//        request.getRequestURI(); 获得请求的页面

        if (obj == null || ! sessionMapUtils.isActiveSession(userName,request)) {
//            response.sendRedirect(request.getContextPath() + "/signin");
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write("非法操作，请先登录或提权. 非法代码: "+
                    request.getSession().getId() + "");
            pw.flush();
            pw.close();

            logger.info(request.getSession().getId() + " 非法访问: "+ request.getRequestURI());
//            System.out.println("非法登录");
            return false; //若为true,response.getWriter();会被重新调用，会报错.
        }
//        System.out.println("已验证的登录");
        logger.info(userName + " 受验证访问: "+ request.getRequestURI());

        SystemParams.userName = userName;
//        SystemParams.userName = userName;

//        String info = userName + "：已验证的登录";
//        logger.info(info);

//      request.getSession().setMaxInactiveInterval(3) ; // 删除该会话
//        request.getad
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
