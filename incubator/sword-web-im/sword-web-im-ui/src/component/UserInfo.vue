<template>
	<a-dropdown placement="bottomCenter" style="float:right">
		<a-button>{{ user.nickname }}</a-button>
		<a-menu slot="overlay">
			<a-button type="primary" @click="showUpdateModal">
				设置昵称
			</a-button>
			<a-modal v-model="visible" title="设置昵称" :footer="null">
				<a-form :form="userForm" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
					<a-form-item label="昵称">
						<a-input
							v-decorator="['nickname']"
							@change="nicknameChange"
						/>
					</a-form-item>
				</a-form>
			</a-modal>
		</a-menu>
	</a-dropdown>
</template>

<script>
	import Vue from 'vue';
	import {service} from "../config.js"
	import {SwordImDataBase} from "../database/indexed.js"
	import Form from 'ant-design-vue'

	Vue.use(Form)

    export default {
        name: "UserInfo",
        data() {
            return {
				user : {
					nickname : "未定义昵称"
				},
				visible: false,
				userForm : this.$form.createForm(this, { name: 'user' })
            };
        },
        methods:{
			updateAddressBook(){
				fetch("http://"+service.domain +"/address-list/all")
					.then(response => response.json())
					.then( data => {
						this.addressList = data
					})
            },
			showUpdateModal() {
				this.visible = true;
			},
			nicknameChange(e) {
				if (e.target._value !== '') {
					this.user.nickname = e.target._value;
				}
			}
		}
    }
</script>

<style scoped>
</style>