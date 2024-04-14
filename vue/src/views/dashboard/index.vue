
<template>
  <div>
   首页
  </div>
</template>

<script>
import vip from "@/api/vip";
import device from "@/api/device";
import { getToken, removeToken } from "@/utils/auth";
export default {
  components: {},

  props: [],
  data() {
    return {
        list:[1,2],
      length:2,
      vipDate: undefined // 是否显示loading信息
    };
  },
  computed: {},
  watch: {},
  created() {
    this.initDtae();
  },
  mounted() {},
  methods: {

    initDtae(){
        device.selectIndexDeviceByUid().then(resp=>{

          this.list = resp.data.list
          console.log(this.list.length);

        })
    },

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
    }
  }
};
</script>

