import {service} from "../config.js"
import {messageManager} from "../database/messageManager.js"

let socketClient = new WebSocket("ws://"+service.domain+"/communicate");
socketClient.onmessage = function (event) {
    let data = JSON.parse(event.data);
    data.sourceType = 'receive';
    data.origin = messageManager.addressInfo.getNameByAddress(data.originAddress);
    data.target = messageManager.addressInfo.getNameByAddress(data.targetAddress);
    messageManager.messageLog.put(data)
}

export const ImSocket = {
    client:socketClient,
    targetAddress:"",
}