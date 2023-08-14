<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container-fluid{
	   margin-top: 50px;
	}
	.row{
	  margin: 0px auto;
	  width: 100%;
	}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3" v-for="vo in recipe_list">
			<div class="thumbnail">
				<a href="#">
					<img :src="vo.poster" style="width:60%">
					<div class="caption">
						<p>{{vo.title}}</p>
					</div>
				</a>
			</div>
		</div>
	</div>
	
	<div style="height: 20px"></div>
	
 	<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<li v-if="startPage>1"><a href="#" @click="prev()">&lt;</a></li>
				<li v-for="i in range(startPage, endPage)" :class="i==curpage?'active':''"><a href="#">{{i}}</a></li>
				<li v-if="endPage<totalpage"><a href="#" @click="next()">&gt;</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
	new Vue({
		el:'.container-fluid',
		data:{
			recipe_list:[],
			curpage:1,
			totalpage:0,
			startPage:0,
			endPage:0
		},
		mounted:function()
		{
			this.send()
		},
		methods:{
			
			send:function(){
				let _this = this;
				axios.get("http://localhost/web/recipe/list_vue.do",{
					params : {
						page:this.curpage
					}
				}).then(function(response){
					console.log(response.data)
					_this.recipe_list = response.data;
					_this.curpage = response.data[0].curpage;
					_this.totalpage = response.data[0].totalpage;
					_this.startPage = response.data[0].startPage;
					_this.endPage = response.data[0].endPage;
				})
			},
			range:function(start,end){
				let arr = [];
				let length = end-start;
				
				for(let i=0;i<=length;i++)
				{
					arr[i] = start;
					start++;
				}
				return arr;
			},
			prev:function(){
				this.curpage = this.startPage-1;
				this.send();
			},
			next:function(){
				this.curpage = this.endPage+1;
				this.send();
			}
		}
	})
</script>
</body>
</html>