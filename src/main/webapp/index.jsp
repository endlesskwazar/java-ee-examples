<%@ include file="layouts/head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jstl.beans.domain.Person, java.util.List" %>

<h1>List</h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Age</th>
      <th scope="col">PhoneNumber</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="person" items="${ list }">
    <tr>
    	<td>${person.id}</td>
    	<td>${person.name}</td>
    	<td>${person.age}</td>
    	<td>${person.phoneNumber}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>


<%@include file="layouts/footer.jsp"%>
