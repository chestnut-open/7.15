package com.servlet;

import com.Dao.GoodsDao;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows=0;
        String errMsg ="";
        try {
            String id1 = req.getParameter("id");
            if(id1==null || id1.equals("")){
                throw new RuntimeException("id不能为空"); }
            int id = Integer.parseInt(id1);
            Goods goods =new Goods(id);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.deleteGoods(goods);
        } catch (RuntimeException e) {
            e.printStackTrace();
           errMsg= e.getMessage();
        }
        if(rows>0){
            // 表示修改成功
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('修改成功');location.href='goodsQueryServlet';</script>");
        }else{
            // 修改失败
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('修改失败："+errMsg+"');history.back();</script>");
        }
    }
}
