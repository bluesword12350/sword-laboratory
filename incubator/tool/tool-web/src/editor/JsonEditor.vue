<template>
  <div>
    <div id="codeEditor" ref="codeEditor"></div>
  </div>
</template>

<script>
import "jsoneditor/dist/jsoneditor.min.css"
import JSONEditor from 'jsoneditor/dist/jsoneditor.min.js';

export default {
  name: "JsonEditor",
  mounted() {
    new JSONEditor(
        this.$refs.codeEditor,
        {
          mode: 'tree',
          modes: ['code', 'form', 'text', 'tree', 'view', 'preview']
        }
    )
  }
}
</script>

<style scoped>
#codeEditor {
  width: 500px;
  height: 500px;
}
</style>