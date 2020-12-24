<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class = "container">
	<form action="./signup.do" method="post" style="width: 600px">
		<table class ="table">
			<thead>
				<tr class="active">
					<th>아이디</th>
					<td><input style="width:100%;" type ="text" name = "id" placeholder="아이디 입력" required="required"></td>
				</tr>
				<tr class="active">
					<th>비밀번호</th>
					<td><input style="width:100%;" type ="password" name = "pw" placeholder="비밀번호 입력" required="required"></td>
				</tr>
				<tr class="active">
					<th>이름</th>
					<td><input style="width:100%;" type ="text" name = "name" placeholder="이름 입력" required="required"></td>
				</tr>
			</thead>
			<tbody>			
				<tr  style="text-align: center">
					<td colspan ="2">
						<input type ="submit" value ="회원가입">	
						<input type ="reset" value ="초기화">	
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>