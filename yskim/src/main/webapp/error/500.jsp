<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>

<%

response.setStatus(200);

%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>500 오류 페이지</title>

<script type="text/javascript">

	alert('오류가 발생하였습니다. \n서비스 오류가 발생했습니다. 시스템 담당자에게 문의해 주세요.');

	history.back();

</script>

</head>


</html>



