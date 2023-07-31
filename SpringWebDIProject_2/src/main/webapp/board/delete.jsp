<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="text-center">삭제하기</h2>
		<div class="row">
		<form method=post action="delete_ok.do">
			<table class="table">
				<tr>
					<td class="text-center">
						비밀번호 : <input type=password name=pwd size=15 class="input-sm">
						<input type=hidden name=no value="${no }">
						<button class="btn btn-sm btn-default">삭제</button>
						<input type=button value="취소" class="btn btn-sm btn-primary" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>