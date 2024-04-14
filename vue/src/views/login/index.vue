<template>
	<div class="login-container">

		<el-dialog title="注册" :visible.sync="dialogFormVisible">

			<el-input v-model="user.uname" placeholder="请输入学号" style="margin-bottom: 20px; "></el-input>
			<el-input v-model="user.email" placeholder="请输入姓名" style="margin-bottom: 20px;"></el-input>
			<el-input v-model="user.pwd" placeholder="请输入密码" style="margin-bottom: 20px;" show-password>></el-input>

			<el-input v-model="user.age" placeholder="请输入年龄" style="margin-bottom: 20px;"></el-input>
			<!-- <el-input v-model="user.sex" placeholder="请输入确认性别" style="margin-bottom: 20px;" show-password></el-input>
			 -->
			<el-select v-model="user.sex" placeholder="请选择性别" style="margin-bottom: 20px;width: 100%;">
				<el-option v-for="(item, index) in sexOptions" :key="index" :label="item.label" :value="item.value"
					:disabled="item.disabled"></el-option>
			</el-select>
			<el-input v-model="user.major" placeholder="请输入专业" style="margin-bottom: 20px;"></el-input>
			<el-input v-model="user.grade" placeholder="请输入年级" style="margin-bottom: 20px;"></el-input>
			<el-input v-model="user.phone" placeholder="请输入手机号" style="margin-bottom: 20px;"></el-input>

			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="webRegister">确 定</el-button>
			</div>
		</el-dialog>
		<el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on"
			label-position="left">

			<div class="title-container">
				<h3 class="title">登录</h3>
			</div>

			<el-form-item prop="请输入学号">
				<el-input ref="username" v-model="loginForm.username" placeholder="请输入用户名" name="username" type="text"
					tabindex="1" auto-complete="on" />
			</el-form-item>
			<el-form-item prop="请输入密码">
				<el-input :key="passwordType" ref="password" v-model="loginForm.password" :type="passwordType"
					placeholder="请输入密码" name="password" tabindex="2" auto-complete="on"
					@keyup.enter.native="handleLogin" />
				<span class="show-pwd" @click="showPwd">
					<svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
				</span>
			</el-form-item>
			<br />
			<el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;"
				@click.native.prevent="handleLogin">登录</el-button>
			<br />
			<el-button style="width:100%;margin-bottom:30px;" @click="dialogFormVisible = true">注册</el-button>
			<div class="tips">
				<span style="margin-right:20px;"></span>
				<span> </span>
			</div>

		</el-form>
	</div>
</template>

<script>
	import {
		validUsername
	} from '@/utils/validate'

	import file_sharing from "@/api/file_sharing";

	export default {
		name: 'Login',
		data() {
			const validateUsername = (rule, value, callback) => {
				if (!validUsername(value)) {
					callback(new Error('Please enter the correct user name'))
				} else {
					callback()
				}
			}
			const validatePassword = (rule, value, callback) => {
				if (value.length < 6) {
					callback(new Error('The password can not be less than 6 digits'))
				} else {
					callback()
				}
			}
			return {
				loginForm: {
					username: '',
					password: ''
				},
				dialogFormVisible: false,
				user: {
					uname: '',
					pwd: '',
					pwdToo: '',
					age: '',
					sex: '',
					major: '',
					grade: '',
					email: '',
					phone:'',
				},
				loginRules: {
					// username: [{ required: true, trigger: 'blur', validator: validateUsername }],
					// password: [{ required: true, trigger: 'blur', validator: validatePassword }]
				},
				loading: false,
				passwordType: 'password',
				redirect: undefined,
				sexOptions: [{
					"label": "男",
					"value": "男"
				}, {
					"label": "女",
					"value": "女"
				}],
			}
		},
		watch: {
			$route: {
				handler: function(route) {
					this.redirect = route.query && route.query.redirect
				},
				immediate: true
			}
		},
		methods: {
			showPwd() {
				if (this.passwordType === 'password') {
					this.passwordType = ''
				} else {
					this.passwordType = 'password'
				}
				this.$nextTick(() => {
					this.$refs.password.focus()
				})
			},
			handleLogin() {
				this.$refs.loginForm.validate(valid => {
					if (valid) {
						this.loading = true
						this.$store.dispatch('user/login', this.loginForm).then(() => {
							this.$router.push({
								path: '/'
							})
							this.loading = false
						}).catch(() => {
							this.loading = false
						})
					} else {
						console.log('error submit!!')
						return false
					}
				})
			},
			webRegister() {
				// if (this.user.pwd != this.user.pwdToo) {
				// 	this.$message.error("密码与确认密码不一致");
				// 	return
				// }
				// age: '',
				// sex: '',
				// major: '',
				// grade: '',
				// email: '',
				file_sharing.webRegister(this.user.uname,
						this.user.pwd,
						this.user.age,
						this.user.sex,
						this.user.major,
						this.user.grade,
						this.user.email,
						this.user.phone)
					.then(resp => {
						console.log("获取设备成功：" + resp);
						if (resp.code == 20000) {
							this.$message({
								message: resp.message,
								type: 'success'
							});
							this.user.uname = undefined;
							this.user.pwd = undefined;
							this.user.pwdToo = undefined;
							this.user.age = undefined;
							this.user.sex = undefined;
							this.user.major = undefined;
							this.user.grade = undefined;
							this.user.email = undefined;

						} else {
							this.$message.error(resp.message);
						}
						this.dialogFormVisible = false




					})
					.catch(resp => {});
			}
		}
	}
</script>

<style lang="scss">
	/* 修复input 背景不协调 和光标变色 */
	/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

	// $bg:#283443;
	// $light_gray:#fff;
	// $cursor: #fff;

	// @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
	//   .login-container .el-input input {
	//     color: $cursor;
	//   }
	// }

	// /* reset element-ui css */
	// .login-container {
	//   .el-input {
	//     display: inline-block;
	//     height: 47px;
	//     width: 85%;

	//     input {
	//       background: transparent;
	//       border: 0px;
	//       -webkit-appearance: none;
	//       border-radius: 0px;
	//       padding: 12px 5px 12px 15px;
	//       color: $light_gray;
	//       height: 47px;
	//       caret-color: $cursor;

	//       &:-webkit-autofill {
	//         box-shadow: 0 0 0px 1000px $bg inset !important;
	//         -webkit-text-fill-color: $cursor !important;
	//       }
	//     }
	//   }

	//   .el-form-item {
	//     border: 1px solid rgba(255, 255, 255, 0.1);
	//     background: rgba(0, 0, 0, 0.1);
	//     border-radius: 5px;
	//     color: #454545;
	//   }
	// }
</style>

<style lang="scss" scoped>
	$bg:#2d3a4b;
	$dark_gray:#889aa4;
	$light_gray:#eee;

	.login-container {
		min-height: 100%;
		width: 100%;
		background-color: $bg;
		overflow: hidden;

		.login-form {
			position: relative;
			width: 520px;
			max-width: 100%;
			padding: 160px 35px 0;
			margin: 0 auto;
			overflow: hidden;
		}

		.tips {
			font-size: 14px;
			color: #fff;
			margin-bottom: 10px;

			span {
				&:first-of-type {
					margin-right: 16px;
				}
			}
		}

		.svg-container {
			padding: 6px 5px 6px 15px;
			color: $dark_gray;
			vertical-align: middle;
			width: 30px;
			display: inline-block;
		}

		.title-container {
			position: relative;

			.title {
				font-size: 26px;
				color: $light_gray;
				margin: 0px auto 40px auto;
				text-align: center;
				font-weight: bold;
			}
		}

		.show-pwd {
			position: absolute;
			right: 10px;
			top: 7px;
			font-size: 16px;
			color: $dark_gray;
			cursor: pointer;
			user-select: none;
		}
	}
</style>
