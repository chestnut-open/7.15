package com.servlet;

import com.Dao.UsersDao;
import com.entity.users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        String errMsg ="";
        int rows = 0;
        try {
            String username = req.getParameter("username"); //获取页面“name属性的值”
            String password = req.getParameter("password");
            String repassword = req.getParameter("repassword");

            if(username==null || "".equals(username)
                 ||  password==null || "".equals(password)
                 ||  repassword==null || "".equals(repassword)) {
                throw new RuntimeException("用户名或密码不为空！");
            }
            if(!password.equals(repassword)){
                throw new RuntimeException("两次输入密码不一致");
            }
            users use = new users(username, password);
            UsersDao usersDao = new UsersDao();
            rows =usersDao.insertUsers(use);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows>0){
            // 表示修改成功
            out.println("<script type='text/javascript'>alert('注册成功');location.href='login.jsp';</script>");
        }else{
            // 修改失败
            out.println("<script type='text/javascript'>alert('注册失败："+errMsg+"');history.back();</script>");
        }



    }
}
