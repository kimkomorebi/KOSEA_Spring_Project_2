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
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>
	<form:form modelAttribute="item" action="register.html" meoth="post" enctype="multipart/form-data" onSubmit="return check(this)">
	<div align="center" class="body">
		<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
		<table>
			<tr height="40px">
				<th>상품 ID</th>
				<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td>
			</tr>
			<tr height="40px">
				<th>상품 이름</th>
				<td><form:input path="itemName" cssClass="itemName" maxlength="30"/></td>
			</tr>
			<tr height="40px">
				<th>상품 가격</th>
				<td><form:input path="price" cssClass="price" maxlength="6"/>원</td>
			</tr>
			<tr height="40px">
				<th>이미지 파일</th>
				<td><input type="file" name="pictureUrl"/></td>
			</tr>
			<tr height="40px">
				<th>상품 설명</th>
				<td><form:textarea path="info" cssClass="info"/></td>
			</tr>
		</table>
		<input type="submit" value="등 록"/>
		<input type="reset" value="취 소"/>
	</div>
	</form:form>
	<a href="index.html">돌아가기</a>
	<script type="text/javascript">
		function check(f){
			if(f.itemId.value == ''){
				alert("상품번호를 입력하세요.");
				return false;
			}
			if(f.itemName.value == ''){
				alert("상품 이름을 입력하세요.");
				return false;
			}
			if(f.price.value == ''){
				alert("상품 가격을 입력하세요.");
				return false;
			}
			if(f.pictureUrl.value == ''){
				alert("이미지 파일을 선택하세요.");
				return false;
			}
			if(f.info.value == ''){
				alert("상품 설명을 입력하세요.");
				return false;
			}
			if(! confirm("입력한 내용이 맞습니까?")) return false;
		}
	</script>
</body>
</html>