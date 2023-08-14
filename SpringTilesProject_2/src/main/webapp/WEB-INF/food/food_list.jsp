<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.row {
		margin: 0px auto;
  		width:100%;
	}
</style>
</head>
<body>
<div class="wrapper row3">
	<main class="container clear">
		<div class="jumbotron">
			<h3 class="text-center">${cvo.title }</h3>
			<h4 class="text-center">${cvo.subject }</h4>
		</div>
		
		<table class="table">
			<tr>
				<td>
				<c:forEach var="vo" items="${list }">
					<table class="table">
						<tr>
							<td width=30% class="text-center" rowspan=3>
								<img src="${vo.poster }" style="width: 80%" class="img-round">
							</td>
							<td width=70%>
								<h4>${vo.name }&nbsp;&nbsp;<span style="color:orange">${vo.score }</span></h4>
							</td>
						</tr>
						<tr>
							<td width=70%>${vo.address }</td>
						</tr>
						<tr>
							<td width=70% height=120px></td>
						</tr>
					</table>
				</c:forEach>
				</td>
			</tr>
		</table>
	</main>
</div>
</body>
</html>