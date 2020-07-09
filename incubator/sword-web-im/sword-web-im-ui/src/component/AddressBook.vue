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
			// saveAddressList(data) {
			// 	let siDb = SwordImDataBase.database
			// 	let transaction = siDb.transaction(SwordImDataBase.addressListStoreName, "readwrite");
			// 	transaction.onerror = function (event) {
			// 		console.error(event)
			// 	};
			// 	let addressListStore = transaction.objectStore(SwordImDataBase.addressListStoreName);
			// 	addressListStore.clear()
			// 	data.forEach(function (address) {
			// 		addressListStore.add(address);
			// 	})
			// },
			// readAddressList(){
			// 	let selfVue = this;
			// 	let siDb = SwordImDataBase.database
			// 	let dbReq = siDb.transaction(SwordImDataBase.addressListStoreName).objectStore(SwordImDataBase.addressListStoreName).getAll()
			// 	dbReq.onerror = function (event) {
			// 		console.error(event)
			// 	}
			// 	dbReq.onsuccess = function () {
			// 		selfVue.addressList = dbReq.result
			// 		console.log(selfVue)
			// 	}
			// }
		},
        mounted(){
			this.updateAddressBook()
            setInterval(this.updateAddressBook,5000);
        }
    }
</script>

<style scoped>
</style>