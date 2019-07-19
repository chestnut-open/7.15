package com.servlet;

import com.Dao.GoodsDao;
import com.entity.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class AddDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows=0;
        String errMsg ="";

//        String goodsName = req.getParameter("goodsName");
//        String goodsPic = req.getParameter("goodsPic");
//        String goodsPrice = req.getParameter("goodsPrice");
//        String goodsDescription = req.getParameter("goodsDescription");
//        String goodsStock = req.getParameter("goodsStock");
//        String flag = req.getParameter("flag");


        try {
            Goods goods =this.uploadFile(req,resp);
//
//            if(goodsName==null || "".equals(goodsName)){throw new RuntimeException("商品名不为空！");}
//            if(goodsPic==null || "".equals(goodsPic)){throw new RuntimeException("展示图片不为空！");}
//            if(goodsPrice==null || "".equals(goodsPrice)){throw new RuntimeException("商品价格不为空！");}
//            if(goodsDescription==null || "".equals(goodsDescription)){throw new RuntimeException("商品简介不为空！");}
//            if(goodsStock==null || "".equals(goodsStock)){throw new RuntimeException("商品库存不为空！");}
//            if(flag==null || "".equals(flag)){throw new RuntimeException("状态值不为空！");}

           // Goods add = new Goods(  goodsName,  goodsPic,  goodsPrice,  goodsDescription,  goodsStock ,flag);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.addGoods(goods);
        } catch (RuntimeException e) {
            e.printStackTrace();
            errMsg=e.getMessage();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if(rows>0){
            // 表示修改成功
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('添加成功');location.href='goodsQueryServlet';</script>");
        }else{
            // 修改失败
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('添加失败："+errMsg+"');history.back();</script>");
        }
    }
    public Goods uploadFile(HttpServletRequest req,HttpServletResponse resp) throws FileUploadException, IOException {
        Goods goods = new Goods();
        // 1、判断当前表单是否为上传表单
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(isMultipart){
            // 上传表单：表示是enctype:multipart/form-data
            // 2、如果是上传表单
            //   2.1 创建ServletFileUpload对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            //   2.2 获得上传表单里的所有控件对象
            List<FileItem> fileItemList = upload.parseRequest(req); //arpseRequest
            //   2.3 遍历
            if(fileItemList!=null && fileItemList.size()>0){
                for(FileItem fileItem:fileItemList){
                    //   2.4 判断控件对象是普通表单控件还是上传表单控件
                    if(fileItem.isFormField()){

                        if("goodsName".equals(fileItem.getFieldName())){
                            goods.setGoodsName(fileItem.getString("utf-8"));
                        }else if("goodsPrice".equals(fileItem.getFieldName())){
                            goods.setGoodsPrice(fileItem.getString("utf-8"));
                        }else if("goodsDescription".equals(fileItem.getFieldName())){
                            goods.setGoodsDescription((fileItem.getString("utf-8")));
                        }else if("goodsStock".equals(fileItem.getFieldName())){
                            goods.setGoodsStock(fileItem.getString("utf-8"));
                        }else if("flag".equals(fileItem.getFieldName())){
                            goods.setFlag(fileItem.getString());
                        }
                    }else{
                        // 上传表单控件：<input type="file">
                        // 2.4.1 获得文件名
                        String fileName = fileItem.getName();

                        // 2.4.2 将文件上传到指定的服务器目录
                        // 获得web工程在tomcat下的绝对路径
                        String parentPath = req.getServletContext().getRealPath("/upload");
                        // 判断目录是否存在，如果不存在就需要创建
                        File parentFile = new File(parentPath);
                        // parentFile.exists()：返回true表示目录存在
                        // parentFile.mkdirs()：用于创建目录
                        if(!parentFile.exists()) parentFile.mkdirs();
                        // 如果不报错，就将这个文件名设置到对象属性中
                        // 获得上传文件的文件对象
                        File newFile = new File(parentFile,fileName);
                        // 写文件
                        // 获得输入流和输出流
                        // 输入流用于读文件
                        InputStream is = fileItem.getInputStream();
                        // 输出流用于写文件
                        OutputStream os = new FileOutputStream(newFile);
                        // 写文件操作
                        IOUtils.copy(is, os);
                        // 关闭流：由内往外关
                        os.close();
                        is.close();
                        // 设置上传文件的文件名保存在对象属性中
                        goods.setGoodsPic(fileName);
                    }
                }
            }

        }else{
            // 普通表单
        }
        return goods;
    }













}
