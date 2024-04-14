<template>

	<div>
		<el-dialog title="提示" :visible.sync="dialogFlag" width="30%" >
		  <div style="text-align: center;">
			<el-input v-model="newSortName" placeholder="请输入新名称" style="display:inline-block;width: 200px; margin-right: 10px;">
			</el-input>
		    <el-button @click='changeSortName' type="primary">修改名称</el-button>
		  </div>
		</el-dialog>
		<div style="margin-top: 20px;margin-left: 20px;">

<!-- 			<span style="margin-left: 40px;">分类名称：</span>
			<el-input v-model="uname" placeholder="请输入内容" style="display:inline-block;width: 200px;">
			</el-input>
			<el-button type="primary" @click="getSortList()" icon="el-icon-search" 
				style="display:inline-block;margin-left: 10px;">查询</el-button>
				 -->
				<span style="margin-left: 40px;">分类名称：</span>
				<el-input v-model="sortName" placeholder="请输入内容" style="display:inline-block;width: 200px;">
				</el-input>
				<el-button type="primary" @click="addSort()" 
					style="display:inline-block;margin-left: 10px;">添加</el-button>
		</div>
		<el-table v-loading="tableLoading" :data="sortList" element-loading-text="数据加载中" border fit
			highlight-current-row row-class-name="myClassList"  style="margin-top: 20px;">
			<el-table-column label="分类名称" align="center"  sortable>
				<template slot-scope="scope">{{ scope.row.sortName }}</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="300" align="center">
				<template slot-scope="scope">
					<el-button @click="dialogFlag = true;changeSortId = scope.row.id" type="text">修改名称</el-button>
					<el-button @click="deleteSort(scope.row.id)" type="text">删除</el-button>
				</template>

			</el-table-column>


		</el-table>
		<el-pagination :current-page="page" :page-size="size" :total="total"
			style="padding: 30px 0; text-align: center;" layout="total, prev, pager, next, jumper"
			@current-change="getSortList" />




	</div>
</template>

<script>
	import bookAxios from "@/api/book";
	import axios from 'axios';


	export default {
		name: "upload",
		data() {
			return {
				list: null, // 数据列表
				page: 1,
				size: 10,
				total: 0,
				tableLoading: true,

				//自定义参数
				sortList:undefined,
				sortName:undefined,
				dialogFlag:false,
				newSortName:undefined,
				changeSortId:undefined
			};
		},
		created() {
			this.getSortList()
		},

		methods: {

			getSortList(page = 1) {
				this.page = page
				bookAxios.getSortListAxios(this.page, this.size).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.sortList = resp.data.list
						this.total = resp.data.total
						this.tableLoading = false
					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
			},
			addSort(){
				bookAxios.addSortAxios(this.sortName).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
				
					} else {
						this.$message.error(resp.message);
					}
					this.getSortList(this.page);
				})
			},
			changeSortName(){
				bookAxios.changeSortAxios(this.changeSortId, this.newSortName).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)

					} else {
						this.$message.error(resp.message);
					}
					this.getSortList(this.page);
				})
			},
			deleteSort(uid){
				bookAxios.delSortAxios(uid).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.getSortList(this.page)
					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
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
				return y + "-" + MM + "-" + d + " " + h + ":" + m;
			},
		}
	}
</script>
<style>


</style>
