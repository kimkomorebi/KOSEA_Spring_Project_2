<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ���</title>
</head>
<body>
	<c:forEach items="${drinkSet }" var="drinkSet">
		<p>${drinkSet.drinkName }</p>
		<p>${drinkSet.orderCount }</p>
		<p></p>
	</c:forEach>
	<div align="center">
		<h3>��ٱ��� ����Ʈ</h3>
		<table border="1">
			<tr>
				<th>�����</th>
				<th>�ֹ� ����</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>