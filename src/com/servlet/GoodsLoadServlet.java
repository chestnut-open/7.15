package com.servlet;

import com.Dao.GoodsDao;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String errMsg ="";
        try {
            String id1 = req.getParameter("id");
            if(id1==null || id1.equals("")){
                throw new RuntimeException("id不能为空"); }

            GoodsDao goodsDao = new GoodsDao();
            int id = Integer.parseInt(id1);  //字符串转int
            Goods queryGoods = new Goods(id);
            List<Goods> list = goodsDao.findByGoods(queryGoods);

            if(list == null && list.size()<1){
                throw new  RuntimeException("该id找不到");
            }
            req.setAttribute("goods",list.get(0));
        } catch (RuntimeException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        if("".equals(errMsg)){
            req.getRequestDispatcher("updataGoods.jsp").forward(req,resp);
        }else {

        }

    }
}
