<template>
  <div class="app-container">
    <div class="parent">
      <!--查询表单-->
      <el-form :inline="true" class="demo-form-inline">
        <!--        <div style="width: 200px;">
          <el-input v-model="targetFloorNumber" placeholder="请输宿舍楼号" style="margin-bottom: 20px;"></el-input>
          <el-input v-model="targetDormitoryNumber" placeholder="请输入宿舍号" style="margin-bottom: 20px;"></el-input>

          <el-button type="primary" @click="register()" style="margin-left: 150px;">提交</el-button>
        </div> -->
        <!-- 标题 -->
        <el-form-item label="查询条件">
          <el-radio-group v-model="state" size="medium">
            <el-radio v-for="(item, index) in stateOptions" :key="index" :label="item.value" :disabled="item.disabled"
              style="margin-bottom: 20px;">{{item.label}}</el-radio>
          </el-radio-group>
        </el-form-item>


        <el-button type="primary" icon="el-icon-search" @click="getHistoryList(1)" style="margin-left: 20px;">查询</el-button>
        <br />
        账号：<el-input style="width: 150px;" v-model="acct"></el-input>
        <span style="margin-left: 20px;">密码：</span>
        <el-input style="width: 150px;" v-model="pwd"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="addAccountNumber()" style="margin-left: 20px;">添加</el-button>
        <!-- <el-button type="default" @click="resetData()">清空</el-button> -->
      </el-form>
    </div>
    <br>
    <!-- 表格 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="数据加载中" border fit highlight-current-row
      row-class-name="myClassList">
      <el-table-column label="账号" align="center">
        <template slot-scope="scope">{{ scope.row.acct }}</template>
      </el-table-column>
      <el-table-column label="密码" align="center">
        <template slot-scope="scope">{{ scope.row.pwd }}</template>
      </el-table-column>
      <el-table-column label="时间" align="center">
        <template slot-scope="scope">{{ scope.row.signDate == null?'队列中......':formatTimer(scope.row.signDate) }}</template>
      </el-table-column>

      <el-table-column label="状态" width="150" align="center">
        <div :style="{'color':scope.row.state=='成功'? 'green':'red'}" slot-scope="scope">{{ scope.row.state }}</div>

 <!--       <span v-if="scope.row.state == '成功'"> 成功</span> -->
      </el-table-column>




      <!--     <el-table-column label="操作" width="150" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" icon="el-icon-success" @click="setSuccess(scope.row.id)">同意</el-button><br />
          <el-button type="text" size="mini" icon="el-icon-error" @click="setError(scope.row.id)">拒绝</el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <!-- 分页 -->
    <el-pagination :current-page="page" :page-size="size" :total="total" style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper" @current-change="getHistoryList" />
  </div>
</template>

<script>
  import miuiver from "@/api/miuiver";

  export default {
    data() {
      return {
        listLoading: false, // 是否显示loading信息
        list: null, // 数据列表
        page: 1,
        size: 10,
        total: 0,

        //自定义参数开始------
        acct:'',
        pwd:'',
        state:3, //状态选择栏的状态

        stateOptions: [{
            label: "账号",
            value: 4
          },{
            label: "全部状态",
            value: 3
          },
          {
            label: "成功",
            value: 1
          },
          {
            label: "失败",
            value: 2
          },

        ]

         //自定义参数结束------
      };
    },

    created() {
      this.getHistoryList(1);
    },

    methods: {
      addAccountNumber(){
        miuiver.addAccountNumber(this.acct,this.pwd).then(resp=>{
          console.log(resp)
          this.state = 4
          if(resp.code === 20000){
            this.$message.success(resp.message)
          }
          this.getHistoryList(this.page)
        })
      },
      //获取历史记录
      getHistoryList(page = 0) {
        console.log(this.state)
        this.page = page
        miuiver.getSignInHistory(page, this.size,this.state).then(resp => {

          console.log(resp)
          this.list = resp.data.list
          this.total = resp.data.total

        })

      },
      //时间格式化
      formatTimer: function(value) {
        console.log("时间" + value);

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
  };
</script>
<style scoped>
  .myClassList .info {
    width: 450px;
    overflow: hidden;
  }

  .myClassList .info .pic {
    width: 150px;
    height: 90px;
    overflow: hidden;
    float: left;
  }

  .myClassList .info .pic a {
    display: block;
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
  }

  .myClassList .info .pic img {
    display: block;
    width: 100%;
  }

  .myClassList td .info .title {
    width: 280px;
    float: right;
    height: 90px;
  }

  .myClassList td .info .title a {
    display: block;
    height: 48px;
    line-height: 24px;
    overflow: hidden;
    color: #00baf2;
    margin-bottom: 12px;
  }

  .myClassList td .info .title p {
    line-height: 20px;
    margin-top: 5px;
    color: #818181;
  }

  .parent {
    width: 5600px;
    /* height: 200px; */
    /* border: 1px solid #f00; */
    display: table-cell;
    text-align: center;
    vertical-align: middle;
  }
</style>
