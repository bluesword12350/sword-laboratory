<template>
  <el-button type="primary">新建关系图</el-button>
  <el-table :data="data" style="width: 100%" @row-click="rowClick">
    <el-table-column prop="fileName" label="文件名" align="center"/>
  </el-table>
</template>

<script setup>
const data = [
  {
    "fileName":"文件1"
  }
]

function rowClick(row) {
  console.log("row",row)
}
</script>