<template>
	<a-form-model :wrapper-col="{ span: 12 }">
		<a-textarea v-model="message"/>
		<a-button type="primary" @click="send" style="float:right">发送</a-button>
	</a-form-model>
</template>

<script>
	import {ImSocket} from "../api/imSocket"
	import {messageManager} from "../database/messageManager"

	export default {
		name: "SendMessage",
		data() {
			return {
				message:""
			}
		},
		methods:{
			send(){
				let targetAddress = ImSocket.targetAddress;
				if (!this.message || this.message==="" || !targetAddress || targetAddress===""){
					return
				}
				let sendData = {
					type:"text",
					targetAddress:targetAddress,
					originAddress:"",
					text:this.message
				}
				ImSocket.client.send(JSON.stringify(sendData))
				sendData.sourceType = 'sendOut';
				let nickname = localStorage.getItem("user.nickname");
				sendData.origin = nickname?nickname:"我"
				sendData.target = messageManager.addressInfo.getNameByAddress(targetAddress);
				messageManager.messageLog.put(sendData)
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