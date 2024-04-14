<template>
	<div>


		<div style="margin-left: 10%;width: 80%;margin-top: 30px;">
			<el-steps :active="active" finish-status="success" align-center>
				<el-step title="检查用户信息"></el-step>
				<el-step title="刷卡获取档案信息"></el-step>
				<el-step title="借书/还书"></el-step>

			</el-steps>
			<el-button type="info" style="height: 10%;" @click="next">下一步</el-button>
		</div>
		<div v-if="active == 0" style="margin-left: 20%;width: 60%;margin-top: 30px;">
			<el-input :disabled="true" v-model="user.uname" placeholder="请输入学号" style="margin-bottom: 20px; ">
			</el-input>
			<el-input :disabled="true" v-model="user.email" placeholder="请输入姓名" style="margin-bottom: 20px;"></el-input>
			<!-- <el-input v-model="user.pwd" placeholder="请输入密码" style="margin-bottom: 20px;" show-password>></el-input> -->

			<el-input :disabled="true" v-model="user.age" placeholder="请输入年龄" style="margin-bottom: 20px;"></el-input>
			<!-- <el-input v-model="user.sex" placeholder="请输入确认性别" style="margin-bottom: 20px;" show-password></el-input>
			 -->
			<el-select :disabled="true" v-model="user.sex" placeholder="请选择性别" style="margin-bottom: 20px;width: 100%;">
				<el-option v-for="(item, index) in sexOptions" :key="index" :label="item.label" :value="item.value"
					:disabled="item.disabled"></el-option>
			</el-select>
			<el-input :disabled="true" v-model="user.major" placeholder="请输入专业" style="margin-bottom: 20px;"></el-input>
			<el-input :disabled="true" v-model="user.grade" placeholder="请输入年级" style="margin-bottom: 20px;"></el-input>

		</div>
		<div v-if="active == 1" style="margin-left: 20%;width: 60%;margin-top: 30px;">
			<el-form ref="elForm" :model="updateFormData" :rules="rules" size="medium" label-width="100px">
				<el-col :span="24">
					<el-form-item label="RFID信息" prop="addreddRfid">
						<el-input v-model="updateFormData.addreddRfid" placeholder="" clearable :style="{width: '50%'}">
						</el-input>
						<el-button style="margin-left: 10px;" type="primary" @click="getRFid">获取卡号</el-button>
						<el-button type="primary" @click="gatBookInfoByRFID">获取档案信息</el-button>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item label="档案名称" prop="addSortName">
						<el-input :disabled="true" v-model="updateFormData.addSortName" placeholder="" show-word-limit
							clearable prefix-icon='el-icon-mobile' :style="{width: '100%'}">
						</el-input>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item label="所属分类" prop="addBookSortId">
						<el-select :disabled="true" v-model="updateFormData.addBookSortId" placeholder="" clearable
							:style="{width: '100%'}">
							<el-option v-for="(item, index) in addBookSortIdOptions" :key="index" :label="item.label"
								:value="item.value" :disabled="item.disabled"></el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item label="馆藏区域" prop="addBookAddress">
						<el-select :disabled="true" v-model="updateFormData.addBookAddress" placeholder="" clearable
							:style="{width: '100%'}">
							<el-option v-for="(item, index) in addBookAddressOptions" :key="index" :label="item.label"
								:value="item.value" :disabled="item.disabled"></el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<!-- 开始 -->
				<el-col :span="24">
					<el-form-item label="所属人" prop="addBookAddress">
						<el-input :disabled="true" v-model="updateFormData.author" placeholder="" show-word-limit
							clearable prefix-icon='el-icon-mobile' :style="{width: '100%'}">
						</el-input>
					</el-form-item>
				</el-col>
<!-- 				<el-col :span="24">
					<el-form-item label="出版社" prop="addBookAddress">
						<el-input :disabled="true" v-model="updateFormData.press" placeholder="" show-word-limit
							clearable prefix-icon='el-icon-mobile' :style="{width: '100%'}">
						</el-input>
					</el-form-item>
				</el-col> -->
				<el-col :span="24">
					<el-form-item label="档案时间" prop="addBookAddress">
						<el-date-picker :disabled="true" v-model="updateFormData.publicationDate" format="yyyy-MM-dd"
							value-format="yyyy-MM-dd" :style="{width: '100%'}" placeholder="" clearable>
						</el-date-picker>
					</el-form-item>
				</el-col>

				<el-col :span="24">
					<el-form-item label="档案封面" prop="addreddRfid">
						<el-upload :disabled="true" class="avatar-uploader" action="/user/uploadFile"
							:show-file-list="false" :on-success="handleAvatarSuccess"
							:before-upload="beforeAvatarUpload">
							<img v-if="imageUrl" :src="imageUrl" class="avatar">
							<i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
					</el-form-item>

				</el-col>
				<el-col :span="24">
					<el-form-item label="档案数量" prop="addBookAddress">
						<el-input :disabled="true" v-model="updateFormData.bookCount" placeholder="" show-word-limit
							clearable prefix-icon='el-icon-mobile' :style="{width: '100%'}">
						</el-input>
					</el-form-item>
				</el-col>

			</el-form>
		</div>
		<div v-if="active == 2" style="margin-left: 20%;width: 60%;margin-top: 30px;">
			<div style="margin-top: 10%;">
				<!-- <el-card class="box-card" style="width: 55%;">
					<el-button style="margin-left: 10px;" type="primary" @click="getRFid">确认借书</el-button>
					<el-button style="margin-left: 10px;" type="danger" @click="getRFid">确认还书</el-button>
				</el-card>
 -->

				<el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
					<el-col :span="24">
						<hr />
						<el-form-item label="借书操作" prop="bookDate">
							<el-date-picker v-model="formData.bookDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
								:style="{width: '80%'}" placeholder="请选择日期选择" clearable></el-date-picker>
							<el-button style="margin-left: 10px;" type="primary" @click="borrowdBookCurr">确认借书</el-button>
						</el-form-item>
						<hr />
					</el-col>
					<br />
					<!-- <hr /> -->
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<el-col :span="24">
						<hr />
						<el-form-item label="还书操作" prop="bookDate">
							<el-rate v-model="raters"  show-score text-color="#ff9900" score-template="{value}">
							</el-rate>
							<el-button style="margin-left: 10px;" type="danger" @click="returnBook">确认还书</el-button>
						</el-form-item>
						<hr />
					</el-col>
				</el-form>

				<!-- <el-button style="margin-left: 10px;" type="success" @click="getRFid">确认借书</el-button>
				<el-button style="margin-left: 10px;" type="danger" @click="getRFid">确认还书</el-button> -->
			</div>

		</div>
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
				active: 0,
				raters:5,
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
					RFIDID: undefined,
					bookDate: undefined,
				},
				updateFormData: {
					id: undefined,
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
				user: {
					uname: '',
					pwd: '',
					pwdToo: '',
					age: '',
					sex: '',
					major: '',
					grade: '',
					email: '',
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
				sexOptions: [{
					"label": "男",
					"value": "男"
				}, {
					"label": "女",
					"value": "女"
				}],
				imageUrl:undefined,
			};
		},
		created() {
			this.selectOption()
			this.selectAddressOption()
			this.getbookList()
			this.getUpdateUserInfo()
		},

		methods: {
			borrowdBookCurr() {
				bookAxios.borrowBook(this.updateFormData.addreddRfid,
					this.formData.bookDate).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						// this.addBookSortIdOptions = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})
			},
			gatBookInfoByRFID() {
				bookAxios.getBookInfoByRfidAxios(this.updateFormData.addreddRfid).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						// this.formData.addreddRfid = resp.data.data
						this.updateFormData.id = resp.data.data.id
						this.updateFormData.addSortName = resp.data.data.data
						this.updateFormData.addBookSortId = resp.data.data.sortId + ""
						this.updateFormData.addBookAddress = resp.data.data.addressId + ""
						this.updateFormData.addreddRfid = resp.data.data.rfidId
						this.updateFormData.addSortName = resp.data.data.bookName
						this.updateFormData.updateBookAddress = resp.data.data.data
						this.updateFormData.publicationDate = resp.data.data.publicationDate
						this.updateFormData.author = resp.data.data.author
						this.updateFormData.press = resp.data.data.press
						this.updateFormData.bookCount = resp.data.data.bookCount
						this.imageUrl = resp.data.data.photoUrl
						this.updateDialogFlag = true;
					} else {
						this.$message.error(resp.message);
					}
					this.getbookList(this.page);
				})

			},
			getUpdateUserInfo() {
				bookAxios.getUserInfoByTokenAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.user.uname = resp.data.data.uname
						this.user.pwd = resp.data.data.pwd
						this.user.age = resp.data.data.age
						this.user.sex = resp.data.data.sex
						this.user.major = resp.data.data.major
						this.user.grade = resp.data.data.grade
						this.user.email = resp.data.data.email
						this.tableLoading = false
					} else {
						this.$message.error(resp.message);
					}
					// this.getFileList(this.page);
				})
			},
			next() {
				this.active++
				if (this.active > 2) this.active = 0;
				if (this.active == 0) {
					this.getUpdateUserInfo()
				}
			},
			getRFid() {
				bookAxios.getRfif().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
						this.updateFormData.addreddRfid = resp.data.data
					} else {
						this.$message.error(resp.message);
					}
					//this.getbookList(this.page);
				})
			},

			returnBook() {
				bookAxios.returnBook(this.updateFormData.addreddRfid,this.raters).then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.$message.success(resp.message)
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

			getbookList(page = 1) {
				this.page = page
				bookAxios.selectBorrowList(this.page, this.size).then(resp => {
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
				return y + "-" + MM + "-" + d + " " + h + ":" + m;
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
