<template>
  <div class="box">
    <div id="codeEditor" class="left" ref="codeEditor"></div>
    <div id="treeEditor" class="right" ref="treeEditor"></div>
  </div>
</template>

<script>
import "jsoneditor/dist/jsoneditor.min.css"
import JSONEditor from 'jsoneditor/dist/jsoneditor.min.js';

export default {
  name: "JsonEditor",
  data() {
    return {
      jsonData : {}
    };
  },
  mounted() {
    //modes: ['code', 'form', 'text', 'tree', 'view', 'preview']
    new JSONEditor(this.$refs.codeEditor, {mode: 'code'}).set(this.jsonData)
    new JSONEditor(this.$refs.treeEditor, {mode: 'tree'}).set(this.jsonData)
  }
}
</script>

<style scoped>
.left {
  width: 50%;
  height: 100%;
}

.right {
  width: 50%;
  height: 100%;
}

.box {
  display: flex;
  height: 100%;
}
</style>