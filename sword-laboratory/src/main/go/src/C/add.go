package main

/*
// C 标志io头文件，你也可以使用里面提供的函数
#include <stdio.h>
int add(int a,int b){
    return a+b;
}
*/
import "C" // 切勿换行再写这个

import "fmt"

func main() {
	fmt.Println(C.add(2, 1))
}
