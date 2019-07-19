<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17 0017
  Time: 下午 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function onUpdata(id) {
        window.location.href="goodsLoadServlet?id="+id;
    }
    function onDelete(id) {
        window.location.href="goodsDeleteServlet?id="+id;
    }
    function onAdd() {
        window.location.href="AddData.jsp";
    }



</script>

<body><div><p><a href="logOut">退出登录</a></p><br></div>
<table border="1px" style="margin: auto">
    <caption>商品信息</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>商品名字</th>
            <th>商品图片</th>
            <th>商品价格</th>
            <th>商品简介</th>
            <th>商品库存</th>
            <th>状态值</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="goods" varStatus="s">
        <tr>
            <td>${goods.id}</td>
            <td>${goods.goodsName}</td>
            <td><img src="upload/${goods.goodsPic}" width="120px" height="120px" /></td>
            <td>${goods.goodsPrice}</td>
            <td>${goods.goodsDescription}</td>
            <td>${goods.goodsStock}</td>
            <td>${goods.flag}</td>
            <td>
                <input type="button" value="修改" onclick="onUpdata(${goods.id})">&nbsp;
                <input type="button" value="删除" onclick="onDelete(${goods.id})">
            </td>
        </tr>

        </c:forEach>
        <tr>
            <td colspan="8"><input type="button" value="新增" onclick="onAdd()"></td>
        </tr>
        </tbody>

</table>
</body>
</html>
