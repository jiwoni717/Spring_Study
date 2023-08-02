<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.row1 {
		width : 350px;
	}
</style>
</head>
<body>
	<div class="row row1">
		<h3 class="text-center">게시글 삭제</h3>
		
		<form method="post" action="../databoard/delete_ok.do">
		<table class="table">
			<tr>
				<td class="text-center">
					<input type=password name=pwd size=30 placeholder="비밀번호를 입력하세요.">
					<input type=hidden name=no value="${no }">
				</td>
			</tr>
			<tr>
				<td class="text-center">
					<button class="btn btn-sm btn-success">삭제</button>
					<input type="button" class="btn btn-sm btn-default" value="취소" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>