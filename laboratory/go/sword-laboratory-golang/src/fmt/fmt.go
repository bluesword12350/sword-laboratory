package main

import (
	"fmt"
)

func main() {
	s := fmt.Sprintf("%016s", "0000000008551341")
	fmt.Println(s)
	b := []byte(s)
	fmt.Println(b)
}
