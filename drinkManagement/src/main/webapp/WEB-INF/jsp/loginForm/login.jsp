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
</head>
<body>
	<%@ include file="../menu_header.jsp" %>
<div align="center" class="body">
	<form:form action="login.html" method="post" modelAttribute="user">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors }" var="err">
				<!-- globalErrors = new HashMap �÷��� �����ӿ�ũ map Ű�� ���� ������ �ִ�. ������Ƽ��� ���� -->
					<spring:message code="${err.code }" />
				</c:forEach>
			</font>
		</spring:hasBindErrors><!-- ������ -->
		<table>
			<tr height="40px">
				<th>�����ID</th>
				<td>
					<form:input path="userId" cssClass="userId"/>
					<font color="red"><form:errors path="userId"/></font>
				</td>
			</tr>
			<tr height="40px">
				<th>�� ȣ</th>
				<td>
					<form:password path="password" cssClass="password"/>
					<font color="red"><form:errors path="password"/></font>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center">
					<input type="submit" value="�α���"/>
				</td>
				<td>
					<input type="reset" value="���"/>
				</td>
			</tr>
		</table>
	</form:form><br/>
	<a href="../userentryform/userEntry.html">�� �ű� ������ ���</a>
	</div>

</body>
</html>