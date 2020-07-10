<template>
	<a-menu mode="inline">
		<a-menu-item v-for="item in addressList" @click="setTargetAddress(item)">
			<span class="nav-text">{{ item.name }}</span>
		</a-menu-item>
	</a-menu>
</template>

<script>
	import {service} from "../config.js"
	import {ImSocket} from "../api/imSocket"

    export default {
        name: "AddressBook",
        data() {
            return {
				addressList : []
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
			setTargetAddress(item){
				console.log(item)
				ImSocket.targetAddress=item.address
			}
		},
        mounted(){
			this.updateAddressBook()
            setInterval(this.updateAddressBook,5000);
        }
    }
</script>

<style scoped>
</style>