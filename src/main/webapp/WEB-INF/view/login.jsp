<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /WEB-INF/view/login.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>로그인화면</title></head>
<body><h2>사용자 로그인</h2>
<form:form modelAttribute="user" method="post" action="login.shop">
  <spring:hasBindErrors name="user"><font color="red">
      <c:forEach items="${errors.globalErrors}" var="error">
         <spring:message code="${error.code}" />
      </c:forEach></font></spring:hasBindErrors>
 <table border="1" style="border-collapse: collapse;">
   <tr height="40px"><td>아이디</td><td><form:input path="userid" />
     <font color="red"><form:errors path="userid" /></font></td></tr>
   <tr height="40px"><td>비밀번호</td><td><form:password path="password" />
        <font color="red"><form:errors path="password" /></font></td></tr>
   <tr height="40px"><td colspan="2" align="center">
<input type="submit" value="로그인"><input type="button" value="회원가입" 
   onclick="location.href='userEntry.shop'"></td></tr></table>
</form:form></body></html>