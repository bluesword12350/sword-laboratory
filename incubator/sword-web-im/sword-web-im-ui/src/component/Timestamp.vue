<template>
    <h1 class="center-text">{{`${now} 毫秒`}}</h1>
</template>

<script>
    export default {
        name: "Timestamp",
        data() {
            return {
                now : Date.now(),
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