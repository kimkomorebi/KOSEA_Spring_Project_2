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
				<th>��ǰ ID</th>
				<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td>
			</tr>
			<tr height="40px">
				<th>��ǰ �̸�</th>
				<td><form:input path="itemName" cssClass="itemName" maxlength="30"/></td>
			</tr>
			<tr height="40px">
				<th>��ǰ ����</th>
				<td><form:input path="price" cssClass="price" maxlength="6"/>��</td>
			</tr>
			<tr height="40px">
				<th>�̹��� ����</th>
				<td><input type="file" name="pictureUrl"/></td>
			</tr>
			<tr height="40px">
				<th>��ǰ ����</th>
				<td><form:textarea path="info" cssClass="info"/></td>
			</tr>
		</table>
		<input type="submit" value="�� ��"/>
		<input type="reset" value="�� ��"/>
	</div>
	</form:form>
	<a href="index.html">���ư���</a>
	<script type="text/javascript">
		function check(f){
			if(f.itemId.value == ''){
				alert("��ǰ��ȣ�� �Է��ϼ���.");
				return false;
			}
			if(f.itemName.value == ''){
				alert("��ǰ �̸��� �Է��ϼ���.");
				return false;
			}
			if(f.price.value == ''){
				alert("��ǰ ������ �Է��ϼ���.");
				return false;
			}
			if(f.pictureUrl.value == ''){
				alert("�̹��� ������ �����ϼ���.");
				return false;
			}
			if(f.info.value == ''){
				alert("��ǰ ������ �Է��ϼ���.");
				return false;
			}
			if(! confirm("�Է��� ������ �½��ϱ�?")) return false;
		}
	</script>
</body>
</html>