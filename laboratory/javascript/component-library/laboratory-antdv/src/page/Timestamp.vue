<template>
  <div>
    <h1 class="center-text">{{`${now} 毫秒`}}</h1>
    <a-config-provider :locale="locale">
      <a-date-picker showTime/>
    </a-config-provider>
  </div>
</template>

<script>
import zhCN from 'ant-design-vue/es/locale/zh_CN';
import 'dayjs/locale/zh-cn';

export default {
    data() {
        return {
            now : Date.now(),
            locale : zhCN,
        };
    },
    methods:{
        setNow(){
            this.now = Date.now();
        }
    },
    mounted(){
        setInterval(this.setNow,1);
    }
}
</script>

<style scoped>
    .center-text{
        text-align:center;
    }
</style>