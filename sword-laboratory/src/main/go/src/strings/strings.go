package main

import (
	"fmt"
	"strings"
)

func main() {
	split := strings.Split("001. Two Sum", ".")                   //用指定字符串分割字符串
	fmt.Print("0" + split[0] + "." + strings.TrimSpace(split[1])) //TrimSpace (去除字符串前后的空白)
}
