<template>
  <div class="box">
    <div class="left">
      <textarea id="jsonText" v-model="jsonText" v-on:change="jsonTextFormat()"></textarea>
    </div>
    <div class="right">
      <textarea id="jsonFormat" v-model="jsonFormat" disabled="true"></textarea>
    </div>
  </div>
</template>

<script>

export default {
  name: "JsonEditor2",
  data() {
    return {
      jsonText:"",
      jsonFormat:""
    }
  },
  methods : {
    jsonTextFormat(){
      this.jsonFormat = JSON.stringify(JSON.parse(this.jsonText),null,4).toString()
          .replace(new RegExp("\\\\\"","gm"),"\"")
    },
  }
}
</script>

<style scoped>
.left {
  flex: 56;
  height: 100%;
  display:flex;
  flex-direction: column;
}

.right {
  flex: 56;
  height: 100%;
  display:flex;
  flex-direction: column;
}

.box {
  display: flex;
  height: 100%;
}

textarea {
  height: 98%;
  resize: none;
}
</style>