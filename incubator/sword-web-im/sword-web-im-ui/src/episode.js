function saveAddressList(data) {
    let siDb = SwordImDataBase.database
    let transaction = siDb.transaction(SwordImDataBase.addressListStoreName, "readwrite");
    transaction.onerror = function (event) {
        console.error(event)
    };
    let addressListStore = transaction.objectStore(SwordImDataBase.addressListStoreName);
    addressListStore.clear()
    data.forEach(function (address) {
        addressListStore.add(address);
    })
}
function readAddressList(){
    let selfVue = this;
    let siDb = SwordImDataBase.database
    let dbReq = siDb.transaction(SwordImDataBase.addressListStoreName).objectStore(SwordImDataBase.addressListStoreName).getAll()
    dbReq.onerror = function (event) {
        console.error(event)
    }
    dbReq.onsuccess = function () {
        selfVue.addressList = dbReq.result
        console.log(selfVue)
    }
}