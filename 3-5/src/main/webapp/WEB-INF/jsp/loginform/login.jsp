<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 화면</title>
<link href="../css/3-5.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
	<div align="center" class="body">
	<form:form action="login.html" method="post" modelAttribute="user">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors }" var="err"><!-- globalErrors = new HashMap 컬렉션 프레임워크 map 키와 값을 가지고 있다. 프로퍼티즈와 연결 -->
					<spring:message code="${err.code }" />
				</c:forEach>
			</font>
		</spring:hasBindErrors><!-- 폼에러 -->
		<table>
			<tr height="40px">
				<th>사용자ID</th>
				<td>
					<form:input path="userId" cssClass="userId"/>
					<font color="red"><form:errors path="userId"/></font>
				</td>
			</tr>
			<tr height="40px">
				<th>암 호</th>
				<td>
					<form:password path="password" cssClass="password"/>
					<font color="red"><form:errors path="password"/></font>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center">
					<input type="submit" value="로그인"/>
				</td>
				<td>
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>