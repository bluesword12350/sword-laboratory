<template>
  <div class="box">
    <div class="left">
      <label>普通文本</label>
      <textarea id="urlDecode" v-model="plainText"></textarea>
    </div>
    <div class="middle column-box">
      <button @click="letToRight()"><el-icon><Right /></el-icon></button>
      <button @click="rightToLet()"><el-icon><Back /></el-icon></button>
    </div>
    <div class="right">
      <label>URL编码</label>
      <textarea id="urlEncode" v-model="urlEncodedText"></textarea>
    </div>
  </div>
</template>

<script>
import {Back, Right} from "@element-plus/icons-vue";

export default {
  name: "UrlEditor",
  components: {Back, Right},
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