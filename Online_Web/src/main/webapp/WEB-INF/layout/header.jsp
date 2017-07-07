<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
</head>
<body>
		
<c:choose>
	<c:when test="${sessionScope.Userr!=null}">
				
<div style="background: #E0E0E0; height: 80px; padding: 10px; width: 100%;">
  <div style="float: left">
     <h1><c:out value="${sessionScope.Userr.emailId}" /></h1>
  </div>
 
  <div style="float: right; height:70px; padding: 5px; text-align: right;">
 
     Search <input name="search">
    
  
  <div style="float: right; height:20px; padding: 60px; width:0; text-align: right; ">
 
  <a href="logout.do">Logout</a>
    
  </div>
 </div>
 </div>
 </c:when>
 </c:choose>
 
</body>
</html>