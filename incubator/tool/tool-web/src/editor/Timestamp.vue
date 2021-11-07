<template>
  <div style="padding:20px">
    <a-row style="display: flex;align-items: center" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>现在：</span></a-col>
      <a-col style="width: 150px;"><a @click="copyTimestamp">{{nowTimestamp}}</a> 毫秒</a-col>
      <a-col style="width: 200px"><span>{{ nowDataTimeText }}</span></a-col>
    </a-row>
    <a-row style="display: flex;align-items: center" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>时间戳：</span></a-col>
      <a-col style="width: 150px"><span ref="timestampDom"/></a-col>
      <a-col style="width: 200px"><span>{{ dataTimeText }}</span></a-col>
    </a-row>
    <a-row style="display: flex;align-items: center" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>时间戳：</span></a-col>
      <a-col style="width: 230px"><a-input type="number" v-model="inputTimestamp" /></a-col>
      <a-col style="width: 50px"><a-button @click="convertTimestampToLocalDateTime">转换</a-button></a-col>
    </a-row>
    <a-row style="display: flex;align-items: center" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>时间字符：</span></a-col>
      <a-col style="width: 230px"><a-input v-model="inputTimestampText" /></a-col>
      <a-col style="width: 50px"><a-button @click="convertLocalDateTimeToTimestamp">转换</a-button></a-col>
    </a-row>
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