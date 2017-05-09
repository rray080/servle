<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int x = 20;

	int checkEven() {
		if (x % 2 != 0)
			return 0;
		return 1;
	}%>
	<%
		if (checkEven() == 0)
			x = x + 1;
		else
			x = x + 2;
	%>
	<%=x%>
</body>
</html>