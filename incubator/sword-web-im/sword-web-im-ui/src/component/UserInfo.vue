<template>
	<a-dropdown placement="bottomCenter" style="float:right; margin-top:15px">
		<a-button>{{ user.nickname }}</a-button>
		<a-menu slot="overlay">
			<a-button type="primary" @click="showUpdateModal">
				设置昵称
			</a-button>
			<a-modal v-model="visible" title="设置昵称" :footer="null" :closable="false">
				<a-form-model :model="user" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" @submit="confirmNicknameChange">
					<a-form-model-item label="昵称">
						<a-input v-model="user.nickname"/>
					</a-form-model-item>
					<a-form-model-item :wrapper-col="{ span: 12, offset: 5 }">
						<a-button type="primary" html-type="submit">确认</a-button>
					</a-form-model-item>
				</a-form-model>
			</a-modal>
		</a-menu>
	</a-dropdown>
</template>

<script>
	import Vue from 'vue';
	import {service} from "../config.js"
	import { FormModel } from 'ant-design-vue';
	import axios from "axios";

	Vue.use(FormModel)

    export default {
        name: "UserInfo",
        data() {
            return {
				user : {
					nickname : "未定义昵称"
				},
				visible: false
            };
        },
        methods:{
        	readNicknameChange(){
				let nickname = localStorage.getItem("user.nickname");
				if (nickname && nickname!=='') {
					this.user.nickname = nickname;
					this.submitNicknameChange(nickname);
				}
			},
			submitNicknameChange(nickname){
				axios.post("http://"+service.domain +"/personal-information/set-name", {name:nickname})
			},
			showUpdateModal() {
				this.visible = true;
			},
			confirmNicknameChange(e){
				e.preventDefault();
        		let nickname = this.user.nickname;
				if (nickname && nickname!=='') {
					localStorage.setItem('user.nickname', nickname);
					this.submitNicknameChange(nickname);
				}
				this.visible = false;
			}
		},
		mounted(){
			this.readNicknameChange()
		}
    }
</script>

<style scoped>
</style>