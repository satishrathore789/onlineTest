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
<form:form method="POST" action="submitRegistration.do" modelAttribute="User" >

<table border="0" cellpadding="1" cellspacing="1" align="center">
      <tr>
            <td><fmt:message key="firstname.English.hindi"></fmt:message>:</td>
            <td><form:input path="firstName" /></td><td align="right"><form:errors path="firstName"/></td>        
       
        </tr>
    <tr>
        <td><fmt:message key="lastname.English.hindi"></fmt:message>:</td>
        <td><form:input path="lastName"/></td><td align="right"><form:errors path="lastName"/></td>
    </tr>
     <tr>
        <td><fmt:message key="Email.English.hindi"></fmt:message>:</td>
        <td><form:input path="emailId"/></td><td align="right"><form:errors path="emailId"/></td>
    </tr>
    <tr>
        <td><fmt:message key="mobile.English.hindi"></fmt:message>:</td>
        <td><form:input path="mobiles"/></td><td align="right"><form:errors path="mobiles"/></td>
       
    </tr>
    <tr>
        <td><fmt:message key="password.English.hindi"></fmt:message>:</td>
        <td><form:password path="passwords"/></td> <td align="right"><form:errors path="passwords"/></td>
       
    </tr>
    
   <tr>
       <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="<fmt:message key="signup.English.hindi"></fmt:message>"  /></td>
          </tr>
          
        </table>
      </form:form>
</body>
</html>