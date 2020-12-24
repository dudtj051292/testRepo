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
<form action="./write.do" method="post">
	<table class ="table table-striped">
		<thead>
			<tr>	
				<th colspan="2"><a href="./movetoBoard.do"><h1>&lsaquo;</h1></a></th>
			</tr>
		</thead>
		<tbody>			
			<tr>	
				<th>작성자</th>
				<td ><input type="text" name = "id" id = "id" value ="${loginDto.id}" readonly="readonly" style="border-style: none; background: none"> </td>
			</tr>
			<tr>	
				<th>제목</th>
				<td>
					<input style="width: 100%" id = "title" name ="title" type="text" placeholder="제목"  required="required"/ >
				</td>
			</tr>
			<tr>	
				<th id = "content_text">내용</th>
				<td >
					<textarea id ="content" rows="10" name="content" style="width: 100%;" placeholder="내용"  required="required"></textarea>
				</td>
			</tr>
			<tr>	
				<td id ="btns" colspan="2" style="text-align: right">
					<input type="submit" class="btn btn-warning" value = "작성 완료">
					<input type="reset" class="btn btn-warning" value = "초기화">
				</td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</body>

</html>