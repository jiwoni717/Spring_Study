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
		<input type=text ref="fd" size="30" class="input-sm" v-model="fd">
		<input type=button class="btn btn-sm btn-default" value="검색" v-on:click="findData()">
	</div>
	<div style="height:20px"></div>
	<div class="row">
		 <div class="col-md-3" v-for="vo in food_list">
			  <div class="thumbnail">
				   <a href="#">
				     <img :src="vo.poster" alt="Lights" style="width:100%">
				     <div class="caption">
				       <p style="font-size:9px">{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></p>
				     </div>
				   </a>
			</div>
		 </div>
	</div>
	<div style="height:10px"></div>
	<div class="row">
	<%-- class="active" --%>
		<div class="text-center">
			<ul class="pagination">
			  <li v-if="startPage>1"><a href="#" v-on:click="prev()">&lt;</a></li>
			  <li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''"><a href="#" v-on:click="selectPage(i)">{{i}}</a></li>
			  <li v-if="endPage<totalpage"><a href="#" v-on:click="next()">&gt;</a></li>
			</ul>
		</div>
	</div>
</div>

<script>
	new Vue({
		el:'.container-fluid',
		data: {
			// 초기 값 설정
			// 멤버변수 => 프로그램 종료시까지 유지
			fd:'마포',
			food_list:[],
			curpage:1,
			totalpage:0,
			startPage:0,
			endPage:0,
			
		}, 
		mounted:function(){
			this.send();
		},
		// 멤버 함수 => 사용자 정의
		methods:{
			send:function(){
				// 콜백함수 : 시스템에 의해서 자동으로 호출되는 함수
				// 필요 데이터 전송 axios
				axios.get("http://localhost/web/food/find_vue.do", { // 요청을 함
					params:{
						page:this.curpage,
						fd:this.fd
					}
				}).then(response=>{		// 응답을 받음
					console.log(response.data)	// response => 전체 데이터 출력 , reponse.data => 데이터만 출력
					this.food_list=response.data
					this.curpage=response.data[0].curpage;
					this.totalpage=response.data[0].totalpage;	
					this.startPage=response.data[0].startPage;			
					this.endPage=response.data[0].endPage;	
				})
			},
			findData:function(){
				this.curpage=1;
				this.send();
			},
			range:function(start,end) {
				let arr=[];
				let length=end-start;
				for(let i=0;i<length;i++) {
					arr[i]=start;
					start++;
				}
				return arr;
			},
			selectPage:function(page){
				this.curpage=page;
				this.send();
			},
			prev:function(){
				this.curpage=this.startPage-1;
				this.send()
			},
			next:function(){
				this.curpage=this.endPage+1;
				this.send();
			}
		}
	})
</script>

</body>
</html>