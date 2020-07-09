<template>
	<a-menu mode="inline">
		<a-menu-item v-for="item in addressList">
			<span class="nav-text">{{ item.name }}</span>
		</a-menu-item>
	</a-menu>
</template>

<script>
	import {service} from "../config.js"

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