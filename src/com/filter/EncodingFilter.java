package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         encoding = filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding(encoding);
//        servletResponse.setCharacterEncoding(encoding);
//        servletResponse.setContentType("text/html;charset=utf-8");
     //   filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.setCharacterEncoding(encoding);
        // 2、设置响应的编码
        // 服务器发送给客户的内容的编码方式
        servletResponse.setCharacterEncoding(encoding);
        // 浏览器以什么编码方式执行
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
