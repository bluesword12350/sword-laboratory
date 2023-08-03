<template>
  <div class="box">
    <div class="left">
      <textarea v-model="escapeText" v-on:change="jsonTextFormat()"></textarea>
    </div>
    <div class="right">
      <textarea v-model="dislodgeEscape" disabled></textarea>
    </div>
  </div>
</template>

<script>

export default {
  name: "DislodgeEscape",
  data() {
    return {
      escapeText:"",
      dislodgeEscape:""
    }
  },
  methods : {
    jsonTextFormat(){
      this.dislodgeEscape = this.escapeText.replace(new RegExp("\\\\\"","gm"),"\"")
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