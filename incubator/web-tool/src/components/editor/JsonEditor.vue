<template>
  <div class="box">
    <div class="left" ref="codeEditor"></div>
    <div class="middle column-box">
      <button @click="letToRight()"><el-icon><Right /></el-icon></button>
      <button @click="rightToLet()"><el-icon><Back /></el-icon></button>
    </div>
    <div class="right" ref="treeEditor"></div>
  </div>
</template>

<script>
import "jsoneditor/dist/jsoneditor.min.css"
import JSONEditor from 'jsoneditor';
import {Back, Right} from "@element-plus/icons-vue";

export default {
  name: "JsonEditor",
  data() {
    return {
      codeEditor:{},
      treeEditor:{}
    }
  },
  mounted() {
    this.codeEditor = new JSONEditor(this.$refs.codeEditor, {mode: 'code'})
    this.treeEditor = new JSONEditor(this.$refs.treeEditor, {mode: 'tree'})
  },
  methods:{
    letToRight(){
      this.treeEditor.set(this.codeEditor.get())
    },
    rightToLet(){
      this.codeEditor.set(this.treeEditor.get())
    }
  },
}
</script>

<style scoped>
.left {
  flex: 56;
  height: 100%;
}

.middle {
  flex: 5;
  height: 100%;
}

.column-box{
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

.right {
  flex: 56;
  height: 100%;
}

.box {
  display: flex;
  height: 100%;
}
</style>