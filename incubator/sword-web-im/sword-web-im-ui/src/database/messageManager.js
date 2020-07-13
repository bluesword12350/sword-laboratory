export const messageManager = {
    messageLog : {
        messageLogList:[],
        getAll() {
            return this.messageLogList;
        },
        put(item){
            this.messageLogList.push(item);
        }
    },
    addressInfo : {
        addressMap : new Map([]),
        setAllAddress(addressList) {
            this.addressMap.clear();
            for(let i in addressList){
                this.addressMap.set(addressList[i].address,addressList[i].name)
            }
        },
        getNameByAddress(address) {
            return this.addressMap.get(address)
        }
    }

}