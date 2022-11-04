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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="WEB-INF/style.css">
</head>
<body>
	<%@ include file="menu_header.jsp" %>
	
		<div align="center">
			<table border="1">
				<tr>
					<th class="menuTitle">�����</th>
					<th class="menuTitle">���� �뷮</th>
					<th class="menuTitle">���� ����</th>
					<th class="menuTitle">��� ������</th>
					<th class="menuTitle">���� ����</th>
					<th colspan="2"  class="menuInfo">���</th>
				</tr>
				<c:forEach items="${drinkList }" var="drink">
					<tr>
					<form:form action="../drink/cartAdd.html" method="get">
						<input type="hidden" value="${drink.drinkNum }" name="drinkNum"/>
						<td class="menuInfo">${drink.drinkName }</td>
						<td class="menuInfo">${drink.drinkSize }</td>
						<td class="menuInfo">${drink.price }</td>
						<td class="menuInfo">${drink.origin }</td>
						<td class="menuInfo">${drink.info }</td>
						<td class="menuInfo"><input type="number" min="1" name="orderCount" value="1" id="orderCount"></td>
						<td class="menuInfo"><input type="submit" value="��ٱ��� ���"></td>
					</form:form>
					</tr>
					</c:forEach>
				
			</table>
		</div>
	
</body>
</html>