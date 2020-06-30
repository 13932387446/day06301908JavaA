package com.zyl.filter;

import com.zyl.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/14 0014
 * @描述
 **/

public class PowerFilter implements Filter {

    Set<String> notUrls = new HashSet<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String notCheckUrl = filterConfig.getInitParameter("notCheckUrl");
        for (String s : notCheckUrl.split(",")) {
            notUrls.add(s.trim());
        }
        System.out.println(notCheckUrl);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //获取过滤的uri
        String uri = req.getRequestURI();
        if (notUrls.contains(uri)){
            chain.doFilter(request,response);
        }else {
            User user = (User) req.getSession().getAttribute("user");
            if(user!=null){
                Set<String> set = (Set<String>) req.getSession().getAttribute("set");
                if(set!=null){
                    uri = uri.substring(1);
                    if(set.contains(uri)){
                        chain.doFilter(request,response);
                    }else {
                        request.setAttribute("msg","非法访问,你已越权！");
                        request.getRequestDispatcher("index.jsp").forward(request,response);
                    }
                }
            }else {
                req.setAttribute("msg","请先登录！");
                request.getRequestDispatcher("index.jsp").forward(req,response);
            }
        }
        System.out.println(uri);
    }

    @Override
    public void destroy() {

    }
}
