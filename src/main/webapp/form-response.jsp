<html>
<body>
<h2>Hello World!</h2>

<p>
<%
String name = request.getParameter("name");

if(name == null)
	out.print("No name parameter was passed");
else
	out.print("Passed name from form is " + name);
%>
</p>

</body>
</html>
