<template  >
<div>
	
<!-- 	style="width: 100%; height: 100%"
	            :src="item.contentCover"
	            fit="cover" -->
	<div style="background-color: #c9dcc6;">
		<div style="margin-top: 10px;">
			<h3 style="margin-left: 10%;">
				<svg style="width: 30px;height: 30px;margin-top: 10px;" t="1652081580165" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5332" width="200" height="200"><path d="M10.432 1024.064L6.4-0.128h935.872v1023.936l-468.544-245.696-463.296 245.952z m462.912-365.76l362.944 190.208V105.856H112.832l2.88 742.336 357.632-189.888z" fill="#F98064" p-id="5333"></path><path d="M199.104 304.704h46.528l47.296 90.944 18.624 42.176h1.28c-2.56-20.224-6.144-47.552-6.144-70.272v-62.848h43.392v190.08h-46.464l-47.04-91.712-18.624-41.728h-1.28c2.048 21.248 5.888 47.296 5.888 70.336v63.104h-43.456v-190.08zM394.176 304.704h120.64v37.76h-74.88v35.264h63.616v38.336h-63.616v40.384h77.696v38.336H394.176v-190.08zM536.64 304.704h46.72l12.032 86.592 7.68 60.288h1.024c3.648-20.16 7.424-40.64 11.264-60.288l19.392-86.592h38.4l19.968 86.592c3.84 19.392 7.104 39.872 10.944 60.288h1.344c2.304-20.416 4.8-40.64 7.104-60.288l12.288-86.592h43.392l-32.96 190.08h-57.472l-17.28-82.752a524.992 524.992 0 0 1-7.36-44.16h-1.28c-2.304 14.272-4.608 29.568-7.424 44.16L627.84 494.784h-56.448l-34.752-190.08z" fill="#FC632D" p-id="5334"></path></svg>
				档案速递</h3>
			  <el-carousel style="width: 90%;margin-left: 5%;margin-top: 30px;" :interval="4000" type="card" height="200px">
			    <el-carousel-item v-for="item in 6" style="width: 400px;" :key="item">
			         <el-image
			            style="width: 100%; height: 80%;background-color: #c4d4c7;"
			            :src="bookCreatList[item-1].photoUrl"
			            fit="scale-down"  @click="imgClick(bookCreatList[item-1].id)">
						</el-image>
					<div style="text-align: center;">{{bookCreatList[item-1].bookName}}</div>
					<div style="text-align: center;font-size: 10px;">上架时间：{{formatTimer(bookCreatList[item-1].createTime)}}</div>
			    </el-carousel-item>
			  </el-carousel>
		</div>

	</div>
	<div style="background-color: #f7eee7;">
		<div >
			<h3 style="margin-left: 10%;">
			<svg style="width: 30px;height: 30px;margin-top: 10px;" t="1652082033779" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1748" width="200" height="200"><path d="M428.6976 107.3152c-6.5024 72.192-36.352 207.2576-160.256 337.408 3.6864-48.0256-7.1168-83.7632-19.0464-107.6736-6.6048-13.1584-26.0608-10.5984-28.8768 3.84-5.7344 29.44-20.5824 75.0592-57.6 137.7792-71.6288 121.3952-62.5664 459.8784 340.736 459.8784s430.4384-352.8192 373.1456-496.0256c-37.376-93.44-93.952-152.5248-128.8192-182.3232-11.4176-9.7792-29.1328-1.9456-29.5936 13.056-0.9216 30.464-7.3216 73.3696-33.0752 102.144-0.6656-52.7872-38.144-208.384-202.4448-296.8576-23.296-12.544-51.7632 2.4576-54.1696 28.7744z" fill="#FF5D50" p-id="1749"></path><path d="M702.2592 678.4c-4.1984-45.056-60.672-166.5536-212.6336-246.4256-10.5984-5.5808-23.0912 3.1232-21.504 15.0016 6.2464 46.848 12.9536 140.4928-24.064 184.7296 4.0448-40.3968-18.1248-73.8304-36.6592-94.3104-8.3968-9.216-23.552-4.6592-25.4976 7.68-3.5328 22.3232-12.8512 56.2688-36.5568 97.9456-42.0864 74.0352-86.9888 188.672 124.5696 294.656 10.9568 0.5632 22.1696 0.8704 33.7408 0.8704 11.2128 0 22.0672-0.3072 32.7168-0.8704 158.2592-59.4944 173.4656-177.9712 165.888-259.2768z" fill="#FFDF99" p-id="1750"></path></svg>				
			热门档案</h3>
			  <el-carousel style="width: 90%;margin-left: 5%;margin-top: 30px;" :interval="4000" type="card" height="200px">
			    <el-carousel-item v-for="item in 6" style="width: 400px;" :key="item">
			         <el-image
			            style="width: 100%; height: 80%;background-color: #f5fde9;"
			            :src="bookList[item-1].photoUrl"
			            fit="scale-down"  @click="imgClick(bookList[item-1].id)">
						</el-image>
					<div style="text-align: center;">{{bookList[item-1].bookName}}</div>
					<div style="text-align: center;font-size: 10px;">借阅热度：{{bookList[item-1].selectNumber}}</div>
			    </el-carousel-item>
			  </el-carousel>
		</div>

	</div>
</div>
</template>

<script>
  import miuiver from "@/api/miuiver";
	import bookAxios from "@/api/book";
	import axios from 'axios';

  export default {
    data() {
      return {
        text: '', //
        loading:false,
        fits: 'fill',
		bookList:undefined,
		bookCreatList:undefined,
        url: 'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg',
		urlList:[
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/761c186d-6dea-4163-b620-dfeccbcfb695移动通信.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/761c186d-6dea-4163-b620-dfeccbcfb695移动通信.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/761c186d-6dea-4163-b620-dfeccbcfb695移动通信.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/bee91279-667a-41f2-92db-08438193c70e7acb0a46f21fbe090f15247764600c338744ad0e.jpg',
			'https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/761c186d-6dea-4163-b620-dfeccbcfb695移动通信.jpg',
			
		]
		

      };
    },

    created() {
	  this.getbookList()
	  this.getCreatList();
    },

    methods: {
		getCreatList(page = 1) {
			this.page = page
			bookAxios.getBookInfoCreatListAxios(this.page, this.size).then(resp => {
				console.log(resp)
				// this.state = 4
				if (resp.code === 20000) {
					// this.$message.success(resp.message)
					this.bookCreatList = resp.data.list
		
				} else {
					this.$message.error(resp.message);
				}
				// this.getFileList(this.page);
			})
		},
		getbookList(page = 1) {
			this.page = page
			bookAxios.getBookInfoListAxios(this.page, this.size).then(resp => {
				console.log(resp)
				// this.state = 4
				if (resp.code === 20000) {
					// this.$message.success(resp.message)
					this.bookList = resp.data.list

				} else {
					this.$message.error(resp.message);
				}
				// this.getFileList(this.page);
			})
		},
	imgClick(item){
		console.log(item);
		
	// this.$router.push({name:'/book/bookInfo/'+item})
	
		this.$router.push('/book/bookInfo/'+item)
	},
			
      getText(){
				this.text = '档案管理系统'
      },
	  
	  //时间格式化
	  formatTimer: function(value) {
	  	// console.log("时间" + value);
	  
	  	let date = new Date(value);
	  	let y = date.getFullYear();
	  	let MM = date.getMonth() + 1;
	  	MM = MM < 10 ? "0" + MM : MM;
	  	let d = date.getDate();
	  	d = d < 10 ? "0" + d : d;
	  	let h = date.getHours();
	  	h = h < 10 ? "0" + h : h;
	  	let m = date.getMinutes();
	  	m = m < 10 ? "0" + m : m;
	  	let s = date.getSeconds();
	  	s = s < 10 ? "0" + s : s;
	  	// return y + "-" + MM + "-" + d + " " + h + ":" + m;
	  	return y + "-" + MM + "-" + d;
	  },

    }
  };
</script>

<style>
	  .el-carousel__item h3 {
	    color: #475669;
	    font-size: 14px;
	    opacity: 0.75;
	    line-height: 200px;
	    margin: 0;
	  }
	  
	  .el-carousel__item:nth-child(2n) {
	    background-color: #99a9bf;
	  }
	  
	  .el-carousel__item:nth-child(2n+1) {
	    background-color: #d3dce6;
	  }
</style>
