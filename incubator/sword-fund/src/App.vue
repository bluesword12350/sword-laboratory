<template>
  <a-table :columns="columns" :data-source="data" >
    <div slot="sellTime" slot-scope="time">{{time | formatDate(time)}}</div>
    <span slot="type" slot-scope="type">{{type ? "是" : "否"}}</span>
  </a-table>
</template>

<script>
import axios from "axios"
import dayjs from "dayjs"

const columns = [
  {
    title: '基金编码',
    dataIndex: 'fields["基金编码"]',
    width: 50
  },
  {
    title: '基金名称',
    dataIndex: 'fields["基金名称"]',
    width: 150
  },
  {
    title: '可卖时间',
    dataIndex: 'fields["可卖时间"]',
    scopedSlots: { customRender: 'sellTime' },
    sorter: (a, b) => a.fields["可卖时间"] - b.fields["可卖时间"],
    width: 150
  },
  {
    title: '当前是否可卖',
    dataIndex: 'fields["当前是否可卖"]',
    scopedSlots: { customRender: 'type' },
    width: 150
  },
];

export default {
  name: "App",
  data() {
    return {
      data : [],
      columns,
    };
  },
  methods:{
    getFund(){
      let vueApp = this;
      axios({
        method:'get',
        url:'https://api.vika.cn/fusion/v1/datasheets/dsto5X91Hd2J4XavQS/records?viewId=viwAyeJV6i20V&fieldKey=name',
        headers: {'Authorization': 'Bearer uskEFgxQSzREdYd5gQwKsgs'}
      }).then(function (response) {
        vueApp.data = response.data.data.records;
        console.log(vueApp.data)
      })
    }
  },
  filters: {
    formatDate(time) {
      return dayjs(time).format();
    }
  },
  mounted(){
    this.getFund();
  }
};
</script>

<style>
</style>
