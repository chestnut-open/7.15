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

public class GoodsUpdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int rows=0;
        String errMsg ="";
        String id1 = req.getParameter("id");
        int id = Integer.parseInt(id1);
        String goodsName = req.getParameter("goodsName");
        String goodsPic = req.getParameter("goodsPic");
        String goodsPrice = req.getParameter("goodsPrice");
        String goodsDescription = req.getParameter("goodsDescription");
        String goodsStock = req.getParameter("goodsStock");
        String flag = req.getParameter("flag");


        try {
//            if(id<1){throw new RuntimeException("id不能小于1！");}
            if(goodsName==null || "".equals(goodsName)){throw new RuntimeException("商品名不为空！");}
            if(goodsPic==null || "".equals(goodsPic)){throw new RuntimeException("展示图片不为空！");}
            if(goodsPrice==null || "".equals(goodsPrice)){throw new RuntimeException("商品价格不为空！");}
            if(goodsDescription==null || "".equals(goodsDescription)){throw new RuntimeException("商品简介不为空！");}
            if(goodsStock==null || "".equals(goodsStock)){throw new RuntimeException("商品库存不为空！");}
            if(flag==null || "".equals(flag)){throw new RuntimeException("状态值不为空！");}

            Goods updata = new Goods( id,  goodsName,  goodsPic,  goodsPrice,  goodsDescription,  goodsStock ,flag);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.updataGoods(updata);
        } catch (RuntimeException e) {
            e.printStackTrace();
            errMsg=e.getMessage();
        } if(rows>0){
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
