package com.servlet;

import com.Dao.GoodsDao;
import com.Dao.UsersDao;
import com.entity.Goods;
import com.entity.users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GoodsQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session =req.getSession();
//        users userinfo =(users)session.getAttribute("userinfo");
//        if(userinfo!=null){
            GoodsDao goodsDao = new GoodsDao();
            List<Goods> list= goodsDao.findByGoods(null);
            req.setAttribute("list",list);
            req.getRequestDispatcher("GoodsList.jsp").forward(req,resp);
//        }else {
//            PrintWriter out =resp.getWriter();
//            out.println("<script type='text/javascript'>alert('页面未登录！');location.href='login.jsp';</script>");
//        }


//        for(Goods g:list){
//            System.out.println(g.toString());
//        }
    }
}
