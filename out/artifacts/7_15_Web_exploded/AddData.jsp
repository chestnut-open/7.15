<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/18 0018
  Time: 下午 5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">



    </script>
</head>
<body>
<form action="addDataServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="">
    <table>
        <tbody>
        <tr>
            <td>商品名字</td>
            <td><input type="text" name="goodsName" value=""></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><input type="file" name="goodsPic" value=""></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="goodsPrice" value=""></td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td><input type="text" name="goodsDescription" value=""></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input type="text" name="goodsStock" value=""></td>
        </tr>
        <tr>
            <td>状态值</td>
            <td><input type="text" name="flag" value=""></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存" ></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>

