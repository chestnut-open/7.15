package com.servlet;

import com.Dao.UsersDao;
import com.entity.users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errMsg = "";
        String username = req.getParameter("username"); //获取页面“name属性的值”
        String password = req.getParameter("password");

        if (username != null && !username.equals("") &&
            password != null && !password.equals("")) {

            users query = new users(username, password);
            UsersDao usersDao = new UsersDao();
            List<users> list = usersDao.findByUser(query);
            try {

                if (list == null && list.size() < 1) {   //取反，抛出异常
                    throw new RuntimeException("该姓名找不到");
                }
                req.setAttribute("use", list.get(0));//设置到作用域中
            } catch (Exception e) {
                e.printStackTrace();
                errMsg = e.getMessage();
            }
                if ("".equals(errMsg)) { //错误信息为空// 表示取到数据

                    // 将用户对象存入会话
                    HttpSession session = req.getSession(); // 获得会话
                    session.setAttribute("userinfo", query); // 通过方法将用户对象存入
                    //跳转到商品列表
//                    resp.sendRedirect("loginSession");
                    req.getRequestDispatcher("loginSession").forward(req, resp);
                } else {
                    PrintWriter out = resp.getWriter();
                    out.println("<script type='text/javascript'>alert('数据加载失败：" + errMsg + "');history.back();</script>");
                }
            }else{
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('登录账号密码不为空！请重新输入！');history.back();</script>");
            }
     }
 }
