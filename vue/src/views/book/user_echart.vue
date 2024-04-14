<template>
	<div class="app-container">
		<!--表单-->
		<div class="parent">
			<!--查询表单-->
			<el-form :inline="true" class="demo-form-inline">
				<el-form-item label="图表类型">
					<el-select v-model="option" placeholder="" clearable :style="{width: '100%'}">
						<el-option v-for="(item, index) in chartOptions" :key="index" :label="item.label"
							:value="item.value" :disabled="item.disabled"></el-option>
					</el-select>
				</el-form-item>

				<el-button type="primary" icon="el-icon-search" @click="setChart()">查询</el-button>

			</el-form>
		</div>
		<br>

		<div class="chart-container">
			<div id="chart" class="chart" style="height:500px;width:100%" />
		</div>
	</div>
</template>
<script>
	import echarts from "echarts";
	import bookAxios from "@/api/book";
	import axios from 'axios';
	export default {
		data() {
			return {
				option: 2,
				chart: null,
				title: "",
				xData: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
				yData: [0, 1, 2, 3, 4, 5, 6],
				chartUserData: [],
				chartBookData: [],
				chartOptions: [{
						label: "我的借阅档案类型占比",
						value: 2
					},
					{
						label: "我的借阅数量",
						value: 3
					}
				],
				deviceNameOptions: []
			};
		},
		created() {

		},
		mounted() {
			this.setChart();
		},
		methods: {
			setChart() {
				if (this.option == 1) {
					this.setUserInfoChart()
				}
				if (this.option == 2) {
					this.setBookTypeInfoChart()
				}
				if (this.option == 3) {
					this.setBootCountChart();
				}

			},
			// 读者类型
			setUserInfoChart() {

				bookAxios.getUserInfoChartAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						// this.$message.success(resp.message)
						this.chartUserData = resp.data.data
						console.log("setChart");

						// 基于准备好的dom，初始化echarts实例
						this.chart = echarts.init(document.getElementById("chart"));
						// console.log(this.chart)

						// 指定图表的配置项和数据
						var option = {
							title: {
								text: '读者类型占比',
								subtext: '',
								left: 'center'
							},
							tooltip: {
								trigger: 'item'
							},
							legend: {
								orient: 'vertical',
								left: 'left'
							},
							series: [{
								name: 'Access From',
								type: 'pie',
								radius: '50%',
								data: this.chartUserData,
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}]
						};

						this.chart.setOption(option);

					} else {
						this.$message.error(resp.message);
					}
				})


			},
			//借阅档案类型
			setBookTypeInfoChart() {


				bookAxios.getBookTypeInfoChartByUidAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						console.log("setChart");

						this.chartBookData = resp.data.data
						// 基于准备好的dom，初始化echarts实例
						this.chart = echarts.init(document.getElementById("chart"));
						// console.log(this.chart)

						// 指定图表的配置项和数据
						var option = {
							title: {
								text: '我的借阅档案类型占比',
								subtext: '',
								left: 'center'
							},
							tooltip: {
								trigger: 'item'
							},
							legend: {
								orient: 'vertical',
								left: 'left'
							},
							series: [{
								name: 'Access From',
								type: 'pie',
								radius: '50%',
								data: this.chartBookData,
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}]
						};

						this.chart.setOption(option);
					} else {
						this.$message.error(resp.message);
					}
				})

			},
			// 借阅档案数量
			setBootCountChart() {


				bookAxios.getBootCountChartUserAxios().then(resp => {
					console.log(resp)
					// this.state = 4
					if (resp.code === 20000) {
						this.xData = resp.data.xData
						this.yData = resp.data.yData
						console.log("setChart");

						// 基于准备好的dom，初始化echarts实例
						this.chart = echarts.init(document.getElementById("chart"));
						// console.log(this.chart)

						// 指定图表的配置项和数据
						var option = {
							title: {
								text: '我的借阅档案数量',
								subtext: '',
								left: 'center'
							},
							xAxis: {
								type: 'category',
								data: this.xData
							},
							yAxis: {
								type: 'value'
							},
							series: [{
								data: this.yData,
								type: 'bar'
							}]
						};

						this.chart.setOption(option);
					} else {
						this.$message.error(resp.message);
					}
				})

			},


		}
	};
</script>
