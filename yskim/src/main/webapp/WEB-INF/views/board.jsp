<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class ="container">
	<form action ="#" method="post" id="frm" name ="frm" onsubmit="return deltable()">
		<table class="table table-hover">
			<thead>
				<tr>
					<td align="left" colspan="7">
						<input class = "btn btn-danger" type = "button" value ="글입력" onclick="writeForm()">
						<input class = "btn btn-danger" type = "submit" value ="선택 글 삭제">
						<c:if test="${not empty loginDto.id}">
							<span>${loginDto.id}님 환영합니다.</span>
							<input class="btn btn-active" type =button value ="로그아웃" onclick ="logout()">
						</c:if>
						<c:if test="${empty loginDto.id}">
							<input class="btn btn-active" type =button value ="로그인" onclick ="loginForm()">
						
						</c:if>
					</td>
				</tr>
				<tr>
					<th><input type="checkbox" onclick = "checkAll(this.checked)"></th>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>delflag</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<jsp:useBean id="format" class ="com.min.edu.usebean.InputList"></jsp:useBean>
					<jsp:setProperty property="lists" name="format" value = "${lists}"/>
					<jsp:getProperty property="listForm" name="format"/>
				</tr>
		</table>
	</form>
</div>
</body>
<script type="text/javascript">
function checkAll(bool){
	var chkval = document.getElementsByName('chkval');
	for(var i=0; i<chkval.length; i++)
		chkval[i].checked =bool;
	
}
function deltable(){
	var chkval = document.getElementsByName('chkval');
	var n = 0;
	for(var i = 0; i < chkval.length; i++){
		if(chkval[i].checked){
			n++;
		}
	}	
	if(n>0){
		document.getElementById('frm').action="./multiDel.do";
	}else{
		alert("삭제 오류 !! 한개 이상의 삭제값을 선택하세요");
		return false;
	}
}
function writeForm(){
	location.href ="./writeForm.do";
}
function logout(){
	location.href ="./logout.do";
}
function loginForm(){
	location.href ="./loginForm.do";
}
</script>
</html>