<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
	.container-fluid {
		margin-top: 50px;
	}
	.row {
		margin: 0px auto;
		width: 100%;
	}
	.images:hover {
		cursor: pointer
	}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="text-right">
			${sessionScope.name }님 <a href="../member/logout.do" class="btn btn-sm btn-danger">로그아웃</a>
		</div>	
	</div>
	
	<div class="row">
		<div class="text-center" style="margin-bottom: 20px">
			<button class="btn btn-sm btn-default" @click="categoryGetData(1)">믿고 보는 맛집 리스트</button>
			<button class="btn btn-sm btn-default" @click="categoryGetData(2)">지역별 맛집 리스트</button>
			<button class="btn btn-sm btn-default" @click="categoryGetData(3)">메뉴별 맛집 리스트</button>
		</div>
		
		<div class="row">
			<div class="col-sm-7">
				<div class="col-md-4" v-for="vo in cate_list" style="margin-bottom: 30px">
					<div class="thumbnail">
						<img :src="vo.poster" alt="Lights" style="width:100%" class="images" @click="foodGetList(vo.cno, true)">
						<div class="caption">
							<p>{{vo.title}}</p>
						</div>
					</div>
				 </div>
				 
				 <h4>최근 방문 맛집</h4>
				 <hr>
				 
				 
			 </div>
			 
			 <div class="col-sm-5" v-show="isShow">
			 	<div class="jumbotron">
			 		<h4 class="text-center">{{cate_info.title}}</h4>
			 		<h5 class="text-center">{{cate_info.subject}}</h5>
			 	</div>
		
				<div style="overflow-y: auto; height: 600px;">
				 	<table class="table">
				 		<tr>
				 			<td>
				 				<table class="table" v-for="fvo in food_list">
				 					<tr>
				 						<td width=30% class="text-center" rowspan=4>
				 							<a :href="'../food/food_detail.do?fno='+fvo.fno">
				 								<img :src="fvo.poster" style="width: 100%">
				 							</a>
				 						</td>
				 						<td width=70%><h4><a :href="'../food/food_detail.do?fno='+fvo.fno">{{fvo.name}}</a>&nbsp;<span style="color: orange">★ {{fvo.score}}</span></h4></td>
				 					</tr>
				 					<tr>
				 						<td width=70%>주소 : {{fvo.address}}</td>
				 					</tr>
				 					<tr>
				 						<td width=70%>연락처 : {{fvo.phone}}</td>
				 					</tr>
				 					<tr>
				 						<td width=70%>음식 종류 : {{fvo.type}}</td>
				 					</tr>
				 				</table>
				 			</td>
				 		</tr>
				 	</table>
				 </div>	
			 	
			 </div>
		</div>
	</div>
</div>

<script>
	new Vue({
		el:'.container-fluid',
		data:{
			cate_list:[],
			food_list:[],
			cate_info:{},
			isShow:false
		},
		mounted:function(){
			this.categoryGetData(1);
		},
		methods:{
			categoryGetData:function(cno){
				axios.get('../food/food_category_vue.do', {
					params:{
						cno : cno
					}
				}).then(response=>{
					console.log(response.data)
					this.cate_list = response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			foodGetList:function(cno, bool){
				this.isShow = bool;
				axios.get('../food/food_category_info_vue.do', {
					params : {
						cno:cno
					}
				}).then(response=>{
					console.log(response.data)
					this.cate_info = response.data
					
				}).catch(error=>{
					console.log(error.response)
				})
				
				axios.get('../food/food_list_vue.do', {
					params : {
						cno:cno
					}
				}).then(response=>{
					console.log(response.data)
					this.food_list = response.data
				}).catch(error=>{
						console.log(error.response)
				})
			}
		}
	})
</script>
</body>
</html>