let request = window.indexedDB.open("SwordIm",1);

request.onerror = function(event) {
    console.error(event)
};

request.onsuccess = function(event) {
    SwordImDataBase.database = event.target.result;
};

request.onupgradeneeded = function(event) {
    let db = event.target.result;
    db.createObjectStore(SwordImDataBase.addressListStoreName, {keyPath: "address"});
};

export const SwordImDataBase = {
    addressListStoreName:"addressList"
}