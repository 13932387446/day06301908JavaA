package com.zyl.interceptor;

import com.zyl.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/14 0014
 * @描述
 **/
public class PowerInterceptor implements HandlerInterceptor {

    private List<String> exceptUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if (exceptUrls.contains(uri)){
           return true;
        }else {
            User user = (User) request.getSession().getAttribute("user");
            if(user!=null){
                /*
                登录成功只能访问自己的，所以吧当前用户拥有的URL查出来
                再进行判断，用户目前拥有的URL在数据库，
                还有一部分（比如按钮）没有
                 */
                Set<String> set = (Set<String>) request.getSession().getAttribute("set");
                if(set!=null){
                    uri = uri.substring(1);
                    if(set.contains(uri)){
                        return true;
                    }else {
                        request.setAttribute("msg","非法访问,你已越权！");
                        request.getRequestDispatcher("index.jsp").forward(request,response);
                        return false;
                    }
                }
                return false;
            }else {
                request.setAttribute("msg","请先登录！");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

}
