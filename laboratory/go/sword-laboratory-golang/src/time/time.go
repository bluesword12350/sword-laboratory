package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Print(time.Now().Unix() / (30 * 60))
}
