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
	<table class ="table table-striped">
		<thead>
			<tr>	
				<th colspan="2"><a href="./movetoBoard.do"><h1>&lsaquo;</h1></a></th>
			</tr>
		</thead>
		<tbody>			
			<tr>	
				<th>작성자</th>
				<td>${lists.id}</td>
			</tr>
			<tr>	
				<th>제목</th>
				<td>
					<input style="width: 100%; border-style: none;background: none;" id = "title" type="text" value="${lists.title}" readonly="readonly"/ >
				</td>
			</tr>
			<tr>	
				<th id = "content_text">내용</th>
				<td >
					<textarea style ="border-style: none; background: none;" id ="content" rows="10" cols="120"  readonly="readonly">${lists.content}</textarea>
				</td>
			</tr>
			<tr>	
				<td id ="btns" colspan="2" style="text-align: right">
					<input type="button" class="btn btn-warning" value = "글수정" onclick ="modify(${lists.seq})">
					<input type="button" class="btn btn-warning" value = "글삭제" onclick ="delete(${lists.seq})">
					<input type="button" class="btn btn-warning" value = "답  글" onclick ="reply(${lists.seq})">
				</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript">
	content_text = document.getElementById("content_text");
	content = document.getElementById("content");
	var text = content.textContent;
	
	function modify(val){
		content_text.textContent = "내용 (수정)";
		content.textContent ="";
		$("#content").attr("readonly" ,false);
		$("#btns").children().remove();
		var newbtn = "<input type='button' class='btn btn-warning' value = '수정 완료' onclick ='modifyFinish("+val+")'>";
		newbtn += "<input type='button' class='btn btn-warning' value = '수정 취소' onclick ='modifycancel("+val+")'>";

		$("#btns").append(newbtn);
	}
	function modifyFinish(val){
		var content = $("#content").val();
		if($("#content").val().length >0 ){
			location.href ="./modifyFinish.do?seq="+val+"+&content="+content;
		}else{
			alert("내용을 입력해 주세요");
		}
	}
	
	function modifycancel(val){
		$("#btns").children().remove();
		content_text.textContent = "내용";
		content.textContent = text;
		$("#content").attr("readonly" ,true);
		$("#title").attr("readonly" ,true);
		var btn = ""
		btn += "<input type='button' class='btn btn-warning' value = '글수정' onclick ='modify("+val+")'>";
		btn += "<input type='button' class='btn btn-warning' value = '글삭제' onclick ='delete("+val+")'>";
		btn += "<input type='button' class='btn btn-warning' value = '답  글' onclick ='reply("+val+")'>";
		$("#btns").append(btn);
	}
	function reply(val){
		content_text.textContent = "내용 (답글)";
		content.textContent ="";
		$("#title").val("");
		$("#content").attr("readonly" ,false);
		$("#title").attr("readonly" ,false);
		$("#btns").children().remove();
		var newbtn = "<input type='button' class='btn btn-info' value = '작성 완료' onclick ='replyFinish("+val+")'>";
		newbtn += "<input type='button' class='btn btn-info' value = '작성 취소' onclick ='modifycancel("+val+")'>";

		$("#btns").append(newbtn);
	}
	function replyFinish(val){
		var content = $("#content").val();
		var title = $("#title").val();
		if($("#content").val().length >0 ){
			location.href = "./reply.do?seq="+val+"+&content="+content+"&id=USER02&title="+title;
		}else{
			alert("내용을 입력해 주세요");
		}
	}
</script>
</html>