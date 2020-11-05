<template>
  <div class="box">
    <div class="left">
      <label for="urlDecode">普通文本</label>
      <textarea id="urlDecode" v-model="plainText"></textarea>
    </div>
    <div class="middle column-box">
      <button @click="letToRight()">==></button>
      <button @click="rightToLet()"><==</button>
    </div>
    <div class="right">
      <label for="urlEncode">URL编码</label>
      <textarea id="urlEncode" v-model="urlEncodedText"></textarea>
    </div>
  </div>
</template>

<script>
export default {
  name: "JsonEditor",
  data() {
    return {
      plainText:"",
      urlEncodedText:""
    }
  },
  mounted() {
  },
  methods:{
    letToRight(){
      this.urlEncodedText = encodeURI(this.plainText)
    },
    rightToLet(){
      this.plainText = decodeURI(this.urlEncodedText)
    }
  },
}
</script>

<style scoped>
.left {
  flex: 56;
  height: 100%;
  display:flex;
  flex-direction: column;
}

.middle {
  flex: 8;
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