import {service} from "../config.js"
import {messageLogList} from "../database/log"

let socketClient = new WebSocket("ws://"+service.domain+"/communicate");
socketClient.onmessage = function (event) {
    console.log(event.data)
    let data = JSON.parse(event.data);
    data.sourceType = 'receive';
    messageLogList.push(data)
}

export const ImSocket = {
    client:socketClient,
    targetAddress:"",
}