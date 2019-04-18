package main

import (
	"fmt"
	"io/ioutil"
)

func main() {
	myFolder := "D:/workspace/bluesword/leetcode/solution"
	files, _ := ioutil.ReadDir(myFolder) //读取目录下的文件
	for _, file := range files {
		if file.IsDir() { //判断是否是目录
			fmt.Println(file.Name())
		} else {
			continue
		}
	}
}
