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
#title {
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-3" v-for="vo in goods_list">
	      <div class="thumbnail">
	        <a href="#">
	          <img :src="vo.goods_image" alt="Lights" style="width:80%">
	          <div class="caption">
	            <p style="font-size: 12px" id="title">{{vo.goods_name}}</p>
	          </div>
	        </a>
	      </div>
      </div>
	</div>
	
	<div style="height: 10px"></div>
		
	<div class="text-center">
		<input type=button value="이전" class="btn btn-sm btn-default" v-on:click="prev()">
			{{curpage}} page / {{totalpage}} pages
		<input type=button value="다음" class="btn btn-sm btn-default" v-on:click="next()">
	</div>
</div>
<script>
	new Vue({
		el:'.container',
		data:{
			curpage:1,
			totalpage:0,
			goods_list:[],
			goods_detail:{}
		},
		mounted:function()
		{
			this.send();
		},
		methods:{
			send:function(){
				axios.get("http://localhost/web/shop/list_vue.do",{
					params:{
						page:this.curpage
					}
				}).then(response=>{
					console.log(response.data);
					this.goods_list=response.data;
					this.curpage = response.data[0].curpage;
					this.totalpage = response.data[0].totalpage;
				})
			},
			prev:function(){
				this.curpage = this.curpage>1?this.curpage-1:this.curpage;
				this.send();
			},
			next:function()
			{
				this.curpage = this.curpage<this.totalpage?this.curpage+1:this.curpage;
				this.send();
			}
		}
	})
</script>
</body>
</html>