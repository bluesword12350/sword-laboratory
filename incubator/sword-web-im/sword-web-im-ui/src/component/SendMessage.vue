<template>
	<a-form-model :wrapper-col="{ span: 12 }">
		<a-textarea v-model="message"/>
		<a-button type="primary" @click="send" style="float:right">发送</a-button>
	</a-form-model>
</template>

<script>
	import {SwordImDataBase} from "../database/indexed.js"
	import {service} from "../config.js"
	import {ImSocket} from "../api/imSocket"

	export default {
		name: "SendMessage",
		data() {
			return {
				message:""
			}
		},
		methods:{
			send(){
				ImSocket.client.send(JSON.stringify(
					{
					type:"text",
					targetAddress:ImSocket.targetAddress,
					text:this.message
					}
				))
				this.message = ""
			}
		}
	}
</script>

<style scoped>
	.ant-form,
	form textarea.ant-input {
		height: 80%;
	}
</style>