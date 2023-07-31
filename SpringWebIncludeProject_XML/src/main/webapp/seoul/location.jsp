<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
	<c:forEach var="vo" items="${list}" varStatus="s">
		<div class="col-md-4">
			  <div class="thumbnail">

				      <img src="${vo.poster }" alt="Lights" style="width:380px;height:200px">
				      <div class="caption">
				        <p style="font-size:9px">${vo.title }</p>
				      </div>

			  </div>
		 </div>
	</c:forEach>
</div>
<div style="height:20px"></div>
<div class="row">
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${startPage>1 }">
			  <li><a href="../seoul/location.do?page=${startPage-1 }">&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<!-- 현재 페이지면 페이지에 색깔표시 -->
		    	<li ${i==curpage?"class=active":"" }><a href="../seoul/location.do?page=${i }">${i }</a></li>
			</c:forEach>
				<c:if test="${endPage<totalpage }">
			 	  <li><a href="../seoul/location.do?page=${endPage+1 }">&gt;</a></li>
			 	</c:if>
		</ul>
	</div>
</div>
</body>
</html>