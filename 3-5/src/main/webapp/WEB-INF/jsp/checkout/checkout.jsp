<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>구매 화면</h2>
	<font color="red">
		<b>배송 받을 곳</b>
	</font>
	<table>
		<tr>
			<th>사용자 ID</th>
			<td>${loginUser.userId }</td>
		</tr>
		<tr>
			<th>이 름</th>
			<td>${loginUser.userName }님</td>
		</tr>
		<tr>
			<th>주 소</th>
			<td>${loginUser.address }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${loginUser.email }</td>
		</tr>
	</table><br/>
	<font color="red"><b>구매 목록</b></font>
	<table>
		<tr>
			<th width="200">상품명</th>
			<th width="150">가 격</th>
			<th width="50">갯 수</th>
			<th width="150">소 계</th>
		</tr>
		<c:forEach items="${itemList }" var="itemSet">
			<tr>
				<td align="left">${itemSet.item.itemName }</td>
				<td align="right">${itemSet.item.price }</td>
				<td align="right">${itemSet.quantity }개</td>
				<td align="right">${itemSet.quantity * itemSet.item.price }원</td>
			</tr>
		</c:forEach>
	</table><br/><br/>
	<b>총액 : ${totalAmount }원</b><br/><br/>
	<form action="../end/end.html">
		<input type="submit" value="구매 확정" name="btn"/>
	</form>
</div>
</body>
</html>