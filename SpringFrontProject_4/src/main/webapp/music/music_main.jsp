<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
	.container {
		margin-top: 50px;
	}
	.row {
		margin: 0px auto;
		width: 960px;
	}
	input[type="text"] {
		width: 200px;
	}
</style>
</head>
<body>
<div class="container">
	<h2 class="text-center">{{music_title}}</h2>
	
	<div class="row" style="margin-top: 10px;margin-bottom: 20px;">
		<div class="text-center">
			<b-button variant="outline-default" @click="musicGetData(1)">Top100</b-button>
			<b-button variant="outline-default" @click="musicGetData(2)">가요</b-button>
			<b-button variant="outline-default" @click="musicGetData(3)">POP</b-button>
			<b-button variant="outline-default" @click="musicGetData(4)">OST</b-button>
			<b-button variant="outline-default" @click="musicGetData(5)">트롯</b-button>
			<b-button variant="outline-default" @click="musicGetData(6)">JAZZ</b-button>
			<b-button variant="outline-default" @click="musicGetData(7)">CLASSIC</b-button>
		</div>
	</div>
	
	<div class="row" style="margin-bottom: 10px;align-items: center">
		<input type="text" ref="fd" class="input-sm" placeholder="곡명을 입력하세요" id="keyword" v-on:keyup="selectMusic()">
	</div>
	
	<div class="row">
		<table class="table" id="user-table">
			<thead>
				<tr class="danger">
					<th width="5%" class="text-center">순위</th>
					<th class="text-center"></th>
					<th class="text-center">곡명</th>
					<th class="text-center">가수</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="vo in music_list">
					<td class="text-center">{{vo.mno}}</td>
					<td class="text-center">
						<img :src="vo.poster" style="width: 50px; height: 50px;">
					</td>
					<td>{{vo.title}}</td>
					<td class="text-center">{{vo.singer}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<script>
	new Vue({
		el:'.container',
		data:{
			cno:1,
			music_list:[],
			music_detail:{},
			music_title:''
		},
		mounted:function(){
			this.musicGetData(this.cno);
			
			// Jquery나 다른 라이브러리 연동
			// $(function()) → mounted에
			$('#keyword').keyup(function(){
				let fd = $(this).val();
				$('#user-table > tbody > tr').hide();
				let temp = $('#user-table > tbody > tr > td:nth-child(4n+3):contains("'+fd+'")');
															//       ------ 컬럼위치 => 곡명
				$(temp).parent().show();
			})
		},
		methods:{
			musicGetData:function(cno){
				axios.get("http://localhost/web/music/list_vue.do",{
					params:{
						cno:cno
					}
				}).then(response=>{
					console.log(response.data)
					this.music_list=response.data
					this.music_title=response.data[0].music_title
				})
			}
		}
	})
</script>
</body>
</html>