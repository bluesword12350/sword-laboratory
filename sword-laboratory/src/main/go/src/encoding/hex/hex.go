package main

import (
	"encoding/hex"
	"fmt"
)

func main() {
	test, _ := hex.DecodeString("b59e8c0e79a8496b8d03c96c0cb13ff9")
	fmt.Println(test)
}
