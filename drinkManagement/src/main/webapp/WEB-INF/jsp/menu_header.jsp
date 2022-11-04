<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header>
	<div align="center">
		<h2>음료 주문 시스템</h2>
	</div>
	<nav>
		<ul>
			<li><a href="../drink/result.html">장바구니</a></li>
			<li><a href="#">계산하기</a></li>
			<li><a href="#">주문 목록</a></li>
			<li><a href="#">새로운 음료 등록</a></li>
			<li><a href="../drink/index.html">메뉴 목록으로 돌아가기</a></li>
			<c:choose>
				<c:when test="${ ! empty login }">
					<li>
						<font color="blue">
							환영합니다!! ${login.userName } 님
						</font>
						<a href="../loginform/login.html">로그아웃</a>
					</li>
				</c:when>
				<c:when test="${ empty login }">
					<li><a href="../loginform/login.html">로그인</a></li>
				</c:when>
			</c:choose>
		</ul>
	</nav>
</header>