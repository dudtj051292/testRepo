<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page isErrorPage="true" %>
<%
response.setStatus(200);
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>404 에러페이지</title>

<script type="text/javascript">

	alert('화면을 찾을 수 없습니다. \n이전 화면으로 돌아갑니다.');

	history.back();

</script>

</head>


</html>



