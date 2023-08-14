<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
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
</head>
<body>
<div class="container">
	<h2 class="text-center">디렉티브(v-show = "true/false")</h2>
	<div class="row">
		<button class="btn btn-lg btn-default" @click="showClick()">보여준다</button>
		<button class="btn btn-lg btn-default" @click="hideClick()">감춘다</button>
		<div v-show="isShow">
			Hello Vue!!
		</div>
	</div>
</div>
<script>
	const myApp = {
			data(){
				return {
					isShow:false
				}
			},
			methods:{
				showClick:function(){
					this.isShow=true
				},
				hideClick:function(){
					this.isShow=false
				}
			}
	}
	Vue.createApp(myApp).mount('.container')
</script>
</body>
</html>