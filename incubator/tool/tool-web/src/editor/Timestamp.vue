<template>
  <div style="padding:20px">
    <a-row type="flex" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>现在：</span></a-col>
      <a-col style="padding-left: 15px"><a @click="copyTimestamp">{{nowTimestamp}}</a></a-col>
    </a-row>
    <a-row type="flex" :gutter="[horizontal,vertical]">
      <a-col style="width: 75px"><span>时间戳：</span></a-col>
      <a-col><a-input ref="timestampDom"/></a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: "Timestamp",
  data() {
    return {
      nowTimestamp: 0,
      horizontal : 8,
      vertical : 16,
    }
  },
  mounted() {
    setInterval(this.setNow,1);
  },
  methods:{
    setNow(){
      this.nowTimestamp = Date.now();
    },
    copyTimestamp() {
      this.$refs.timestampDom.setValue(this.nowTimestamp)
    }
  },
}
</script>