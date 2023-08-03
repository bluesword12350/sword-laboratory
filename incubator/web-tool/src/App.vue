<script setup>
import {BottomRight,Document,Calendar,Link} from '@element-plus/icons-vue'
import {ElMenu} from "element-plus";
</script>

<template>
  <el-container class="container">
    <el-aside>
      <el-menu router>
        <el-menu-item index="/json-editor">
          <el-icon><Document /></el-icon>
          <span>Json编辑器</span>
        </el-menu-item>
        <el-menu-item index="/dislodge-escape">
          <el-icon><BottomRight /></el-icon>
          <span>去除转义</span>
        </el-menu-item>
        <el-menu-item index="/url-editor">
          <el-icon><Link /></el-icon>
          <span>URL编码</span>
        </el-menu-item>
        <el-menu-item index="/timestamp">
          <el-icon><Calendar /></el-icon>
          <span>时间</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<style>
.container{
  height: 100vh;
}
</style>
