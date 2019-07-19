package com.filter;

import com.entity.users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter {
    private List<String> urlFilterList = Arrays.asList(
            "/login.jsp",
            "/loginSession",
            "/loginServlet",
            "/register.jsp",
            "/registerServlet",
            ".jpg",
            ".png",
            ".bmp"
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        // 1、获得请求的uri
        // url: http://localhost:8080/loginServlet?username=admin&password=123
        // uri: /loginServlet?username=admin&password=123
        // "/loginServlet",
        String uri = req.getRequestURI();

        // 1) 哪些url是要放行的
        boolean flag = false;//如果flag为false表示没有找到要放行的url
        if(urlFilterList!=null && urlFilterList.size()>0){
            for(String uriStr:urlFilterList){
                // 判断uri的值是不是以uriStr开头，如果是返回true，否则返回false
                if(uriStr.indexOf("/")==0){
                    if(uri.startsWith(uriStr)){
                        flag = true;
                        break;
                    }
                }else{
                    if(uri.endsWith(uriStr)){
                        flag = true;
                        break;
                    }
                }

            }
        }

        if(flag){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            // 2) 除了第1点要放行的url之外其它的url都要进行登录的验证的过滤
            // 获得session中保存的User对象
            HttpSession session = req.getSession();
            users loginUser = (users) session.getAttribute("userinfo");
            if(loginUser!=null){//表示已登录过
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                PrintWriter out = resp.getWriter();
                out.println("<script type='text/javascript'>alert('修改失败!');history.back();</script>");
                req.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }


    @Override
    public void destroy() {

    }
}
