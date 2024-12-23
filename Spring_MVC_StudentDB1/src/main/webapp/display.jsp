<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.jsp.spring_mvc.studentdb.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Student> sList=(List) request.getAttribute("studentList");%>
<table border="1">
<tr>
<th>StudentId</th>
<th>StudentName</th>
<th>StudentEmail</th>
<th>StudentAge</th>
<th>StudentCourse</th>
<th>Update</th>
<th>Delete</th>
</tr>

<% for(Student student: sList){ %>
<tr>
<td><%=student.getStudentId()%></td>
<td><%=student.getStudentName()%></td>
<td><%=student.getStudentEmail()%></td>
<td><%=student.getStudentAge()%></td>
<td><%=student.getStudentCourse()%></td>
<td><a href="find-student-by-id?studentId=<%=student.getStudentId()%>">update</a></td>
<td><a href="delete-student-by-id?studentId=<%=student.getStudentId()%>">delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>