<template>
  <div style="padding:20px">
    <el-row>
      <el-col :span="2"><span>现在：</span></el-col>
      <el-col :span="4"><a @click="copyTimestamp">{{nowTimestamp}}</a> 毫秒</el-col>
      <el-col :span="4"><span>{{ nowDataTimeText }}</span></el-col>
    </el-row>
    <el-row>
      <el-col :span="2"><span>时间戳：</span></el-col>
      <el-col :span="4"><span ref="timestampDom"/></el-col>
      <el-col :span="4"><span>{{ dataTimeText }}</span></el-col>
    </el-row>
    <el-row>
      <el-col :span="2"><span>时间戳：</span></el-col>
      <el-col :span="4"><el-input type="number" v-model="inputTimestamp" /></el-col>
      <el-col :span="4"><el-button @click="convertTimestampToLocalDateTime">转换</el-button></el-col>
    </el-row>
    <el-row>
      <el-col :span="2"><span>时间字符：</span></el-col>
      <el-col :span="4"><el-input v-model="inputTimestampText" /></el-col>
      <el-col :span="4"><el-button @click="convertLocalDateTimeToTimestamp">转换</el-button></el-col>
    </el-row>
  </div>
</template>

<script>
import dayjs from "dayjs"
import {ElRow,ElCol} from "element-plus";

export default {
  name: "Timestamp",
  components:[ElRow,ElCol],
  data() {
    return {
      nowTimestamp: 0,
      nowDataTimeText: "",
      dataTimeText:"",
      horizontal : 8,
      vertical : 16,
      inputTimestamp: "",
      inputTimestampText: ""
    }
  },
  mounted() {
    setInterval(this.setNow,0);
  },
  methods:{
    setNow(){
      this.nowTimestamp = Date.now();
      this.nowDataTimeText = dayjs(this.nowTimestamp).format();
    },
    copyTimestamp() {
      this.$refs.timestampDom.innerHTML= this.nowTimestamp
      this.dataTimeText = this.nowDataTimeText;
    },
    convertTimestampToLocalDateTime(){
      this.inputTimestampText = dayjs(Number(this.inputTimestamp)).format();
    },
    convertLocalDateTimeToTimestamp(){
      this.inputTimestamp = dayjs(this.inputTimestampText).valueOf();
    }
  },
}
</script>

<style>
.el-row {
  margin-bottom: 20px;
}
</style>