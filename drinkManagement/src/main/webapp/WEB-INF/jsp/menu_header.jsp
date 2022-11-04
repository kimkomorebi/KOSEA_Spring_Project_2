<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header>
	<div align="center">
		<h2>���� �ֹ� �ý���</h2>
	</div>
	<nav>
		<ul>
			<li><a href="../drink/result.html">��ٱ���</a></li>
			<li><a href="#">����ϱ�</a></li>
			<li><a href="#">�ֹ� ���</a></li>
			<li><a href="#">���ο� ���� ���</a></li>
			<li><a href="../drink/index.html">�޴� ������� ���ư���</a></li>
			<c:choose>
				<c:when test="${ ! empty login }">
					<li>
						<font color="blue">
							ȯ���մϴ�!! ${login.userName } ��
						</font>
						<a href="../loginform/login.html">�α׾ƿ�</a>
					</li>
				</c:when>
				<c:when test="${ empty login }">
					<li><a href="../loginform/login.html">�α���</a></li>
				</c:when>
			</c:choose>
		</ul>
	</nav>
</header>