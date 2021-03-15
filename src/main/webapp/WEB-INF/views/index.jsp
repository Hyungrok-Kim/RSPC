<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="resources/css/login.css" />	

<title>Insert title here</title>
</head>
 <body>
 		<c:if test="${empty member}">
        <div class="wrap">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">로그인</button>
                    <button type="button" class="togglebtn" onclick="register()">회원가입</button>
                </div>
                <form id="login" action="${pageContext.request.contextPath}/users/userLogin.do" method="post" class="input-group">
                    <input type="text" name="id" class="input-field" placeholder="회원 아이디" required>
                    <input type="password" name="pwd" class="input-field" placeholder="비밀번호" required><br /><br />
                    <button class="submit">로그인</button>
                </form>
                <form id="register" action="${pageContext.request.contextPath}/users/userJoin.do" method="post" class="input-group">
                    <input type="text" name="id" class="input-field" placeholder="회원 아이디" required>
                    <input type="text" name="mname" class="input-field" placeholder="회원 이름" required>
                    <input type="password" name="pwd" class="input-field" placeholder="비밀번호" required><br /><br />
                    <button class="submit">회원가입</button>
                </form>
            </div>
        </div>
        </c:if>
        
        <c:if test="${!empty member}">
        ${member.mname}님 반갑습니다. R&S 피시방입니다.
        <a href="${pageContext.request.contextPath}/users/userLogout.do">로그아웃</a>
        </c:if>
        <script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
        </script>
    </body>
</html>