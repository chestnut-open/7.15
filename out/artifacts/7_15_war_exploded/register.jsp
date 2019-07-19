<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 下午 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
    function onCheck() {
        var flag =true;
        flag = flag && onUsername();
        flag = flag&&onPassword();
if(flag){
    // alert("注册成功！");
    }
    }
    function onUsername() {
        var usernameObj=document.getElementById("username");
        if(usernameObj.value){
            return true;
        }else {
            alert("用户名不能为空！");
            return false;
        }
    }
    function onPassword() {
        var passwordObj=document.getElementById("password");
        var repasswordObj=document.getElementById("repassword");
        if(passwordObj.value && repasswordObj.value){
            if(passwordObj.value!=repasswordObj.value){
                alert("两次输入密码不一致！")
                return false;
            }
            return true;
        }else {
            alert("密码不能为空！");
            return false;
        }
    }




        
    </script>
</head>
<body>
<form action="registerServlet" method="post"  onsubmit="return onCheck()">
<table style="margin: auto" border="1px">
    <caption>用户注册</caption>
    <thead></thead>
    <tbody>
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="username" id="username" /></td>
    </tr>
    <tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" name="password" id="password" /></td>
    </tr>
    <tr>
        <td>确认密码：</td>
        <td><input type="password" name="repassword" id="repassword" /></td>
    </tr>
    <tr>
        <td>性别：</td>
        <td><input type="text" name="sex" id="sex" /></td>
    </tr>
    <tr>
        <td>爱好：</td>
        <td><input type="text" name="hob" id="hob" /></td>
    </tr>
    <tr>
        <td>手机号码：</td>
        <td><input type="text" name="numb" id="numb" /></td>
    </tr>
    <tr>
        <td>电子邮箱：</td>
        <td><input type="text" name="email" id="email" /></td>
    </tr>
    <tr>
        <td>地址：</td>
        <td><input type="text" name="add" id="add" /></td>
    </tr>
    <tr>
        <td>状态值：</td>
        <td><input type="text" name="flag" id="flag" /></td>
    </tr>

    <tr>
        <td colspan="2" style="text-align: center">
            <input type="submit" value="注册" />&nbsp;
            <input type="reset" value="重置">&nbsp;
            <a href="login.jsp"><input type="button" value="已经注册">&nbsp;</a>
        </td>
    </tr>
    </tbody>
</table>
</form>
</body>
</html>
