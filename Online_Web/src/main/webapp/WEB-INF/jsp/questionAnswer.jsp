<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
<form:form method="POST"  action="questionAnswer.do"  modelAttribute="questions" >

<table border="0" cellpadding="1" cellspacing="1" align="center">
      <tr>
            <td><fmt:message key="question.English.hindi"></fmt:message>:</td>
            <td><form:input path="questions" /></td>         
       
        </tr>
    <tr>
        <td><fmt:message key="option1.English.hindi"></fmt:message>:</td>
        <td> <form:input path="option1"  /></td>
        </tr>
        <tr>
        <td><fmt:message key="option2.English.hindi"></fmt:message>:</td>
        <td><form:input path="option2" /></td>
        </tr>
        <tr>
        <td><fmt:message key="option3.English.hindi"></fmt:message>:</td>
        <td><form:input path="option3"   /></td>
        </tr>
        <tr>
        <td><fmt:message key="option4.English.hindi"></fmt:message>:</td>
        <td><form:input path="option4" /></td> 
        </tr>
   <tr>
       <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="<fmt:message key="insertq.English.hindi"></fmt:message>"  /></td>
          </tr>   
        </table>
      </form:form>
       <c:choose>
      <c:when test="${fatch.isEmpty()}">
      <%--  <c:set var="msg" value="no record found"/>
      <c:out value="${msg}"></c:out>
       --%>
       <tr  align="center">
       <td bgcolor="white">no record found</td>
       </tr>
          </c:when>
     <c:otherwise>    
      <table border="1" width="100%">
      <thead>
        <tr>
          <th><fmt:message key="question.English.hindi"></fmt:message></th>
          <th><fmt:message key="option1.English.hindi"></fmt:message></th>
          <th><fmt:message key="option2.English.hindi"></fmt:message></th>
          <th><fmt:message key="option3.English.hindi"></fmt:message></th>
          <th><fmt:message key="option4.English.hindi"></fmt:message></th>
        </tr>
      </thead>
      
      <tbody>
      <c:forEach items="${fatch}" var="count">
        <tr>   
          <td>${count.questions}</td>      	
          <td>${count.option1}</td>  
          <td>${count.option2}</td>
          <td>${count.option3}</td>
          <td>${count.option4}</td>
     </tr>
      </c:forEach>
      
    </tbody>
      </table>
      </c:otherwise>
      </c:choose>
</body>
</html>