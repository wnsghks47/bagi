<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp!</title>
</head>
<body>
<h2>jstl2.jsp</h2>
리스트적용
<%
List<String> nameList=new ArrayList<String>(Arrays.asList("이름4","이름5","이름6"));
request.setAttribute("name3", nameList);
List<String> nameList2=new ArrayList<String>(Arrays.asList("이름7","이름8","이름9"));
request.setAttribute("name4", nameList2);
%>
<%-- <c:forEach var="name" items="이름1,이름2,이름3">
	 <br /> ${name }
</c:forEach> --%>

<%-- <c:forEach var="name" items="${name3 }" varStatus="st">
	<br />${st.count } : <c:out value="${name }" />
</c:forEach> --%>

<%-- <c:forEach var="list3" items="${name3 }" varStatus="st">
	<br />${list3 } : ${name4[st.index]} 
</c:forEach>
 --%>

<%-- <c:forEach var="i" begin="0" end="9" >
	<br /><c:out value="${i }" />
</c:forEach> --%>
<hr />
<br />
if <br />

<%-- <c:forEach begin="1" end="10" var="i" varStatus="st">
${i }
<c:if test="${not st.last }">,</c:if>
</c:forEach>
 --%>
<c:set value="0" var="n" />
<c:forEach var="i" begin="1" end="10" varStatus="st">
${i }
<c:set value="${n+i }" var="n" />
<c:if test="${not st.last }">,</c:if>
</c:forEach>
sum:${n }
<br />
<hr />
<c:set value="0" var="n" scope="application" />
<c:forEach var="i" begin="1" end="10" varStatus="st">
${i }
<c:set value="${n+i }" var="n" />
<c:if test="${not st.last }">,</c:if>
</c:forEach>
sum:${n }
<br />
</body>
</html>