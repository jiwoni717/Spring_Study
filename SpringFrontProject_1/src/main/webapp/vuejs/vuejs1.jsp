<%--
		1. VueJS의 생명주기
		  beforeCreate
		  created
		  ----------------- Vue 객체 생성
		  beforeMount
		  mounted
		  ----------------- 메모리에 저장
		  beforeUpdate
		  updated
		  ----------------- 수정
		  beforeDestroy
		  destroyed
		  ----------------- 메모리 해제
		  가상DOM(Document Object Model) : 메모리를 두개 생성 (가상 메모리를 실제 메모리에 저장)
		  								  트리형태로 저장
		  								  
		2. 디렉티브
		  - 제어문
		  	v-for : 반복문 → 태그안에 존재 ====> <div v-for="">
		  	v-if / v-else
		  	v-show
		  - 이벤트
		  	v-on:click ====> <button v-on:click="aaa()">
		  	v-on:change
		  - 양방향 통신 / 단방향 통신 (Vue / React)
		  	--------> AngularJS에서 파생
		  	v-model
		
		3. 컴포넌트 : 재사용
		  Vue.Component('modal', template:'<html>...'
		
		4. 데이터를 읽어서 출력(클라이언트 ↔ 서버 통신)
		  axios.get('url', {params:{데이터 전송}}).then(){결과값 읽기}
		  → 일반 문자열이나 JSON → @RestController
		  → id나 class를 사용하지 않는다 ref=""
		  
		5. 라우터(화면 변경) → Spring에서 화면 변경 → 검색, 로그인 처리, 댓글...
		
		6. Vue생성
		  <script>
		  	→ 여러개 사용
		  	new Vue({
		  		el : 제어 영역 지정 ====> class=".class" / id="#id"
		  		data : {
		  			=> 멤버변수(Vue에서 제어하는 변수)
		  			a:[] → 스프링에서 전송 => ArrayList(JSONArray)
		  			b:{} → VO(JSONObject)
		  			c:true → boolean
		  			d:'' → String
		  			e:0 → 정수 / 실수
		  		}
		  		생명주기 함수 이용
		  		update : function(){}
		  		mounted : function(){}
		  		
		  		사용자 정의 함수 → 이벤트 중심
		  		methods:{
		  			aaa:funtion(){}
		  		}
		  		filters : 변환(날짜, 숫자)
		  	})
		  </script>
		  
		  데이터 출력
		    {{data에 설정된 변수명}}
		    → 한번에 데이터 출력하려면 {{$data}}
		      <img src="{{}}"> => 오류
		      <img :src="poster">
		      <input type="text" :value="id"> → v-bind:
		      									------->생략 가능
		    
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container {
	margin-top: 50px;
	}
	.row {
	margin: 0px auto;
	width: 960px;
	}
</style>
<!-- 
<script type="text/javascript">
$(function() {
	$('#msg').keyup(function() {
		let m = $('#msg').val()
		$('#print').text(m)
	})
})
</script>-->
</head>
<body>
<div class="container">
	<div class="row">
		입력 : <input type="text" v-model="msg" size=30 class="input-sm">
		<!-- 					--------멤버변수값을 변경 
				양방향 통신 : 입력값을 받아 출력
		-->
		<div id="print">
			{{msg}}
		</div>
	</div>
</div>
<script>
	new Vue({
		el:'.container',
		data:{
			msg:''
		}
	})
</script>
</body>
</html>