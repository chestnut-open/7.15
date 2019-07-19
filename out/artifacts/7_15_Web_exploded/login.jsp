<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 下午 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function oncli() {
           window.location.href='register.jsp';
        }
    </script>
    
</head>
<body>
<form action="loginServlet" method="post"  onsubmit="return onCheck()">
    <table style="margin: auto" border="1px">
        <caption>用户登录</caption>
        <thead></thead>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"  /></td>
        </tr><br>
        <tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"   /></td>
        </tr><br>

            <td colspan="2" style="text-align: center">
                <input type="submit" value="登录" />&nbsp;
                <input type="button" value='注册' onclick="oncli()" />
            </td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
