<template>
  <el-table :data="data" style="width: 99vw">
    <el-table-column prop="fileName" label="文件名" align="center"/>
  </el-table>
</template>

<script lang="ts" setup>
const data = [
  {
    "fileName":"文件1"
  }
]
</script>