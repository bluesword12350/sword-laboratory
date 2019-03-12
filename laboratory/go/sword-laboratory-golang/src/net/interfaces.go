package main

import (
	"fmt"
	"net"
)

//获取本机mac地址
func main() {
	interfaces, _ := net.Interfaces()
	for _, inter := range interfaces {
		mac := inter.HardwareAddr
		fmt.Println(mac)
	}
}
