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
<div class ="container">
<input type ="button"  value = "로그인 하지 않고 게시판으로 이동" onclick = "movetoBoard()">

<form action="./login.do" method = "post">
	<table class ="table table-hover">
		<thead>
			<tr class= "warning">
				<th>아아디</th>
				<td><input type = "text" name = "id" id = "id" required="required"></td>
			</tr>
			<tr class= "active">
				<th>비밀번호</th>
				<td><input type = "password" name = "pw" id = "pw" required="required"></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input class="btn btn-warning" type = "submit" value = "로그인">
					<input class="btn btn-warning" type = "button" value = "회원가입" onclick="signUp()">
				</td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</body>
<script type="text/javascript">
	function movetoBoard(){
		location.href = "./movetoBoard.do"
	}
	function signUp(){
		location.href ="./signupForm.do"
	}
</script>
</html>