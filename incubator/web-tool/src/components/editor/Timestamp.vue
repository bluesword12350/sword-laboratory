<template>
  <div style="padding:20px">
    <el-row style="display: flex;align-items: center" :gutter="horizontal">
      <el-col style="width: 75px"><span>现在：</span></el-col>
      <el-col style="width: 150px;"><a @click="copyTimestamp">{{nowTimestamp}}</a> 毫秒</el-col>
      <el-col style="width: 200px"><span>{{ nowDataTimeText }}</span></el-col>
    </el-row>
    <el-row style="display: flex;align-items: center" :gutter="horizontal">
      <el-col style="width: 75px"><span>时间戳：</span></el-col>
      <el-col style="width: 150px"><span ref="timestampDom"/></el-col>
      <el-col style="width: 200px"><span>{{ dataTimeText }}</span></el-col>
    </el-row>
    <el-row style="display: flex;align-items: center" :gutter="horizontal">
      <el-col style="width: 75px"><span>时间戳：</span></el-col>
      <el-col style="width: 230px"><el-input type="number" v-model="inputTimestamp" /></el-col>
      <el-col style="width: 50px"><el-button @click="convertTimestampToLocalDateTime">转换</el-button></el-col>
    </el-row>
    <el-row style="display: flex;align-items: center" :gutter="horizontal">
      <el-col style="width: 75px"><span>时间字符：</span></el-col>
      <el-col style="width: 230px"><el-input v-model="inputTimestampText" /></el-col>
      <el-col style="width: 50px"><el-button @click="convertLocalDateTimeToTimestamp">转换</el-button></el-col>
    </el-row>
  </div>
</template>

<script>
import dayjs from "dayjs"

export default {
  name: "Timestamp",
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