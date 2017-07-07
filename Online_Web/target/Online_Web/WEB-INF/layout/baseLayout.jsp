<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<div style="width: 100%"> <tiles:insertAttribute name="header" /> </div>
<div style="width: 100%"> <tiles:insertAttribute name="manu" /> </div>
<div style="width: 100%"> <tiles:insertAttribute name="body" /> </div>
<div style="width: 100%"> <tiles:insertAttribute name="footer" /> </div>

 <%--  <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td colspan="2" align="left"><tiles:insertAttribute name="header" />
      </td>
    </tr>
    <tr>
      <tr>
      <td height="20"><tiles:insertAttribute name="manu" /></td>

    <tr>
      <td valign="top" bgcolor="#E6E6cb"><tiles:insertAttribute name="body" />
      </td>
    </tr>
    <tr>
      <td colspan="2" align="left"><tiles:insertAttribute name="footer" />
      </td>
    </tr>
    
  </table> --%>
</body>
</html>