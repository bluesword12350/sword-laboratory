package main

/*
#include "add.c"
*/
import "C"

import "fmt"

func main() {
	s := C.sub(5, 6)
	fmt.Println(s)
}
