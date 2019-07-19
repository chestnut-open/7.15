<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17 0017
  Time: 下午 11:55
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
<form action="goodsUpdataServlet" method="post">
    <input type="hidden" name="id" value="${goods.id}">
    <table>
        <tbody>
        <tr>
            <td>商品名字</td>
            <td><input type="text" name="goodsName" value="${goods.goodsName}"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><input type="text" name="goodsPic" value="${goods.goodsPic}"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="goodsPrice" value="${goods.goodsPrice}"></td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td><input type="text" name="goodsDescription" value="${goods.goodsDescription}"></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input type="text" name="goodsStock" value="${goods.goodsStock}"></td>
        </tr>
        <tr>
            <td>状态值</td>
            <td><input type="text" name="flag" value="${goods.flag}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存" ></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
