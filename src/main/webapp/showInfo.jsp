<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info about person</title>
</head>
<body>

<jsp:useBean id="person" class="jsp.beans.domain.Person" scope="page">
	<jsp:setProperty name="person" property="*" />
</jsp:useBean>

<%= person.getName()  %>

</body>
</html>