<template>

	<div>
		<el-dialog :visible.sync="updateDialogFlag" title="档案信息修改">
			<el-row :gutter="15">
				<el-form ref="elForm" :model="updateFormData" :rules="rules" size="medium" label-width="100px">
					<el-col :span="24">
						<el-form-item label="档案名称" prop="addSortName">
							<el-input v-model="updateFormData.addSortName" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="所属分类" prop="addBookSortId">
							<el-select v-model="updateFormData.addBookSortId" placeholder="" clearable
								:style="{width: '100%'}">
								<el-option v-for="(item, index) in addBookSortIdOptions" :key="index"
									:label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="馆藏区域" prop="addBookAddress">
							<el-select v-model="updateFormData.addBookAddress" placeholder="" clearable
								:style="{width: '100%'}">
								<el-option v-for="(item, index) in addBookAddressOptions" :key="index"
									:label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<!-- 开始 -->
					<el-col :span="24">
						<el-form-item label="所属人" prop="addBookAddress">
							<el-input v-model="updateFormData.author" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
<!-- 					<el-col :span="24">
						<el-form-item label="出版社" prop="addBookAddress">
							<el-input v-model="updateFormData.press" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col> -->
					<el-col :span="24">
						<el-form-item label="档案时间" prop="addBookAddress">
							<el-date-picker v-model="updateFormData.publicationDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
								:style="{width: '100%'}" placeholder="" clearable></el-date-picker>
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="档案封面" prop="addreddRfid">
							<el-upload class="avatar-uploader" action="/user/uploadFile"
								:show-file-list="false" :on-success="handleAvatarSuccess"
								:before-upload="beforeAvatarUpload">
								<img v-if="imageUrl" :src="imageUrl" class="avatar">
								<i v-else class="el-icon-plus avatar-uploader-icon"></i>
							</el-upload>
						</el-form-item>
						
					</el-col>
					<el-col :span="24">
						<el-form-item label="档案数量" prop="addBookAddress">
							<el-input v-model="updateFormData.bookCount" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="RFID信息" prop="addreddRfid">
							<el-input v-model="updateFormData.addreddRfid" placeholder="" clearable :style="{width: '80%'}">
							</el-input>
							<el-button type="primary" @click="getRFid">获取卡号</el-button>
						</el-form-item>
					</el-col>
				</el-form>
			</el-row>
			<div slot="footer">
				<el-button @click="updateDialogFlag = false">取消</el-button>
				<el-button type="primary" @click="updateBookInfoById">确定</el-button>
			</div>
		</el-dialog>

		<el-dialog :visible.sync="addDialogFlag" title="添加档案">
			<el-row :gutter="15">
				<el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
					<el-col :span="24">
						<el-form-item label="档案名称" prop="addSortName">
							<el-input v-model="formData.addSortName" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="所属分类" prop="addBookSortId">
							<el-select v-model="formData.addBookSortId" placeholder="" clearable
								:style="{width: '100%'}">
								<el-option v-for="(item, index) in addBookSortIdOptions" :key="index"
									:label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="馆藏区域" prop="addBookAddress">
							<el-select v-model="formData.addBookAddress" placeholder="" clearable
								:style="{width: '100%'}">
								<el-option v-for="(item, index) in addBookAddressOptions" :key="index"
									:label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<!-- 开始 -->
					<el-col :span="24">
						<el-form-item label="所属人" prop="addBookAddress">
							<el-input v-model="formData.author" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="ISBN" prop="addBookAddress">
							<el-input v-model="formData.isbn" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
<!-- 					<el-col :span="24">
						<el-form-item label="出版社" prop="addBookAddress">
							<el-input v-model="formData.press" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col> -->
					<el-col :span="24">
						<el-form-item label="档案时间" prop="addBookAddress">
							<el-date-picker v-model="formData.publicationDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
								:style="{width: '100%'}" placeholder="" clearable></el-date-picker>
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="档案封面" prop="addreddRfid">
							<el-upload class="avatar-uploader" action="/user/uploadFile"
								:show-file-list="false" :on-success="handleAvatarSuccess"
								:before-upload="beforeAvatarUpload">
								<img v-if="imageUrl" :src="imageUrl" class="avatar">
								<i v-else class="el-icon-plus avatar-uploader-icon"></i>
							</el-upload>
						</el-form-item>
						
					</el-col>
					<el-col :span="24">
						<el-form-item label="档案数量" prop="addBookAddress">
							<el-input v-model="formData.bookCount" placeholder="" show-word-limit clearable
								prefix-icon='el-icon-mobile' :style="{width: '100%'}">
							</el-input>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="RFID信息" prop="addreddRfid">
							<el-input v-model="formData.addreddRfid" placeholder="" clearable :style="{width: '80%'}">
							</el-input>
							<el-button type="primary" @click="getRFid">获取卡号</el-button>
						</el-form-item>
					</el-col>
				</el-form>
			</el-row>
			<div slot="footer">
				<el-button @click="addDialogFlag = false">取消</el-button>
				<el-button type="primary" @click="addBookInfo">确定</el-button>
			</div>
		</el-dialog>
		<div style="margin-top: 20px;margin-left: 20px;">

			<!-- 			<span style="margin-left: 40px;">分类名称：</span>
			<el-input v-model="uname" placeholder="请输入内容" style="display:inline-block;width: 200px;">
			</el-input>
			<el-button type="primary" @click="getbookList()" icon="el-icon-search" 
				style="display:inline-block;margin-left: 10px;">查询</el-button>
				 -->
			<el-button type="primary" @click="addDialogFlag = true" style="display:inline-block;margin-left: 10px;margin-right: 30px;">添加档案
			</el-button>
			<span style="font-size: 10px;margin-left: 30px;">档案名：</span>
			<el-input v-model="searchData.bookName" placeholder="" clearable style="width:120px;margin-right: 5px;">
			</el-input>
			<span style="font-size: 10px;margin-left: 10px;">所属人：</span>
			<el-input v-model="searchData.author" placeholder="" clearable style="width:120px;margin-right: 5px;">
			</el-input>
<!-- 			<span style="font-size: 10px;margin-left: 10px;">出版社：</span>
			<el-input v-model="searchData.press" placeholder="" clearable style="width:120px;margin-right: 5px;">
			</el-input> -->
			<el-button type="primary" @click="searchDataList(1)">搜索</el-button>
		</div>
		<el-table v-loading="tableLoading" :data="bookList" element-loading-text="数据加载中" border fit
			highlight-current-row row-class-name="myClassList" style="margin-top: 20px;">
			<el-table-column label="档案名称" width="200" align="center" >
				<template slot-scope="scope">{{ scope.row.bookName }}</template>
			</el-table-column>
			<el-table-column label="所属分类" align="center" >
				<template slot-scope="scope">{{ scope.row.sortName }}</template>
			</el-table-column>
			<el-table-column label="馆藏区域" align="center" >
				<template slot-scope="scope">{{ scope.row.addressName }}</template>
			</el-table-column>

			<el-table-column label="所属人" align="center" >
				<template slot-scope="scope">{{ scope.row.author }}</template>
			</el-table-column>
	<!-- 		<el-table-column label="出版社" align="center" >
				<template slot-scope="scope">{{ scope.row.press }}</template>
			</el-table-column> -->
			<el-table-column label="档案时间" align="center" >
				<template slot-scope="scope">{{ formatTimer(scope.row.publicationDate) }}</template>
			</el-table-column>
			<el-table-column label="上架时间" align="center" >
				<template slot-scope="scope">{{ formatTimer(scope.row.createTime) }}</template>
			</el-table-column>
			<el-table-column label="剩余数量" align="center" >
				<template slot-scope="scope">{{ scope.row.bookCount }}</template>
			</el-table-column>
			<el-table-column label="状态" align="center" >
				<template slot-scope="scope">
				<el-button type="primary" size="mini" v-if="scope.row.bookStatus == '可借'">{{ scope.row.bookStatus }}</el-button>
				<el-button type="danger" size="mini" v-if="scope.row.bookStatus == '不可借'">{{ scope.row.bookStatus }}</el-button></template>
			</el-table-column>
			<el-table-column label="借阅次数" align="center" >
				<template slot-scope="scope">{{ scope.row.selectNumber }}</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="100" align="center">
				<template slot-scope="scope">
					<el-button @click="changeAddrssId = scope.row.id;gatBookInfoByID(scope.row.id)" type="text">修改
					</el-button>
					<el-button @click="deleteSort(scope.row.id)" type="text">删除</el-button>
				</template>
			</el-table-column>


		</el-table>
		<el-pagination :current-page="page" :page-size="size" :total="total"
			style="padding: 30px 0; text-align: center;" layout="total, prev, pager, next, jumper"
			@current-change="getbookList" />




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
				imageUrl: '',
				bookList: undefined,
				addressName: undefined,
				dialogFlag: false,
				newaddressName: undefined,
				changeAddrssId: undefined,
				addDialogFlag: false,
				updateDialogFlag: false,
				formData: {
					addSortName: undefined,
					addBookSortId: undefined,
					addBookAddress: undefined,
					addreddRfid: undefined,
					addBook: undefined,
					updateBookAddress: undefined,
					publicationDate: undefined,
					author: undefined,
					press: undefined,
					bookCount: undefined,
					isbn:undefined,
				},
				updateFormData: {
					addSortName: undefined,
					addBookSortId: undefined,
					addBookAddress: undefined,
					addreddRfid: undefined,
					addBook: undefined,
					updateBookAddress: undefined,
					publicationDate: undefined,
					author: undefined,
					press: undefined,
					bookCount: undefined,
				},
				searchData:{
					bookName:undefined,
					author:undefined,
					press:undefined
				},
				addBookSortIdOptions: [{
					"label": "选项一",
					"value": 1
				}, {
					"label": "选项二",
					"value": 2
				}],
				addBookAddressOptions: [{
					"label": "选项一",
					"value": 1
				}, {
					"label": "选项二",
					"value": 2
				}],
				updateBookSortIdOptions: [{
					"label": "选项一",
					"value": 1
				}, {
					"label": "选项二",
					"value": 2
				}],
			};
		},
		created() {
			this.selectOption()
			this.selectAddressOption()
			this.getbookList()
		},

		methods: {
			updateBookInfoById() {
				// publicationDate: undefined,
				// author: undefined,
				// press: undefined,
				// photoUrl: undefined,
				bookAxios.updateBookInfoByIdAxios(this.changeAddrssId,
				this.updateFormData.addSortName,
					this.updateFormData.addBookSortId,
					this.updateFormData.addreddRfid, 
					this.updateFormData.addBookAddress,
					this.updateFormData.author,
					this.updateFormData.press,
					this.updateFormData.publicationDate,
					this.imageUrl,
					this.updateFormData.bookCount).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.updateFormData.addSortName = undefined;
						this.updateFormData.addBookSortId= undefined;
						this.updateFormData.addreddRfid= undefined;
						this.updateFormData.addBookAddress= undefined;
						this.updateFormData.author= undefined;
						this.updateFormData.press= undefined;
						this.updateFormData.publicationDate= undefined;
						this.imageUrl= undefined;
						this.updateFormData.bookCount= undefined;
						this.updateDialogFlag = false
						// this.addBookSortIdOptions = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})
			},
			
			gatBookInfoByID(id){
				bookAxios.getBookInfoByIdAxios(id).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						// this.formData.addreddRfid = resp.data.data
						this.updateFormData.addSortName= resp.data.data.data
						this.updateFormData.addBookSortId= resp.data.data.sortId +""
						this.updateFormData.addBookAddress= resp.data.data.addressId+""
						this.updateFormData.addreddRfid= resp.data.data.rfidId
						this.updateFormData.addSortName= resp.data.data.bookName
						this.updateFormData.updateBookAddress= resp.data.data.data
						this.updateFormData.publicationDate= resp.data.data.publicationDate
						this.updateFormData.author= resp.data.data.author
						this.updateFormData.press= resp.data.data.press
						this.updateFormData.bookCount= resp.data.data.bookCount
						this.imageUrl = resp.data.data.photoUrl
						this.updateDialogFlag = true;
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})

			},
			handleAvatarSuccess(res, file) {
				console.log(res);
				this.imageUrl = res
			},
			getRFid() {
				bookAxios.getRfif().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.formData.addreddRfid = resp.data.data
						this.updateFormData.addreddRfid = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})
			},

			addBookInfo() {
				// publicationDate: undefined,
				// author: undefined,
				// press: undefined,
				// photoUrl: undefined,
				bookAxios.addBookInfoAxios(this.formData.addSortName,
					this.formData.addBookSortId,
					this.formData.addreddRfid, 
					this.formData.addBookAddress,
					this.formData.author,
					this.formData.press,
					this.formData.publicationDate,
					this.imageUrl,
					this.formData.bookCount,
					this.formData.isbn).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.formData.addSortName = undefined;
						this.formData.addBookSortId= undefined;
						this.formData.addreddRfid= undefined;
						this.formData.addBookAddress= undefined;
						this.formData.author= undefined;
						this.formData.press= undefined;
						this.formData.publicationDate= undefined;
						this.imageUrl= undefined;
						this.formData.bookCount= undefined;
						this.formData.isbn = undefined;
						this.addDialogFlag = false
						// this.addBookSortIdOptions = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})
			},

			selectOption() {
				bookAxios.getSortOptionAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.addBookSortIdOptions = resp.data.data

					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
			},

			selectAddressOption() {
				bookAxios.getaddressOptionAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.addBookAddressOptions = resp.data.data
						this.updateBookSortIdOptions = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
			},
			searchDataList(page = 1){
				
				this.page = page
				console.log(this.page)
				bookAxios.selectBookInfoConditionByPageAxios(this.searchData.bookName,
				this.searchData.author,
				this.searchData.press,this.page, this.size).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.bookList = resp.data.list
						this.total = resp.data.total
						this.tableLoading = false
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
						this.total = resp.data.total
						this.tableLoading = false
					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
			},

			updateBookInfo() {
				bookAxios.updateBookAddresssInfoByIdAxios(this.changeAddrssId, this.formData.updateBookAddress).then(
					resp => {
						console.log(resp)
						// this.state = 4
						if (resp.code === 20000) {
							this.$message.success(resp.message)

						} else {
							this.$message.error(resp.message);
						}
						this.getbookList(this.page);
					})
			},
			deleteSort(id) {
				bookAxios.delBookInfo(id).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.getbookList(this.page)
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
				// return y + "-" + MM + "-" + d + " " + h + ":" + m;
				return y + "-" + MM + "-" + d ;
			},
		}
	}
</script>
<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
