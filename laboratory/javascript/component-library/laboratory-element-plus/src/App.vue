<script setup>
import {ElMenu}  from "element-plus";
import {Setting} from '@element-plus/icons-vue'
</script>

<template>
  <el-container>
    <el-aside>
      <el-menu>
        <el-menu-item route="/timestamp">
          <el-icon><setting /></el-icon>
          <span>时间戳</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<style>
</style>
