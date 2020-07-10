import {service} from "../config.js"

let socketClient = new WebSocket("ws://"+service.domain+"/communicate");

export const ImSocket = {
    client:socketClient,
    targetAddress:"",
}